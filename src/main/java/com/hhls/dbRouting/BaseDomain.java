package com.hhls.dbRouting;

import java.io.Serializable;

/**
 * 所有pojo必须继承此bean, 才能使用分库分表
 *
 * @author hhls Date: 2019-08-09 Time: 下午12:05
 * @version $Id$
 */
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = -1194044932021011464L;

    private String userNum;

    private String tableIndex;

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getTableIndex() {
        this.tableIndex = DbContextHolder.getTableIndex();
        return tableIndex;
    }

    public void setTableIndex(String tableIndex) {
        this.tableIndex = tableIndex;
    }

}
