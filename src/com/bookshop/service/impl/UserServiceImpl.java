package com.bookshop.service.impl;

import java.util.List;

import com.bookshop.dao.UserDao;
import com.bookshop.dao.impl.UserDaoImpl;
import com.bookshop.entity.User;
import com.bookshop.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao adminDao = new UserDaoImpl();

    @Override
    public int insert(User user) {
         
        return adminDao.insert(user);
    }

    @Override
    public int delete(Integer id) {
         
        return adminDao.delete(id);
    }

    @Override
    public int update(User user) {
         
        return adminDao.update(user);
    }

    @Override
    public List<User> queryAll() {
         
        return adminDao.queryAll();
    }

    @Override
    public User queryById(Integer id) {
        
        return adminDao.queryById(id);
    }

    @Override
    public User login(User user) {
         
        return adminDao.login(user);
    }

    @Override
    public int register(User user) {
        // 目前设置默认等级为5
        user.setLevel(5);
        return adminDao.insert(user);
    }

}
