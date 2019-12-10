package com.lp.bos.web.action;

import com.lp.bos.model.Function;
import com.lp.bos.model.User;
import com.lp.bos.utils.ContextUtils;
import com.lp.bos.web.action.base.BaseAction;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;


public class FunctionAction extends BaseAction<Function> {

    Logger logger = Logger.getLogger(FunctionAction.class);
    //===================分页查询返回json数据==========================

    /**
     * 因为Function模型里有page属性，然后BaseAction也有page属性
     * Struts框架把数据放在模型优先
     * @throws IOException
     */
    public void pageQuery() throws IOException {
        //接收参数
        pb.setCurrentPage(Integer.parseInt(getModel().getPage()));
        pb.setPageSize(rows);
        //调用service
        functionService.pageQuery(pb);
        //返回json数据
        responseJson(pb,new String[]{"currentPage","pageSize","detachedCriteria","function","functions","roles"});
    }
    @Override
    public String save() {
        functionService.save(getModel());
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

    public void listJson() throws IOException {
        List<Function> functions = functionService.findAll();
        responseJson(functions,new String[]{"function","functions","roles"});
    }

    public void findMenu() throws IOException {
        List<Function> menus;
        User loginUser = ContextUtils.loginUser();
        if ("admin".equals(loginUser.getUsername())){
            menus = functionService.findAllMenu();
        }else {
            menus = functionService.findMenuByUserId(loginUser.getId());
        }
        responseJson(menus,new String[]{"function","functions","roles"});
    }
}
