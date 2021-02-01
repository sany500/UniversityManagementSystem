/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.service;

import com.spring.maven.dao.impl.IAssignFacultyCourseDAO;
import com.spring.maven.model.AssignFacultyCourse;
import com.spring.maven.service.impl.IAssignFacultyCourseService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sany5
 */
@Service(value = "assignFacultyCourseService")
public class AssignFacultyCourseService implements IAssignFacultyCourseService{
    @Autowired
    IAssignFacultyCourseDAO assignFacultyCourseDAO;

    @Override
    public AssignFacultyCourse save(HttpServletRequest request) {
        AssignFacultyCourse afc= new AssignFacultyCourse();
        afc.setFid(Integer.parseInt(request.getParameter("fid")));
        afc.setName(request.getParameter("name"));
        afc.setEmail(request.getParameter("email"));
        afc.setPhone(request.getParameter("phone"));
        afc.setAddress(request.getParameter("address"));
        afc.setDesignation(request.getParameter("designation"));
        afc.setDob(request.getParameter("dob"));
        afc.setReligion(request.getParameter("religion"));
        afc.setBloodGroup(request.getParameter("bloodGroup"));
        afc.setGender(request.getParameter("gender"));
        
        afc.setSemesterCode(request.getParameter("semesterCode"));
        afc.setSemesterName(request.getParameter("semesterName"));
        afc.setUniCode(request.getParameter("uniCode"));
        afc.setUniName(request.getParameter("uniName"));
        
        afc.setCourseCode(request.getParameter("courseCode"));
        afc.setCourseName(request.getParameter("courseName"));
        afc.setDeptCode(request.getParameter("deptCode"));
        afc.setDeptName(request.getParameter("deptName"));
        
        assignFacultyCourseDAO.save(afc);
        return afc;
    }

    @Override
    public AssignFacultyCourse update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AssignFacultyCourse delete(int id) {
        return assignFacultyCourseDAO.delete(id);
    }

    @Override
    public List<AssignFacultyCourse> getAll() {
        return assignFacultyCourseDAO.getAll();
    }

    @Override
    public AssignFacultyCourse getById(int id) {
        return assignFacultyCourseDAO.getById(id);
    }
}
