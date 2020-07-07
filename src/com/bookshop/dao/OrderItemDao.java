package com.bookshop.dao;

import java.util.List;

import com.bookshop.entity.OrderItem;

public interface OrderItemDao {
    // insert
    int insert(OrderItem orderItem);

    // delete
    int delete(Integer id);

    // update
    int update(OrderItem orderItem);

    // queryAll
    List<OrderItem> queryAll();

    // queryById
    List<OrderItem> queryByUserId(Integer userId);
}
