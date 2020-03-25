package com.hhls.service;


import com.hhls.pojo.User;

/**
 * @author hhls Date: 2019-08-09 Time: 下午12:05
 * @version $Id$
 */
public interface IUserService {

    int insertUser(User user);

    int deleteByuserNum(User user);

    int updateByUserNum(User user);

    User selectByUserNum(User user);

}
