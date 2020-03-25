package com.hhls.service;

import com.hhls.dbRouting.DbContextHolder;
import com.hhls.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xiaodongw_3 Date: 2020-03-25 Time: 下午5:59
 * @version $Id$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class TestUserService {

    @Autowired
    private IUserService userService;

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUserNum("wergsgdf3243");
        user.setUserName("admin");
        user.setAge(23);
        user.setPassword("adf23");
        int re = userService.insertUser(user);
        System.out.println(
            DbContextHolder.getDbKey() + "库 " + DbContextHolder.getTableIndex() + "表 的插入结果:" + re);
    }

    @Test
    public void testDeleteByuserNum() {
        User user = new User();
        user.setUserNum("wergsgdf3243");
        int re = userService.deleteByuserNum(user);
        System.out.println(
            DbContextHolder.getDbKey() + "库 " + DbContextHolder.getTableIndex() + "表 的删除结果:" + re);
    }

    @Test
    public void testupdateByUserNum() {
        User user = new User();
        user.setUserNum("wergsgdf3243");
        user.setAge(34);
        int re = userService.updateByUserNum(user);
        System.out.println(
            DbContextHolder.getDbKey() + "库 " + DbContextHolder.getTableIndex() + "表 的更新结果:" + re);
    }

    @Test
    public void testQueryUserByNum() {
        User user = new User();
        user.setId(1);
        user.setUserNum("wergsgdf3243");
        User userDb = userService.selectByUserNum(user);
        System.out
            .println(DbContextHolder.getDbKey() + "库 " + DbContextHolder.getTableIndex() + "表 的查询结果:" + user);
    }
}