package com.bookshop.service;

import com.bookshop.entity.Book;
import com.bookshop.entity.BookList;

import java.util.List;

public interface BookListService {
    // queryAll
    List<BookList> queryAll();
    List<BookList> queryByName(String name);
}
