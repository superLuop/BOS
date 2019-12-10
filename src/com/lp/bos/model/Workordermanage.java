package com.lp.bos.model;

import java.util.Date;

public class Workordermanage {
    private String id;
    private String arrivecity;
    private String product;
    private Integer num;
    private Double weight;
    private String floadreqr;
    private String prodtimelimit;
    private String prodtype;
    private String sendername;
    private String senderphone;
    private String senderaddr;
    private String receivername;
    private String receiverphone;
    private String receiveraddr;
    private Integer feeitemnum;
    private Double actlweit;
    private String vol;
    private String managerCheck = "0";//0:未审核 1：审核
    private Date updatetime;
    private String start = "0";//0:未启动配送流程 1:启动配送流程

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArrivecity() {
        return arrivecity;
    }

    public void setArrivecity(String arrivecity) {
        this.arrivecity = arrivecity;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getFloadreqr() {
        return floadreqr;
    }

    public void setFloadreqr(String floadreqr) {
        this.floadreqr = floadreqr;
    }

    public String getProdtimelimit() {
        return prodtimelimit;
    }

    public void setProdtimelimit(String prodtimelimit) {
        this.prodtimelimit = prodtimelimit;
    }

    public String getProdtype() {
        return prodtype;
    }

    public void setProdtype(String prodtype) {
        this.prodtype = prodtype;
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername;
    }

    public String getSenderphone() {
        return senderphone;
    }

    public void setSenderphone(String senderphone) {
        this.senderphone = senderphone;
    }

    public String getSenderaddr() {
        return senderaddr;
    }

    public void setSenderaddr(String senderaddr) {
        this.senderaddr = senderaddr;
    }

    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername;
    }

    public String getReceiverphone() {
        return receiverphone;
    }

    public void setReceiverphone(String receiverphone) {
        this.receiverphone = receiverphone;
    }

    public String getReceiveraddr() {
        return receiveraddr;
    }

    public void setReceiveraddr(String receiveraddr) {
        this.receiveraddr = receiveraddr;
    }

    public Integer getFeeitemnum() {
        return feeitemnum;
    }

    public void setFeeitemnum(Integer feeitemnum) {
        this.feeitemnum = feeitemnum;
    }

    public Double getActlweit() {
        return actlweit;
    }

    public void setActlweit(Double actlweit) {
        this.actlweit = actlweit;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getManagerCheck() {
        return managerCheck;
    }

    public void setManagerCheck(String managerCheck) {
        this.managerCheck = managerCheck;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "工作单信息 [编号=" + id + ", 货物名称=" + product
                + ", 货物重量=" + weight + ", 收货人="
                + receivername + ", 收货人电话=" + receiverphone + "]";
    }
}
