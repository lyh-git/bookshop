package com.bookshop.service.impl;

import java.util.List;

import com.bookshop.dao.AdminDao;
import com.bookshop.dao.impl.AdminDaoImpl;
import com.bookshop.entity.Admin;
import com.bookshop.service.AdminService;

public class AdminServiceImpl implements AdminService {

    AdminDao adminDao = new AdminDaoImpl();

    @Override
    public int insert(Admin admin) {
        return adminDao.insert(admin);
    }

    @Override
    public int delete(Integer adminId) {
        return adminDao.delete(adminId);
    }

    @Override
    public int update(Admin admin) {
        return adminDao.update(admin);
    }

    @Override
    public List<Admin> queryAll() {
        return adminDao.queryAll();
    }

    @Override
    public Admin queryById(Integer adminId) {
        return adminDao.queryById(adminId);
    }

    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }

}
