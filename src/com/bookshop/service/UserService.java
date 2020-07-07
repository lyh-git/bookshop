package com.bookshop.service;

import java.util.List;

import com.bookshop.entity.User;

public interface UserService {

    // insert
    int insert(User user);

    // delete
    int delete(Integer id);

    // update
    int update(User user);

    // queryAll
    List<User> queryAll();

    // queryById
    User queryById(Integer Id);

    User login(User user);

    int register(User user);

}
