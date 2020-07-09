package com.bookshop.service.impl;

import com.bookshop.dao.BookListDao;
import com.bookshop.dao.impl.BookListImpl;
import com.bookshop.entity.BookList;
import com.bookshop.service.BookListService;

import java.util.List;

public class BookListServiceImpl implements BookListService {
    BookListImpl bookList = new BookListImpl();

    @Override
    public List<BookList> queryAll() {

        return bookList.queryAll();
    }

    @Override
    public List<BookList> queryByName(String name) {
        return bookList.queryByName(name);
    }
}
