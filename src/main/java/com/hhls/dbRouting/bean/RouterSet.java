package com.hhls.dbRouting.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author hhls Date: 2019-08-09 Time: 下午12:05
 * @version $Id$
 */
public class RouterSet implements Serializable {

    private static final long serialVersionUID = 8154654964420279493L;
    /**
     * 数据库表的逻辑KEY,与数据源MAP配置中的key一致
     */
    private List<String> dbKeyArray;
    /**
     * 数据库数量
     */
    private int dbNumber;
    /**
     * 数据表数量
     */
    private int tableNumber;
    /**
     * 数据表index样式
     */
    private String tableIndexStyle;
    /**
     * Id开始
     */
    private String routeFieldStart;
    /**
     * Id结束
     */
    private String routeFieldEnd;
    /**
     * 规则类型
     */
    private int ruleType;
    /**
     * 路由类型类型
     */
    private int routeType;

    public List<String> getDbKeyArray() {
        return dbKeyArray;
    }

    public void setDbKeyArray(List<String> dbKeyArray) {
        this.dbKeyArray = dbKeyArray;
    }

    public int getDbNumber() {
        return dbNumber;
    }

    public void setDbNumber(int dbNumber) {
        this.dbNumber = dbNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getTableIndexStyle() {
        return tableIndexStyle;
    }

    public void setTableIndexStyle(String tableIndexStyle) {
        this.tableIndexStyle = tableIndexStyle;
    }

    public String getRouteFieldStart() {
        return routeFieldStart;
    }

    public void setRouteFieldStart(String routeFieldStart) {
        this.routeFieldStart = routeFieldStart;
    }

    public String getRouteFieldEnd() {
        return routeFieldEnd;
    }

    public void setRouteFieldEnd(String routeFieldEnd) {
        this.routeFieldEnd = routeFieldEnd;
    }

    public int getRuleType() {
        return ruleType;
    }

    public void setRuleType(int ruleType) {
        this.ruleType = ruleType;
    }

    public int getRouteType() {
        return routeType;
    }

    public void setRouteType(int routeType) {
        this.routeType = routeType;
    }

    @Override
    public String toString() {
        return "RouterSet{" +
            "dbKeyArray=" + dbKeyArray +
            ", dbNumber=" + dbNumber +
            ", tableNumber=" + tableNumber +
            ", tableIndexStyle='" + tableIndexStyle + '\'' +
            ", routeFieldStart='" + routeFieldStart + '\'' +
            ", routeFieldEnd='" + routeFieldEnd + '\'' +
            ", ruleType=" + ruleType +
            ", routeType=" + routeType +
            '}';
    }

    public static class ROUTER_TYPE {

        /**
         * 对库路由
         */
        public final static int DB = 0;

        /**
         * 对表路由
         */
        public final static int TABLE = 1;

        /**
         * 分库分表
         */
        public final static int DB_AND_TABLE = 2;
    }

    public static class RULE_TYPE {

        /**
         * 根据字符串类型规则路由
         */
        public final static int STR = 3;
    }
}
