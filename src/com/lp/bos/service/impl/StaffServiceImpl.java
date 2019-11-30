package com.lp.bos.service.impl;

import com.lp.bos.dao.StaffDao;
import com.lp.bos.model.PageBean;
import com.lp.bos.model.Staff;
import com.lp.bos.service.StaffService;
import com.lp.bos.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class StaffServiceImpl extends BaseServiceImpl<Staff> implements StaffService {


    @Autowired
    private StaffDao staffDao;

    @Override
    public void save(Staff entity) {
        staffDao.save(entity);
    }

    @Override
    public void delete(Staff entity) {
        staffDao.delete(entity);
    }

    @Override
    public void update(Staff entity) {
        //实际可以不写，写也没有关系
        //staffDao.update(entity);

       //1.根据id从数据库获取数据【持久状态-session有缓存，有id】
        Staff staff = staffDao.findById(entity.getId());

        //2.更新数据库的数据
        staff.setName(entity.getName());
        staff.setTelephone(entity.getTelephone());
        staff.setStation(entity.getStation());
        staff.setHaspda(entity.getHaspda());
        staff.setStandard(entity.getStandard());
        System.out.println("数据库：" + staff);
    }

    @Override
    public Staff findById(Serializable id) {
        return   staffDao.findById(id);
    }

    @Override
    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    @Override
    public void pageQuery(PageBean<Staff> pb) {
        staffDao.pageQuery(pb);
    }

    @Override
    public void deleteBatch(String ids) {
        String hql = "update Staff set deltag = ? where id = ?";

        //拆分id
        String[] idsArr = ids.split(",");
        for (String id : idsArr){
            staffDao.executeUpdate(hql,"1",id);
            //staffDao.executeUpdateByQueryName("staff_delete","1",id);
        }

    }
}
