/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao.impl;

import com.spring.maven.common.ICommonDAO;
import com.spring.maven.model.Attendance;
import java.util.List;

/**
 *
 * @author B13
 */
public interface IAttendanceDAO extends ICommonDAO<Attendance>{
    public List<Attendance> getAttendancebySemesterAndCourse(String courseName, String semesterName);
    public List<Attendance> getAttendancebyUserId(String userId);
}
