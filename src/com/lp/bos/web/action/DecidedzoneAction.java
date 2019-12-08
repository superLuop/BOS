package com.lp.bos.web.action;

import com.lp.bos.model.Decidedzone;
import com.lp.bos.web.action.base.BaseAction;
import com.lp.crm.domain.Customer;

import java.io.IOException;
import java.util.List;

public class DecidedzoneAction extends BaseAction<Decidedzone>{

    private String[] subareaId;//分区id

    public void setSubareaId(String[] subareaId) {
        this.subareaId = subareaId;
    }


    @Override
    public String save() {

        //调用service保存
        decidedzoneService.save(getModel(),subareaId);
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
        //调用service
        decidedzoneService.pageQuery(pb);
        //返回json数据
        responseJson(pb,new String[]{"currentPage","pageSize","detachedCriteria"});
    }

    //==================获取关联定区的客户信息===========================

    public void findhasassociationCustomers() throws IOException {
        List<Customer> list = customerService.findhasassociationCustomers(getModel().getId());
        responseJson(list,new String[]{});
    }

    //==================获取未关联定区的客户信息===========================
    public void findnoassociationCustomers() throws IOException {
        List<Customer> list = customerService.findnoassociationCustomers();
        responseJson(list,new String[]{});
    }

    //==================关联客户到定区===========================
    private Integer[] customerIds;

    public void setCustomerIds(Integer[] customerIds) {
        this.customerIds = customerIds;
    }
    public String assigncustomerstodecidedzone(){
        //1.一个是客户id数组和定区的id
        //2.远程调用
        customerService.assignCustomersToDecidedZone(customerIds,getModel().getId());

        return SUCCESS;
    }
}
