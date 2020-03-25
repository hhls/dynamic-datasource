package com.hhls.service.impl;

import com.hhls.dao.IUserDao;
import com.hhls.dbRouting.annotation.Router;
import com.hhls.pojo.User;
import com.hhls.service.IUserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author hhls Date: 2019-08-09 Time: 下午12:05
 * @version $Id$
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Router
    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    @Router
    public int deleteByuserNum(User user) {
        return userDao.deleteByuserNum(user);
    }

    @Override
    @Router
    public int updateByUserNum(User user) {
        return userDao.updateByUserNum(user);
    }

    @Override
    @Router
    public User selectByUserNum(User user) {
        return userDao.selectByUserNum(user);
    }
}
