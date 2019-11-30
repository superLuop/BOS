package com.lp.bos.service.impl;

import com.lp.bos.dao.RegionDao;
import com.lp.bos.model.PageBean;
import com.lp.bos.model.Region;
import com.lp.bos.service.RegionService;
import com.lp.bos.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class RegionServiceImpl extends BaseServiceImpl<Region> implements RegionService {


    @Autowired
    private RegionDao regionDao;
    @Override
    public void save(Region entity) {
        regionDao.save(entity);
    }

    @Override
    public void delete(Region entity) {

    }

    @Override
    public void update(Region entity) {

    }

    @Override
    public Region findById(Serializable id) {
        return null;
    }

    @Override
    public List<Region> findAll() {
        return regionDao.findAll();
    }

    @Override
    public void saveAll(List<Region> regions) {
        regionDao.saveAll(regions);
    }

    @Override
    public void pageQuery(PageBean<Region> pb) {
        regionDao.pageQuery(pb);
    }
}
