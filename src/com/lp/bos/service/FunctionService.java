package com.lp.bos.service;

import com.lp.bos.model.Function;
import com.lp.bos.model.PageBean;
import com.lp.bos.service.base.BaseService;

import java.util.List;


public interface FunctionService extends BaseService<Function>{

    /**
     * 分页查询
     * @param pb
     */
    public void pageQuery(PageBean<Function> pb);

    /**
     * 根据id查找菜单
     * @param id
     * @return
     */
    public List<Function> findMenuByUserId(String id);

    /**
     * 查找所有菜单
     * @return
     */
    public List<Function> findAllMenu() ;

}
