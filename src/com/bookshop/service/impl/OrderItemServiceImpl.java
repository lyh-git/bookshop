package com.bookshop.service.impl;

import java.util.List;

import com.bookshop.dao.OrderItemDao;
import com.bookshop.dao.impl.OrderItemDaoImpl;
import com.bookshop.entity.OrderItem;
import com.bookshop.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {

    public OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    public int insert(OrderItem orderItem) {
        return orderItemDao.insert(orderItem);
    }

    @Override
    public int delete(Integer id) {
        return orderItemDao.delete(id);
    }

    @Override
    public int update(OrderItem orderItem) {
        return orderItemDao.update(orderItem);
    }

    @Override
    public List<OrderItem> queryAll() {
        return orderItemDao.queryAll();
    }

    @Override
    public List<OrderItem> queryByUserId(Integer userId) {
        return orderItemDao.queryByUserId(userId);
    }

}
