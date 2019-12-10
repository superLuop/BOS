package com.lp.bos.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ProcessInstanceAction extends ActionSupport {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private RepositoryService repositoryService;
    private List<ProcessInstance> list;

    public List<ProcessInstance> getList() {
        return list;
    }

    public String list() {
        //1.查找流程实例
        ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery();
        query.orderByProcessInstanceId().desc();
        list = query.list();
        return "list";
    }

    private String id;//流程实例的id

    public void setId(String id) {
        this.id = id;
    }

    //根据流程实例id返回流程变量数据
    public void findData() throws IOException {

        Map<String, Object> data = runtimeService.getVariables(id);
        ServletActionContext.getResponse().setHeader("content-type", "text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(data.toString());
    }

    private String pdi;
    public String getPdi() {
        return pdi;
    }

    public String showPng(){

        //1.通过【流程实例ID】找到【流程定义ID】
        ProcessInstanceQuery piq = runtimeService.createProcessInstanceQuery();
        piq.processInstanceId(id);//根据流程实例ID查
        ProcessInstance pi = piq.singleResult();

        pdi = pi.getProcessDefinitionId();


        //2.获取当前流程执行到哪个点
        String activityId = pi.getActivityId();

        ProcessDefinitionEntity pde = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(pdi);
        ActivityImpl activityImpl = pde.findActivity(activityId);

        //3.获取流程节点的位置
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.set("x", activityImpl.getX());
        vs.set("y", activityImpl.getY());
        vs.set("width", activityImpl.getWidth());
        vs.set("height", activityImpl.getHeight());

        return "showPng";
    }
}
