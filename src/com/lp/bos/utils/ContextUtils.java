package com.lp.bos.utils;

import com.lp.bos.model.User;
import org.apache.struts2.ServletActionContext;

public class ContextUtils {

    public static User loginUser() {
        return (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
    }
}
