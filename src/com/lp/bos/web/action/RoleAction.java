package com.lp.bos.web.action;

import com.lp.bos.model.Role;
import com.lp.bos.web.action.base.BaseAction;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;


public class RoleAction extends BaseAction<Role> {

    Logger logger = Logger.getLogger(RoleAction.class);

    private String functionIds;//权限id

    public void setFunctionIds(String functionIds) {
        this.functionIds = functionIds;
    }

    @Override
    public String save() {
        roleService.save(getModel(),functionIds);
        return "submit";
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String delete() throws IOException {
        return null;
    }

    @Override
    public String list() {
        return null;
    }

    public void pageQuery() throws IOException {
        pb.setCurrentPage(page);
        pb.setPageSize(rows);
        //调用service
        roleService.pageQuery(pb);
        //返回json数据
        responseJson(pb,new String[]{"currentPage","pageSize","detachedCriteria","users","functions"});
    }
    public void listJson() throws IOException {
        List<Role> roles = roleService.findAll();
        responseJson(roles,new String[]{"users","functions"});
    }
}
