package com.lp.bos.service;

import com.lp.bos.model.PageBean;
import com.lp.bos.model.User;
import com.lp.bos.service.base.BaseService;

public interface UserService extends BaseService<User>{

    //特有的业务方法
    public User findByTel(String tel);

    public User login(String username, String password);

    public void modifyPassword(String newPwd, String userId);

    public void save(User model, String[] roleIds);

    public void pageQuery(PageBean<User> pb);
}
