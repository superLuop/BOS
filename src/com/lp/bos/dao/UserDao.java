package com.lp.bos.dao;

import com.lp.bos.dao.base.BaseDao;
import com.lp.bos.model.User;

public interface UserDao extends BaseDao<User> {

    public User findByEmail(String email);

    public User find(String username, String password);

    public User findByUsername(String username);
}
