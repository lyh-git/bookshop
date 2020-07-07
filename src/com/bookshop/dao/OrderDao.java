package com.bookshop.dao;

import java.util.List;

import com.bookshop.entity.Order;

public interface OrderDao {

    // insert
    int insert(Order order);

    // delete
    int delete(Integer id);

    // update
    int update(Order order);

    // queryAll
    List<Order> queryAll();

    // queryById
    List<Order> queryByUserId(Integer userId);

}
