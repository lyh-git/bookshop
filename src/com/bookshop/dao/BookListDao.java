package com.bookshop.dao;

import com.bookshop.entity.Book;
import com.bookshop.entity.BookList;

import java.util.List;

public interface BookListDao {
    // queryAll
    List<BookList> queryAll();
}
