/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.service;

import com.spring.maven.dao.impl.ICourseDAO;
import com.spring.maven.model.Course;
import com.spring.maven.service.impl.ICourseService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sany5
 */
@Service(value = "courseService")
public class CourseService implements ICourseService {

    @Autowired
    ICourseDAO courseDAO;
    
    @Override
    public Course save(HttpServletRequest request) {
        Course c = new Course();
        c.setCourseCode(request.getParameter("courseCode"));
        c.setCourseName(request.getParameter("courseName"));
        c.setDeptCode(request.getParameter("deptCode"));
        c.setDeptName(request.getParameter("deptName"));
        c.setUniCode(request.getParameter("uniCode"));
        c.setUniName(request.getParameter("uniName"));
        c.setSemesterCode(request.getParameter("semesterCode"));
        c.setSemesterName(request.getParameter("semesterName"));
        
        courseDAO.save(c);
        return c;
    }
    
    @Override
    public Course update(HttpServletRequest request) {
        Course c = new Course();
        c.setId(Integer.parseInt(request.getParameter("id")));
        c.setCourseCode(request.getParameter("courseCode"));
        c.setCourseName(request.getParameter("courseName"));
        c.setDeptCode(request.getParameter("deptCode"));
        c.setDeptName(request.getParameter("deptName"));
        c.setUniCode(request.getParameter("uniCode"));
        c.setUniName(request.getParameter("uniName"));
        
        courseDAO.save(c);
        return c;
    }
    
    @Override
    public Course delete(int id) {
        return courseDAO.delete(id);
    }
    
    @Override
    public List<Course> getAll() {
        return courseDAO.getAll();
    }
    
    @Override
    public Course getById(int id) {
        return courseDAO.getById(id);
    }
    
}
