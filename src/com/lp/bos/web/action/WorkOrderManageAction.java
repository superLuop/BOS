package com.lp.bos.web.action;

import com.lp.bos.model.Workordermanage;
import com.lp.bos.web.action.base.BaseAction;

import java.io.IOException;
import java.util.List;


public class WorkOrderManageAction extends BaseAction<Workordermanage> {

	@Override
	public String save() {
		workOrderManageService.save(getModel());
		try {
			responseStr("success");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}

	@Override
	public String update() {
		return null;
	}

	@Override
	public String delete() throws IOException {
		return null;
	}

	List<Workordermanage> list;

	public List<Workordermanage> getList() {
		return list;
	}

	@Override
	public String list() {
		//查询未启动配送流程的工作单
		list = workOrderManageService.findAllWithNoStart();
		return "list";
	}

	public String start(){
	    //启动配送流程
        workOrderManageService.start(getModel().getId());
        //返回列表界面
        return list();
    }
}
