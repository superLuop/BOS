package com.lp.bos.model;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {
    private String id;
    private String username;
    private String password;
    private Double salary;
    private Date birthday;
    private String gender;
    private String station;
    private String telephone;
    private String remark;
    private Set<Role> roles = new HashSet<Role>();

    public String getBirthdayStr(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return  sdf.format(birthday);
        }catch (Exception e){
            return "";
        }

    }

    public String getRolesStr(){
        String str = "";
        for (Role role : roles){
            str += role.getName() + "、";
        }
        return str;
    }
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", station='" + station + '\'' +
                ", telephone='" + telephone + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
