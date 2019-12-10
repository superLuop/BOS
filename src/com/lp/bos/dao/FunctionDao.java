package com.lp.bos.dao;

import com.lp.bos.dao.base.BaseDao;
import com.lp.bos.model.Function;

import java.util.List;

public interface FunctionDao extends BaseDao<Function> {

    /**
     * 根据用户id查找权限
     * @param userId
     * @return
     */
    public List<Function> findListByUserId(String userId);

    /**
     * 通过id查询菜单
     * @param id
     * @return
     */
    public List<Function> findMenuByUserId(String id);

    /**
     * 查询所有菜单
     * @return
     */
    public List<Function> findAllMenu();
}
