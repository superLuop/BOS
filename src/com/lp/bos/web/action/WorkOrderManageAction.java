package com.lp.bos.web.action;

import com.lp.bos.model.Workordermanage;
import com.lp.bos.web.action.base.BaseAction;

import java.io.IOException;


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

	@Override
	public String list() {
		return null;
	}
}
