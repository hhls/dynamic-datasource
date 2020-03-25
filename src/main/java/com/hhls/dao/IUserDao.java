package com.hhls.dao;

import com.hhls.pojo.User;

/**
 * @author hhls Date: 2019-08-09 Time: 下午12:05
 * @version $Id$
 */
public interface IUserDao {

    int insertUser(User user);

    int deleteByuserNum(User user);

    int updateByUserNum(User user);

    User selectByUserNum(User user);
}