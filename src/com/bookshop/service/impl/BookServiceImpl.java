package com.bookshop.service.impl;

import java.util.List;

import com.bookshop.dao.BookDao;
import com.bookshop.dao.impl.BookDaoImpl;
import com.bookshop.entity.Book;
import com.bookshop.service.BookService;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public int insert(Book book) {
           
        return bookDao.insert(book);
    }

    @Override
    public int delete(Integer id) {
           
        return bookDao.delete(id);
    }

    @Override
    public int update(Book book) {
           
        return bookDao.update(book);
    }

    @Override
    public List<Book> queryAll() {
           
        return bookDao.queryAll();
    }

    @Override
    public Book queryById(Integer id) {
           
        return bookDao.queryById(id);
    }

    @Override
    public List<Book> queryByName(String name) {
           
        return bookDao.queryByName(name);
    }

}
