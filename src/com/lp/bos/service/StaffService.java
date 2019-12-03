package com.lp.bos.service;

import com.lp.bos.model.PageBean;
import com.lp.bos.model.Staff;
import com.lp.bos.service.base.BaseService;

import java.util.List;

public interface StaffService extends BaseService<Staff>{


    /**
     * 分页查询
     * @param pb
     */
    public void pageQuery(PageBean<Staff> pb);

    /**
     * 批量删除取派员
     * @param ids 【001,002,003】 以豆号隔开
     */
    public void deleteBatch(String ids);

    public List<Staff> findAllWithNoDelete();
}
