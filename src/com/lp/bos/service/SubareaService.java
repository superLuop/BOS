package com.lp.bos.service;

import com.lp.bos.model.PageBean;
import com.lp.bos.model.Subarea;
import com.lp.bos.service.base.BaseService;

public interface SubareaService extends BaseService<Subarea>{
    public void pageQuery(PageBean<Subarea> pb);
}
