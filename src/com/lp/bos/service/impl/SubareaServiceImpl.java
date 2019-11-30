package com.lp.bos.service.impl;

import com.lp.bos.dao.SubareaDao;
import com.lp.bos.model.PageBean;
import com.lp.bos.model.Subarea;
import com.lp.bos.service.SubareaService;
import com.lp.bos.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class SubareaServiceImpl extends BaseServiceImpl<Subarea> implements SubareaService {


    @Autowired
    private SubareaDao subareaDao;
    @Override
    public void save(Subarea entity) {
        subareaDao.save(entity);
    }

    @Override
    public void delete(Subarea entity) {

    }

    @Override
    public void update(Subarea entity) {

    }

    @Override
    public Subarea findById(Serializable id) {
        return null;
    }

    @Override
    public List<Subarea> findAll() {
        return null;
    }

    @Override
    public void pageQuery(PageBean<Subarea> pb) {
        subareaDao.pageQuery(pb);
    }
}
