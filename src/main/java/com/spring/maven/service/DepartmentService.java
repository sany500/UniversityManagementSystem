/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.service;

import com.spring.maven.dao.impl.IDepartmentDAO;
import com.spring.maven.model.Department;
import com.spring.maven.service.impl.IDepartmentService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sany5
 */
@Service(value = "departmentService")
public class DepartmentService implements IDepartmentService{
    @Autowired
    IDepartmentDAO departmentDAO;
    @Override
    public Department save(HttpServletRequest request) {
       Department d=new Department();
        
        d.setDeptCode(request.getParameter("deptCode"));
        d.setDeptName(request.getParameter("deptName"));
        d.setUniCode(request.getParameter("uid"));
        d.setUniName(request.getParameter("name"));
        
        
        System.out.println("--------------------"+d.getId());
        System.out.println("--------------------"+d.getUniName());
        System.out.println("--------------------"+d.getUniCode());
        System.out.println("--------------------"+d.getDeptCode());
        System.out.println("--------------------"+d.getDeptName());
        
        
        departmentDAO.save(d);
        return d;
    }

    @Override
    public Department update(HttpServletRequest request) {
        Department d=new Department();
        d.setId(Integer.parseInt(request.getParameter("id")));
        d.setDeptCode(request.getParameter("deptCode"));
        d.setDeptName(request.getParameter("deptName"));
        d.setUniCode(request.getParameter("uid"));
        d.setUniName(request.getParameter("name"));
        departmentDAO.update(d);
        return d;
    }

    @Override
    public Department delete(int id) {
        return departmentDAO.delete(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentDAO.getAll();
    }

    @Override
    public Department getById(int id) {
        return departmentDAO.getById(id);
    }
    
}
