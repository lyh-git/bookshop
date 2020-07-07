package com.bookshop.service.impl;

import java.util.List;

import com.bookshop.dao.CartDao;
import com.bookshop.dao.impl.CartDaoImpl;
import com.bookshop.entity.Cart;
import com.bookshop.service.CartService;

public class CartServiceImpl implements CartService {
    CartDao cartDao = new CartDaoImpl();

    @Override
    public int insert(Cart cart) {
        Cart cart2 = cartDao.query(cart.getUserId(), cart.getBookId());
        int result;
        if (cart2 == null) {
            result = cartDao.insert(cart);
        } else {
            cart2.setBookNum(cart.getBookNum() + cart2.getBookNum());
            result = cartDao.update(cart2);
        }
        return result;
    }

    @Override
    public int delete(Integer id) {
          
        return cartDao.delete(id);
    }

    @Override
    public int update(Cart cart) {
          
        return cartDao.update(cart);
    }

    @Override
    public List<Cart> queryAll() {
          
        return cartDao.queryAll();
    }

    @Override
    public List<Cart> queryAllByUserId(Integer userId) {
        return cartDao.queryAllByUserId(userId);
    }

    @Override
    public void clearCart(Integer userId) {
        List<Cart> carts = cartDao.queryAllByUserId(userId);
        for (Cart cart : carts) {
            cartDao.delete(cart.getId());

        }
        
    }

}
