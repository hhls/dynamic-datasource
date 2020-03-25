package com.hhls.dbRouting.router;

import com.hhls.dbRouting.DBRouter;
import com.hhls.dbRouting.DbContextHolder;
import com.hhls.dbRouting.annotation.RouterConstants;
import com.hhls.dbRouting.bean.RouterSet;
import java.text.DecimalFormat;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

/**
 * 根据指定变量动态切 库和表
 *
 * @author hhls Date: 2019-08-09 Time: 下午12:05
 * @version $Id$
 */
public class DBRouterImpl implements DBRouter {

    private static final Logger log = LoggerFactory.getLogger(DBRouterImpl.class);

    /**
     * 配置列表
     */
    private List<RouterSet> routerSetList;

    /**
     * 若表风格后缀style='_0000', tbIndex=2
     * 则输出_0002
     */
    private static String getFormateTableIndex(String style, long tbIndex) {
        DecimalFormat df = new DecimalFormat();
        if (StringUtils.isEmpty(style)) {
            style = RouterConstants.ROUTER_TABLE_SUFFIX_DEFAULT;//在格式后添加诸如单位等字符
        }
        df.applyPattern(style);
        return df.format(tbIndex);
    }

    @Override
    public String doRoute(String fieldId) {
        if (StringUtils.isEmpty(fieldId)) {
            throw new IllegalArgumentException("dbsCount and tablesCount must be both positive!");
        }
        int routeFieldInt = RouterUtils.getResourceCode(fieldId);
        return getDbKey(routerSetList, routeFieldInt);
    }

    @Override
    public String doRouteByResource(String resourceCode) {
        if (StringUtils.isEmpty(resourceCode)) {
            throw new IllegalArgumentException("dbsCount and tablesCount must be both positive!");
        }
        int routeFieldInt = Integer.valueOf(resourceCode);
        return getDbKey(routerSetList, routeFieldInt);
    }

    /**
     * 根据数据字段来判断属于哪个段的规则, 获得数据库key
     */
    private String getDbKey(List<RouterSet> routerSets, int routeFieldInt) {
        if (CollectionUtils.isEmpty(routerSets)) {
            throw new IllegalArgumentException("dbsCount and tablesCount must be both positive!");
        }
        String dbKey = null;
        for (RouterSet item : routerSets) {
            if (item.getRuleType() == RouterSet.RULE_TYPE.STR) {
                if (item.getDbKeyArray() != null && item.getDbNumber() != 0) {
                    long dbIndex = 0;
                    long tbIndex = 0;
                    long mode;
                    // 后续改成策略模式
                    if (item.getRouteType() == RouterSet.ROUTER_TYPE.DB_AND_TABLE && item.getTableNumber() != 0) {
                        mode = item.getDbNumber() * item.getTableNumber();
                        dbIndex = routeFieldInt % mode / item.getTableNumber();
                        tbIndex = routeFieldInt % item.getTableNumber();
                        String tableIndex = getFormateTableIndex(item.getTableIndexStyle(), tbIndex);
                        DbContextHolder.setTableIndex(tableIndex);
                    } else if (item.getRouteType() == RouterSet.ROUTER_TYPE.DB) {
                        mode = item.getDbNumber();
                        dbIndex = routeFieldInt % mode;
                    } else if (item.getRouteType() == RouterSet.ROUTER_TYPE.TABLE) {
                        tbIndex = routeFieldInt % item.getTableNumber();
                        String tableIndex = getFormateTableIndex(item.getTableIndexStyle(), tbIndex);
                        DbContextHolder.setTableIndex(tableIndex);
                    }
                    dbKey = item.getDbKeyArray().get(Long.valueOf(dbIndex).intValue());
                    log.debug("getDbKey resource:{}------->dbkey:{},tableIndex:{},", routeFieldInt, dbKey, tbIndex);
                    DbContextHolder.setDbKey(dbKey);
                }
                break;
            }
        }
        return dbKey;
    }

    public List<RouterSet> getRouterSetList() {
        return routerSetList;
    }

    public void setRouterSetList(List<RouterSet> routerSetList) {
        this.routerSetList = routerSetList;
    }
}
