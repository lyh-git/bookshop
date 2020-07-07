package com.bookshop.dao;

import java.util.List;

import com.bookshop.entity.User;

public interface UserDao {

    // insert
    int insert(User user);

    // delete
    int delete(Integer id);

    // update
    int update(User user);

    // queryAll
    List<User> queryAll();

    // queryById
    User queryById(Integer adminId);

    User login(User user);

}
