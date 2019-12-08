package com.lp.bos.model;
// default package

import java.util.HashSet;
import java.util.Set;


/**
 * Function entity. @author MyEclipse Persistence Tools
 */

public class Function  implements java.io.Serializable {


    // Fields    

     private String id;
     private Function function;
     private String name;
     private String code;
     private String description;
     private String page;
     private String generatemenu;
     private Integer zindex;
     private Set roles = new HashSet(0);
     private Set functions = new HashSet(0);
     private String pId;

    public String getpId() {
    	if(function != null){
    		return function.getId();
    	}
		return "0";
	}

	/** default constructor */
    public Function() {
    }

	/** minimal constructor */
    public Function(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public Function(String id, Function function, String name, String code, String description, String page, String generatemenu, Integer zindex, Set roles, Set functions) {
        this.id = id;
        this.function = function;
        this.name = name;
        this.code = code;
        this.description = description;
        this.page = page;
        this.generatemenu = generatemenu;
        this.zindex = zindex;
        this.roles = roles;
        this.functions = functions;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public Function getFunction() {
        return this.function;
    }
    
    public void setFunction(Function function) {
        this.function = function;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPage() {
        return this.page;
    }
    
    public void setPage(String page) {
        this.page = page;
    }

    public String getGeneratemenu() {
        return this.generatemenu;
    }
    
    public void setGeneratemenu(String generatemenu) {
        this.generatemenu = generatemenu;
    }

    public Integer getZindex() {
        return this.zindex;
    }
    
    public void setZindex(Integer zindex) {
        this.zindex = zindex;
    }

    public Set getRoles() {
        return this.roles;
    }
    
    public void setRoles(Set roles) {
        this.roles = roles;
    }

    public Set getFunctions() {
        return this.functions;
    }
    
    public void setFunctions(Set functions) {
        this.functions = functions;
    }
   








}