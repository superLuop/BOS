package com.lp.bos.dao.impl;

import com.lp.bos.dao.UserDao;
import com.lp.bos.dao.base.BaseDaoImpl;
import com.lp.bos.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User find(String username, String password) {

        String hql = "from User where username = ? and password = ?";
        List<User> list = (List<User>) hibernateTemplate.find(hql,username,password);

        if(list.size() == 1){
            return list.get(0);
        }
        return null;
    }
}
