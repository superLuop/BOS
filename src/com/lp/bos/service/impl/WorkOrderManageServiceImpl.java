package com.lp.bos.service.impl;

import com.lp.bos.model.*;
import com.lp.bos.service.WorkOrderManageService;
import com.lp.bos.service.base.BaseServiceImpl;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional//事务是由事务管理器来实现
public class WorkOrderManageServiceImpl extends BaseServiceImpl<Workordermanage> implements WorkOrderManageService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private TaskService taskService;
    @Override
    public void save(Workordermanage entity) {
        entity.setUpdatetime(new Date());
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
        return workOrderManageDao.findById(id);
    }

    @Override
    public List<Workordermanage> findAll() {
        return null;
    }

    @Override
    public List<Workordermanage> findAllWithNoStart() {
        DetachedCriteria dc = DetachedCriteria.forClass(Workordermanage.class);
        dc.add(Restrictions.eq("start","0"));
        return workOrderManageDao.findAllByDetachedCriteria(dc);
    }

    @Override
    public void start(String id) {
        //启动配送流程
        //1.根据id查找workOrderManage
        Workordermanage workordermanage = workOrderManageDao.findById(id);
        //2.将start改为1
        workordermanage.setStart("1");
        //3.启动流程实例transfer
        //设置流程变量
        HashMap<String, Object> info = new HashMap<String, Object>();
        info.put("orderInfo",workordermanage.toString());
        //设置工作单id
        String workordermanageId = workordermanage.getId();
        runtimeService.startProcessInstanceByKey("transfer",workordermanageId,info);
    }

    @Override
    public void checkWorkOrderManager(String check, String taskId, String id) {
        //1.取出任务【一定要先取出来】
        Task task =taskService.createTaskQuery().taskId(taskId).singleResult();
        String pii = task.getProcessInstanceId();
        //2.办理任务
        Map<String,Object> vars = new HashMap<String,Object>();
        vars.put("check", check);
        taskService.complete(taskId, vars);
        if(check.equals("0")){
            //3.更改状态
            workOrderManageDao.findById(id).setStart("0");
            //4.删除流程实例
            historyService.deleteHistoricProcessInstance(pii);
        }
    }
}
