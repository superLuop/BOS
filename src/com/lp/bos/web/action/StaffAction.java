package com.lp.bos.web.action;

import com.lp.bos.model.Staff;
import com.lp.bos.service.StaffService;
import com.lp.bos.web.action.base.BaseAction;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StaffAction extends BaseAction<Staff> {

    @Override
    public String save() {
        staffService.save(getModel());
        return SUCCESS;//回到取派员列表界面
    }

    @Override
    public String update() {

        //getModel() 【游离/脱管状态 session没有缓存，有id】
        staffService.update(getModel());

        return SUCCESS;
    }

    //=====================删除取派员=============================
    private String ids;
    public void setIds(String ids) {
        this.ids = ids;
    }
    @Override
    public String delete() throws IOException {
        //1.获取删除的id

        //2.调用service
        staffService.deleteBatch(ids);

        //3.响应
        HttpServletResponse response = ServletActionContext.getResponse();
        response.getWriter().write("success");

        return NONE;
    }

    @Override
    public String list() {
        return null;
    }

    //===================分页查询返回json数据==========================


    public void pageQuery() throws IOException {
        //1.接收参数 page[当前页] rows[每页显示多少条]
        //封装条件
        pb.setCurrentPage(page);
        pb.setPageSize(rows);

        //2.调用service,参数里传一个PageBean
        staffService.pageQuery(pb);

        //3.返回json数据
        responseJson(pb,new String[]{"currentPage","pageSize","detachedCriteria"});
    }

    public void listJson() throws IOException {
        //在职员工
        List<Staff> list = staffService.findAllWithNoDelete();

        responseJson(list,new String[]{"telephone","haspda","deltag","station","standard"});
    }
}
