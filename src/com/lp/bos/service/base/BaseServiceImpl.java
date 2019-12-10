package com.lp.bos.service.base;


import com.lp.bos.dao.*;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected StaffDao staffDao;

    @Autowired
    protected RegionDao regionDao;

    @Autowired
    protected SubareaDao subareaDao;

    @Autowired
    protected NoticebillDao noticebillDao;

    @Autowired
    protected DecidedzoneDao decidedzoneDao;

    @Autowired
    protected WorkbillDao workbillDao;

    @Autowired
    protected WorkOrderManageDao workOrderManageDao;

    @Autowired
    protected FunctionDao functionDao;

    @Autowired
    protected RoleDao roleDao;

}
