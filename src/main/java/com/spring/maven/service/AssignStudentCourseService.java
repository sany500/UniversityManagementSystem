/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.service;

import com.spring.maven.dao.AssignStudentCourseDAO;
import com.spring.maven.dao.impl.IAssignStudentCourseDAO;
import com.spring.maven.model.AssignStudentCourse;
import com.spring.maven.service.impl.IAssignStudentCourseService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B13
 */
@Service(value = "assignStudentCourseService")
public class AssignStudentCourseService implements IAssignStudentCourseService {

    @Autowired
    IAssignStudentCourseDAO assignStudentCourseDAO;
    
    

    @Override
    public AssignStudentCourse save(HttpServletRequest request) {
        AssignStudentCourse asc = new AssignStudentCourse();

        asc.setSid(Integer.parseInt(request.getParameter("sid")));
        asc.setName(request.getParameter("name"));
        asc.setEmail(request.getParameter("email"));
        asc.setPhone(request.getParameter("phone"));
        asc.setAddress(request.getParameter("address"));
        asc.setfName(request.getParameter("fName"));
        asc.setmName(request.getParameter("mName"));
        asc.setDob(request.getParameter("dob"));
        asc.setReligion(request.getParameter("religion"));
        asc.setBloodGroup(request.getParameter("bloodGroup"));
        asc.setGender(request.getParameter("gender"));
        asc.setSemesterCode(request.getParameter("semesterCode"));
        asc.setSemesterName(request.getParameter("semesterName"));
        asc.setUniCode(request.getParameter("uniCode"));
        asc.setUniName(request.getParameter("uniName"));
        asc.setCourseCode(request.getParameter("courseCode"));
        asc.setCourseName(request.getParameter("courseName"));
        asc.setDeptCode(request.getParameter("deptCode"));
        asc.setDeptName(request.getParameter("deptName"));
        
        System.out.println(asc.getCourseName());
        System.out.println(asc.getSemesterName());
        System.out.println(asc.getCourseCode());
        System.out.println(asc.getDeptCode());

        assignStudentCourseDAO.save(asc);
        return asc;
    }

    @Override
    public AssignStudentCourse update(HttpServletRequest request) {
        AssignStudentCourse asc = new AssignStudentCourse();

        asc.setId(Integer.parseInt(request.getParameter("")));
        asc.setSid(Integer.parseInt(request.getParameter("")));
        asc.setName(request.getParameter(""));
        asc.setEmail(request.getParameter(""));
        asc.setPhone(request.getParameter(""));
        asc.setAddress(request.getParameter(""));
        asc.setfName(request.getParameter(""));
        asc.setmName(request.getParameter(""));
        asc.setDob(request.getParameter(""));
        asc.setReligion(request.getParameter(""));
        asc.setBloodGroup(request.getParameter(""));
        asc.setGender(request.getParameter(""));
        asc.setSemesterCode(request.getParameter(""));
        asc.setSemesterName(request.getParameter(""));
        asc.setUniCode(request.getParameter(""));
        asc.setUniName(request.getParameter(""));
        asc.setCourseCode(request.getParameter(""));
        asc.setCourseName(request.getParameter(""));
        asc.setDeptCode(request.getParameter(""));
        asc.setDeptName(request.getParameter(""));

        assignStudentCourseDAO.update(asc);
        return asc;
    }

    @Override
    public AssignStudentCourse delete(int id) {
        return assignStudentCourseDAO.delete(id);
    }

    @Override
    public List<AssignStudentCourse> getAll() {
        return assignStudentCourseDAO.getAll();
    }

    @Override
    public AssignStudentCourse getById(int id) {
        return assignStudentCourseDAO.getById(id);
    }
    
    
    ///////Querrry/////
    public List<AssignStudentCourse> getAllbyCourse(String courseName ,String semesterName) {
        return assignStudentCourseDAO.getAllbyCourse(courseName, semesterName);
    }
    public AssignStudentCourse getStudentbyId(String sid){
        return assignStudentCourseDAO.getStudentbyId(sid);
    }
}
