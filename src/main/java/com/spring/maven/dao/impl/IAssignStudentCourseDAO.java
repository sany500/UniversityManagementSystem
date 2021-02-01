/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao.impl;

import com.spring.maven.common.ICommonDAO;
import com.spring.maven.model.AssignStudentCourse;
import java.util.List;

/**
 *
 * @author B13
 */
public interface IAssignStudentCourseDAO extends ICommonDAO<AssignStudentCourse>{
     public List<AssignStudentCourse> getAllbyCourse(String courseName, String semesterName);
     public AssignStudentCourse getStudentbyId(String sid);
     public List<AssignStudentCourse> getStudentCourseById(int sid);
    
    
}
