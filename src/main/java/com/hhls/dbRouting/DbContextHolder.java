package com.hhls.dbRouting;


/**
 * 动态数据源实现中KEY的存放工具类：使用ThreadLocal本地线程的方式来保证线程安全
 *
 * @author hhls Date: 2019-08-09 Time: 下午12:05
 * @version $Id$
 */
public class DbContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    private static final ThreadLocal<String> tableIndexHolder = new ThreadLocal<String>();

    public static String getDbKey() {
        return (String) contextHolder.get();
    }

    /**
     * db 本地线程
     */
    public static void setDbKey(String dbKey) {
        contextHolder.set(dbKey);
    }

    public static void clearDbKey() {
        contextHolder.remove();
    }

    public static String getTableIndex() {
        return (String) tableIndexHolder.get();
    }

    /**
     * table 本地线程
     */
    public static void setTableIndex(String tableIndex) {
        tableIndexHolder.set(tableIndex);
    }

    public static void clearTableIndex() {
        tableIndexHolder.remove();
    }


}