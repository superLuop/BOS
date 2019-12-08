package com.lp.bos.service.impl;

import com.lp.bos.model.Function;
import com.lp.bos.model.PageBean;
import com.lp.bos.service.FunctionService;
import com.lp.bos.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class FunctionServiceImpl extends BaseServiceImpl<Function> implements FunctionService {

    @Override
    public void pageQuery(PageBean<Function> pb) {
        functionDao.pageQuery(pb);
    }

    @Override
    public void save(Function entity) {

        functionDao.save(entity);
    }

    @Override
    public void delete(Function entity) {

    }

    @Override
    public void update(Function entity) {

    }

    @Override
    public Function findById(Serializable id) {
        return null;
    }

    @Override
    public List<Function> findAll() {
        return functionDao.findAll();
    }
}
