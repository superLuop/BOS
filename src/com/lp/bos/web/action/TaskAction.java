package com.lp.bos.web.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.lp.bos.model.Workordermanage;
import com.lp.bos.service.WorkOrderManageService;
import com.lp.bos.utils.ContextUtils;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class TaskAction extends ActionSupport{
	@Autowired
	private TaskService taskService;
	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private WorkOrderManageService workOrderManageService;

	public String findGroupTask(){
		
		//1.查询组任务
		TaskQuery tq = taskService.createTaskQuery();
		String userId = ContextUtils.loginUser().getId();
		//组过滤
		tq.taskCandidateUser(userId);
		List<Task> list = tq.list();
		
		//2.压栈
		ActionContext.getContext().getValueStack().set("list", list);
		
		return "list";
	}
	
	private String taskId;
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskId() {
		return taskId;
	}


	public void showData() throws IOException{
		Map<String, Object> vars = taskService.getVariables(taskId);
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().write(vars.toString());

	}
	
	public String takeTask(){//拾取任务
		String userId = ContextUtils.loginUser().getId();
		taskService.claim(taskId, userId);
		return findGroupTask();
	}
	
	public String findPersonalTask(){
		//1.查询个人任务
		TaskQuery tq = taskService.createTaskQuery();
		String userId = ContextUtils.loginUser().getId();
		//个人过滤
		tq.taskAssignee(userId);
		List<Task> list = tq.list();
		
		//2.压栈
		ActionContext.getContext().getValueStack().set("list", list);
		
		return "personalTaskList";
	}
	
	//办理审核工作单
	private String check;
	
	public void setCheck(String check) {
		this.check = check;
	}


	public String checkWorkOrderManage(){
		//1.根据任务ID查找流程实例
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		String pii = task.getProcessInstanceId();
		
		//2.通过流程实例查找业务key【businesskey=工作单ID】
		ProcessInstance pi = runtimeService.createProcessInstanceQuery().
		processInstanceId( pii).singleResult();
		
		String womId = pi.getBusinessKey();
		//显示工作单信息
		Workordermanage wom = workOrderManageService.findById(womId);
		
		if(check == null){
			ActionContext.getContext().getValueStack().set("map", wom);
			return "check";
		}else{
			//更新数据库
			workOrderManageService.checkWorkOrderManager(check,taskId,wom.getId());
			return findPersonalTask();
		}
		
		
		
	}
	
	//货物出库
	public String outStore(){
		taskService.complete(taskId);
		return findPersonalTask();
	}
	
	//货物配送
	public String transferGoods(){
		taskService.complete(taskId);
		return findPersonalTask();
	}
	
	//配送签收
	public String receive(){
		taskService.complete(taskId);
		return findPersonalTask();
	}
}
