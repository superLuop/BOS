package com.lp.bos.dao;

import com.lp.bos.dao.base.BaseDao;
import com.lp.bos.model.Function;

import java.util.List;

public interface FunctionDao extends BaseDao<Function> {

    //根据用户id查找权限
    public List<Function> findListByUserId(String userId);
}
