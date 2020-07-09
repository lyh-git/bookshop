package com.bookshop.service.impl;

import com.bookshop.dao.BookListDao;
import com.bookshop.dao.impl.BookListImpl;
import com.bookshop.entity.BookList;
import com.bookshop.service.BookListService;

import java.util.List;

public class BookListServiceImpl implements BookListService {


    @Override
    public List<BookList> queryAll() {
        BookListImpl bookList = new BookListImpl();
        return bookList.queryAll();
    }
}
