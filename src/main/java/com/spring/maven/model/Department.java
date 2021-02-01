/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.model;

import javax.persistence.Entity;

import javax.persistence.Id;

/**
 *
 * @author sany5
 */
@Entity
public class Department {
    @Id
    private int id;
    private String deptCode;
    private String deptName;
    private String uniCode;
    private String uniName;
    

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getUniCode() {
        return uniCode;
    }

    public void setUniCode(String uniCode) {
        this.uniCode = uniCode;
    }

    public String getUniName() {
        return uniName;
    }

    

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }
    
}
