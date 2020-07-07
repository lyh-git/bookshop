package com.bookshop.service.impl;

import com.bookshop.dao.impl.IdeaDaoImpl;
import com.bookshop.entity.Ideas;
import com.bookshop.service.IdeaService;

import java.util.List;

public class IdeaServiceImpl  implements IdeaService {
    IdeaDaoImpl ideaDao=new IdeaDaoImpl();
    @Override
    public int insert(Ideas news) {
        return ideaDao.insert(news);
    }

    @Override
    public int delete(Integer id) {
        return ideaDao.delete(id);
    }

    @Override
    public int update(Ideas news) {
        return ideaDao.update(news);
    }

    @Override
    public List<Ideas> queryAll() {
        return ideaDao.queryAll();
    }
}
