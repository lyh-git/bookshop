package com.bookshop.dao;

import java.util.List;

import com.bookshop.entity.Admin;

public interface AdminDao {

    // insert
    int insert(Admin admin);

    // delete
    int delete(Integer adminId);

    // update
    int update(Admin admin);

    // queryAll
    List<Admin> queryAll();

    // queryById
    Admin queryById(Integer adminId);

    Admin login(Admin admin);
}
