package com.lp.bos.service.impl;

import com.lp.bos.model.Function;
import com.lp.bos.model.PageBean;
import com.lp.bos.model.Role;
import com.lp.bos.service.RoleService;
import com.lp.bos.service.base.BaseServiceImpl;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional//事务是由事务管理器来实现
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private IdentityService identityService;
    /**
     * 保存角色
     * @param role 角色模型
     * @param funtionIds 权限、功能id
     */
    @Override
    public void save(Role role, String funtionIds) {

        //role:瞬时状态【没有session,没有id】
        //1.保存角色
        roleDao.save(role);//持久态【session，id】
        //把角色添加到activiti中
        Group group = new GroupEntity();
        group.setId(role.getName());
        group.setName(role.getName());
        identityService.saveGroup(group);
        //2.添加角色-权限 中间表数据
        //2.1 拆分id
        String[] functionIdsArr = funtionIds.split(",");
        for(String functionId : functionIdsArr){
            //2.2把id封装成function模型
            Function function = new Function();
            function.setId(functionId);
            //2.3把function存到Role
            role.getFunctions().add(function);//内部执行insert语句
        }
    }

    @Override
    public void pageQuery(PageBean<Role> pb) {

        roleDao.pageQuery(pb);
    }

    @Override
    public void save(Role entity) {

    }

    @Override
    public void delete(Role entity) {

    }

    @Override
    public void update(Role entity) {

    }

    @Override
    public Role findById(Serializable id) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
