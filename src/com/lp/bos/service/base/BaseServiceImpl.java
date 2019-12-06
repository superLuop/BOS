package com.lp.bos.service.base;


import com.lp.bos.dao.DecidedzoneDao;
import com.lp.bos.dao.NoticebillDao;
import com.lp.bos.dao.WorkbillDao;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected NoticebillDao noticebillDao;

    @Autowired
    protected DecidedzoneDao decidedzoneDao;

    @Autowired
    protected WorkbillDao workbillDao;
}
