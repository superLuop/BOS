package com.lp.bos.dao.impl;

import com.lp.bos.dao.FunctionDao;
import com.lp.bos.dao.base.BaseDaoImpl;
import com.lp.bos.model.Function;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements FunctionDao {

    @Override
    public List<Function> findListByUserId(String userId) {
        /*  SELECT DISTINCT f.id,f.name,f.page,f.code
        FROM auth_function f
        LEFT OUTER JOIN role_function rf
        ON rf.function_id = f.id
        LEFT OUTER JOIN auth_role r
        ON rf.role_id = r.id
        LEFT OUTER JOIN user_role ur
        ON r.id = ur.role_id
        WHERE ur.user_id = '4028b8816367b603016367b7add80001';*/
        String hql = "select distinct f from Function f ";
        hql += "left outer join f.roles r ";
        hql += "left outer join r.users u ";
        hql += "where u.id = ?";
        return (List<Function>) hibernateTemplate.find(hql,userId);
    }

    @Override
    public List<Function> findMenuByUserId(String id) {
        String hql = "select distinct f from Function f ";
        hql += "left outer join f.roles r ";
        hql += "left outer join r.users u ";
        hql += "where u.id = ? and f.generatemenu = '1' order by f.zindex desc";
        return (List<Function>) hibernateTemplate.find(hql,id);
    }

    @Override
    public List<Function> findAllMenu() {
        String hql = "from Function f where f.generatemenu = '1' order by f.zindex desc";
        return (List<Function>) hibernateTemplate.find(hql);
    }
}
