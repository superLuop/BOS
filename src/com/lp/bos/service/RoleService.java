package com.lp.bos.service;

import com.lp.bos.model.PageBean;
import com.lp.bos.model.Role;
import com.lp.bos.service.base.BaseService;


public interface RoleService extends BaseService<Role>{

    /**
     *
     * @param role 角色模型
     * @param funtionIds 权限、功能id
     */
    public void save(Role role,String funtionIds);

    public void pageQuery(PageBean<Role> pb);

}
