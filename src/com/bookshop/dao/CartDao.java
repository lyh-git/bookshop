package com.bookshop.dao;

import java.util.List;

import com.bookshop.entity.Cart;

public interface CartDao {

    // insert
    int insert(Cart cart);

    // delete
    int delete(Integer id);

    // update
    int update(Cart cart);

    // queryAll
    List<Cart> queryAll();

    List<Cart> queryAllByUserId(Integer userId);

    Cart query(Integer userId, Integer bookId);
}
