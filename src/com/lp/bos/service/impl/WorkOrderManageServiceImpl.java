package com.lp.bos.service.impl;

import com.lp.bos.model.*;
import com.lp.bos.service.WorkOrderManageService;
import com.lp.bos.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class WorkOrderManageServiceImpl extends BaseServiceImpl<Workordermanage> implements WorkOrderManageService {

    @Override
    public void save(Workordermanage entity) {
        workOrderManageDao.save(entity);
    }

    @Override
    public void delete(Workordermanage entity) {

    }

    @Override
    public void update(Workordermanage entity) {

    }

    @Override
    public Workordermanage findById(Serializable id) {
        return null;
    }

    @Override
    public List<Workordermanage> findAll() {
        return null;
    }
}
