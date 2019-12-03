package com.lp.bos.service.impl;

import com.lp.bos.dao.DecidedzoneDao;
import com.lp.bos.dao.SubareaDao;
import com.lp.bos.model.Decidedzone;
import com.lp.bos.model.PageBean;
import com.lp.bos.model.Subarea;
import com.lp.bos.service.DecidedzoneService;
import com.lp.bos.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class DecidedzoneServiceImpl extends BaseServiceImpl<Decidedzone> implements DecidedzoneService {

    @Autowired
    private DecidedzoneDao decidedzoneDao;

    @Autowired
    private SubareaDao subareaDao;

    @Override
    public void save(Decidedzone dz, String[] subareaIds) {

        //1.添加分区
        decidedzoneDao.save(dz);

        //2.更新分区的decided_id
        for (String subareaId : subareaIds) {
            Subarea subarea = subareaDao.findById(subareaId);
            subarea.setDecidedzone(dz);
        }
    }

    @Override
    public void pageQuery(PageBean<Decidedzone> pb) {

        decidedzoneDao.pageQuery(pb);
    }

    @Override
    public void save(Decidedzone entity) {

    }

    @Override
    public void delete(Decidedzone entity) {

    }

    @Override
    public void update(Decidedzone entity) {

    }

    @Override
    public Decidedzone findById(Serializable id) {
        return null;
    }

    @Override
    public List<Decidedzone> findAll() {
        return null;
    }
}
