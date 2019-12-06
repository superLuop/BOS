package com.lp.bos.model;

import java.sql.Timestamp;

public class Workbill {
    private String id;
    private String type;
    private String pickstate;
    private Timestamp buildtime;
    private Integer attachbilltimes;
    private String remark;

    //员工模型
    private Staff staff;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    //业务通知单模型
    private Noticebill noticebill;

    public Noticebill getNoticebill() {
        return noticebill;
    }

    public void setNoticebill(Noticebill noticebill) {
        this.noticebill = noticebill;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPickstate() {
        return pickstate;
    }

    public void setPickstate(String pickstate) {
        this.pickstate = pickstate;
    }

    public Timestamp getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Timestamp buildtime) {
        this.buildtime = buildtime;
    }

    public Integer getAttachbilltimes() {
        return attachbilltimes;
    }

    public void setAttachbilltimes(Integer attachbilltimes) {
        this.attachbilltimes = attachbilltimes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Workbill{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", pickstate='" + pickstate + '\'' +
                ", buildtime=" + buildtime +
                ", attachbilltimes=" + attachbilltimes +
                ", remark='" + remark + '\'' +
                '}';
    }
}
