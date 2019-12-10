package com.lp.bos.service;

import com.lp.bos.model.Workordermanage;
import com.lp.bos.service.base.BaseService;

import java.util.List;

public interface WorkOrderManageService extends BaseService<Workordermanage>{

    public List<Workordermanage> findAllWithNoStart();

    public void start(String id);

    public void checkWorkOrderManager(String check, String taskId, String id);
}
