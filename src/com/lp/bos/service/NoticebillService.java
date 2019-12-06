package com.lp.bos.service;

import com.lp.bos.model.Noticebill;
import com.lp.bos.service.base.BaseService;

public interface NoticebillService extends BaseService<Noticebill>{

    /**
     *
     * @param entity 业务通知单模型
     * @param decidedzoneId 定区id,用于自动分单
     */
    public void save(Noticebill entity, String decidedzoneId);
}
