package com.lp.bos.service.impl;

import com.lp.bos.model.*;
import com.lp.bos.service.NoticebillService;
import com.lp.bos.service.base.BaseServiceImpl;
import com.lp.bos.utils.ContextUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class NoticebillServiceImpl extends BaseServiceImpl<Noticebill> implements NoticebillService {

    @Override
    public void save(Noticebill entity) {

    }

    @Override
    public void save(Noticebill entity,String decidedzoneId) {

        //1.添加业务通知单类型
        entity.setOrdertype("手动");//业务通知单-自动分单-手动分单

        //2.设置客服的id【登录用户】
        entity.setUser(ContextUtils.loginUser());

        noticebillDao.save(entity);//insert语句

        //3.自动分单【通过定区找到负责人】
        if(!StringUtils.isEmpty(decidedzoneId)){
            entity.setOrdertype("自动");//最后-update

            Decidedzone dz = decidedzoneDao.findById(decidedzoneId);//select
            Staff staff = dz.getStaff();//select
            entity.setStaff(staff);

            //4.往 "工单" 表插入数据
            Workbill workbill = new Workbill();
            workbill.setType("新单");//工单类型：新、追、改、销
            workbill.setPickstate("未取件");//未取件-取件中-收件
            workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));//工单创建时间
            workbill.setAttachbilltimes(0);//取到快件时间
            workbill.setRemark(entity.getRemark());

            //往 工单 添加 业务通知单的id
            workbill.setNoticebill(entity);

            //往 工单 添加 员工的id
            workbill.setStaff(staff);

            workbillDao.save(workbill);//insert语句

        }
    }
    @Override
    public void delete(Noticebill entity) {

    }

    @Override
    public void update(Noticebill entity) {

    }

    @Override
    public Noticebill findById(Serializable id) {
        return null;
    }

    @Override
    public List<Noticebill> findAll() {
        return null;
    }
}
