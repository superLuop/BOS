package com.lp.bos.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.List;
import java.util.zip.ZipInputStream;


public class ProcessDefinitionAction extends ActionSupport {

    Logger logger = Logger.getLogger(ProcessDefinitionAction.class);

    private File zipFile;
    public void setZipFile(File zipFile) {
        this.zipFile = zipFile;
    }

    private List<ProcessDefinition> list;

    public List<ProcessDefinition> getList() {
        return list;
    }

    @Autowired
    private RepositoryService repositoryService;

    public String list(){
        //查询流程定义
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
        query.orderByDeploymentId().desc();
        list = query.list();
        //把数据存入值栈中，提供get方法
        return "list";
    }

    //发布流程
    public String deploy() throws FileNotFoundException {
        //获取部署的对象
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        //添加压缩包输入流
        deploymentBuilder.addZipInputStream(new ZipInputStream(new FileInputStream(zipFile)));
        deploymentBuilder.deploy();
        //查询更新数据
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
        query.orderByDeploymentId().desc();
        list = query.list();
        //返回数据展示list页面
        return "list";
    }

    private String id;

    public void setId(String id) {
        this.id = id;
    }
    public String viewpng(){
        //返回流程图图片给客户端
        InputStream imgIS = repositoryService.getProcessDiagram(id);
        //将imgIS存入值栈
        ActionContext.getContext().getValueStack().set("imgIS",imgIS);

        return "viewpng";
    }
    public void del() throws IOException {

        //1.先根据流程定义id查找部署id
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
        query.processDefinitionId(id);

        ProcessDefinition pd = query.singleResult();

        String deploymentId = pd.getDeploymentId();

        repositoryService.deleteDeployment(deploymentId);

        ServletActionContext.getResponse().getWriter().write("success");
    }
}
