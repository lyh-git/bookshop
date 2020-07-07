package com.bookshop.dao;

import java.util.List;

import com.bookshop.entity.Book;

public interface BookDao {

    // insert
    int insert(Book book);

    // delete
    int delete(Integer id);

    // update
    int update(Book book);

    // queryAll
    List<Book> queryAll();

    // queryById
    Book queryById(Integer id);

    // 根据书名查询书(支持模糊查询)
    List<Book> queryByName(String name);
}
