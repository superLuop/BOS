package com.lp.bos.service;

import com.lp.bos.model.PageBean;
import com.lp.bos.model.Region;
import com.lp.bos.service.base.BaseService;

import java.util.List;

public interface RegionService extends BaseService<Region>{


    public void saveAll(List<Region> regions);

    /**
     * 分页查询
     * @param pb
     */
    public void pageQuery(PageBean<Region> pb);

}
