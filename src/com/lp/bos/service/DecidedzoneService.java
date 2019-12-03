package com.lp.bos.service;

import com.lp.bos.model.Decidedzone;
import com.lp.bos.model.PageBean;
import com.lp.bos.service.base.BaseService;


public interface DecidedzoneService extends BaseService<Decidedzone>{

    /**
     *
     * @param dz 定区数据
     * @param subareaIds 分区id
     */
    public void save(Decidedzone dz,String[] subareaIds);

    public void pageQuery(PageBean<Decidedzone> pb);

}
