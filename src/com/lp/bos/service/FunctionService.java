package com.lp.bos.service;

import com.lp.bos.model.Function;
import com.lp.bos.model.PageBean;
import com.lp.bos.service.base.BaseService;


public interface FunctionService extends BaseService<Function>{

    public void pageQuery(PageBean<Function> pb);

}
