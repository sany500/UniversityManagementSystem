/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.service;

import com.spring.maven.dao.impl.ISemesterDAO;
import com.spring.maven.model.Semester;
import com.spring.maven.service.impl.ISemesterService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sany5
 */
@Service(value = "semesterService")
public class SemesterService implements ISemesterService{
    @Autowired
    ISemesterDAO semesterDAO;
    
    @Override
    public Semester save(HttpServletRequest request) {
       Semester s=new Semester();
       s.setSemesterCode(request.getParameter("semesterCode"));
       s.setSemesterName(request.getParameter("semesterName"));
       s.setUniCode(request.getParameter("uid"));
       s.setUniName(request.getParameter("name"));
       s.setDeptCode(request.getParameter("deptCode"));
       s.setDeptName(request.getParameter("deptName"));
       semesterDAO.save(s);
       return s;
    }

    @Override
    public Semester update(HttpServletRequest request) {
        Semester s=new Semester();
       s.setId(Integer.parseInt(request.getParameter("id")));
       s.setSemesterCode(request.getParameter("semesterCode"));
       s.setSemesterName(request.getParameter("semesterName"));
       s.setUniCode(request.getParameter("uid"));
       s.setUniName(request.getParameter("name"));
       s.setDeptCode(request.getParameter("deptCode"));
       s.setDeptName(request.getParameter("deptName"));
       semesterDAO.update(s);
       return s;
    }

    @Override
    public Semester delete(int id) {
       return semesterDAO.delete(id);
    }

    @Override
    public List<Semester> getAll() {
       return semesterDAO.getAll();
    }

    @Override
    public Semester getById(int id) {
        return semesterDAO.getById(id);
    }
    
}
