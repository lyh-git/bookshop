package com.bookshop.service.impl;

import java.util.List;

import com.bookshop.dao.BookTypeDao;
import com.bookshop.dao.impl.BookTypeDaoImpl;
import com.bookshop.entity.BookType;
import com.bookshop.service.BookTypeService;

public class BookTypeServiceImpl implements BookTypeService {

    BookTypeDao bookTypeDao = new BookTypeDaoImpl();

    @Override
    public int insert(BookType bookType) {
        return bookTypeDao.insert(bookType);
    }

    @Override
    public int delete(Integer id) {
        return bookTypeDao.delete(id);
    }

    @Override
    public int update(BookType bookType) {
        return bookTypeDao.update(bookType);
    }

    @Override
    public List<BookType> queryAll() {
        // TODO Auto-generated method stub
        return bookTypeDao.queryAll();
    }

}
