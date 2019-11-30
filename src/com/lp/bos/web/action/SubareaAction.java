package com.lp.bos.web.action;

import com.lp.bos.model.Subarea;
import com.lp.bos.service.SubareaService;
import com.lp.bos.web.action.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class SubareaAction extends BaseAction<Subarea>{

    @Autowired
    private SubareaService subareaService;
    @Override
    public String save() {
        System.out.println("数据1:" + getModel());
        System.out.println("数据1:" + getModel().getRegion());

        //调用service
        subareaService.save(getModel());
        return SUCCESS;
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

        //2.调用service,参数里传一个PageBean
        subareaService.pageQuery(pb);
        /**
         * 注意：获取数据时候，把分区Subarea的Region的加载方式设置为即时加载
         */
        //3.返回json数据
        responseJson(pb,new String[]{"currentPage","pageSize","detachedCriteria","subareas"});

    }
}
