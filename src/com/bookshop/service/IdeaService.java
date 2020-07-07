package com.bookshop.service;

import com.bookshop.entity.Ideas;

import java.util.List;

public interface IdeaService {
    // insert
    int insert(Ideas news);

    // delete
    int delete(Integer id);

    // update
    int update(Ideas news);

    // queryAll
    List<Ideas> queryAll();
}
