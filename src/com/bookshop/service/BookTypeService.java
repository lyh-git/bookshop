package com.bookshop.service;

import java.util.List;

import com.bookshop.entity.BookType;

public interface BookTypeService {

    // insert
    int insert(BookType bookType);

    // delete
    int delete(Integer id);

    // update
    int update(BookType bookType);

    // queryAll
    List<BookType> queryAll();

}
