package com.bookshop.service;

import java.util.List;

import com.bookshop.entity.Cart;

public interface CartService {

    // insert
    int insert(Cart cart);

    // delete
    int delete(Integer id);

    // update
    int update(Cart cart);

    // queryAll
    List<Cart> queryAll();

    List<Cart> queryAllByUserId(Integer userId);

    // 清空购物车
    void clearCart(Integer userId);
}
