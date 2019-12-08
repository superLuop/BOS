package com.lp.bos.service.impl;

import com.lp.bos.model.PageBean;
import com.lp.bos.model.Subarea;
import com.lp.bos.service.SubareaService;
import com.lp.bos.service.base.BaseServiceImpl;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class SubareaServiceImpl extends BaseServiceImpl<Subarea> implements SubareaService {

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
        return subareaDao.findAll();
    }

    @Override
    public void pageQuery(PageBean<Subarea> pb) {
        subareaDao.pageQuery(pb);
    }

    @Override
    public List<Subarea> findAllWithUnbind() {
        DetachedCriteria dc = DetachedCriteria.forClass(Subarea.class);
        dc.add(Restrictions.isNull("decidedzone"));
        return subareaDao.findAllByDetachedCriteria(dc);
    }
}
