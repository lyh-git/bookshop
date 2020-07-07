package com.bookshop.dao;

import java.util.List;

import com.bookshop.entity.Ideas;

public interface IdeaDao {
    // insert
    int insert(Ideas news);

    // delete
    int delete(Integer id);

    // update
    int update(Ideas news);

    // queryAll
    List<Ideas> queryAll();

}
