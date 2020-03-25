package com.hhls.dbRouting.datasource;

import com.hhls.dbRouting.DbContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author hhls Date: 2019-08-09 Time: 下午12:05
 * @version $Id$
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        //获取当前数据源
        return DbContextHolder.getDbKey();
    }

}