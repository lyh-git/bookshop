package com.bookshop.service.impl;

import java.util.List;

import com.bookshop.dao.OrderDao;
import com.bookshop.dao.impl.OrderDaoImpl;
import com.bookshop.entity.Order;
import com.bookshop.service.OrderService;

public class OrderServiceImpl implements OrderService {
    public OrderDao orderdao = new OrderDaoImpl();

    @Override
    public int insert(Order order) {
        return orderdao.insert(order);
    }

    @Override
    public int delete(Integer id) {
        return orderdao.delete(id);
    }

    @Override
    public int update(Order order) {
        return orderdao.update(order);
    }

    @Override
    public List<Order> queryAll() {
        return orderdao.queryAll();
    }

    @Override
    public List<Order> queryByUserId(Integer userId) {
        return orderdao.queryByUserId(userId);
    }

}
