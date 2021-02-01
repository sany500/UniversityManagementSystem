/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.service;

import com.spring.maven.dao.impl.IAttendanceDAO;
import com.spring.maven.model.Attendance;
import com.spring.maven.service.impl.IAttendanceService;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B13
 */
@Service(value = "attendanceService")
public class AttendanceService implements IAttendanceService {

    @Autowired
    IAttendanceDAO attendanceDAO;

    @Override
    public Attendance save(HttpServletRequest request) {
        System.out.println("srv");

        Map<String, String[]> requestMap = request.getParameterMap();

        String[] ids = (String[]) requestMap.get("studentId[]");
        String[] sid = (String[]) requestMap.get("studentsId[]");

        // String[] status = (String[]) requestMap.get("attendanceStatus[]");
        String[] facultyName = (String[]) requestMap.get("facultyName[]");
        String[] courseName = (String[]) requestMap.get("courseName[]");
        String[] date = (String[]) requestMap.get("date[]");

        String[] names = (String[]) requestMap.get("studentName[]");
        String[] studentSemester = (String[]) requestMap.get("studentSemester[]");

        String[] attendanceStatus = (String[]) requestMap.get("attendanceStatus[]");

        Attendance attendance;

        for (int i = 0; i < ids.length; i++) {

            attendance = new Attendance();
            
            attendance.setStudentId(sid[i]);
            attendance.setStudentName(names[i]);
            attendance.setCourseName(courseName[i]);
            attendance.setFacultyName(facultyName[i]);
            LocalDate currentDate=LocalDate.now();
            String cDate=currentDate.toString();
            attendance.setDate(cDate);
            
            attendance.setStudentSemester(studentSemester[i]);
             boolean status = Arrays.stream(attendanceStatus).anyMatch(ids[i]::equals);
                if (status) {
                 attendance.setStatus("Present");
                }else{
                 attendance.setStatus("Absent");
                }
            attendanceDAO.save(attendance);
        }

        return null;
    }

    @Override
    public Attendance update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Attendance delete(int id) {
        return attendanceDAO.delete(id);
    }

    @Override
    public List<Attendance> getAll() {
        return attendanceDAO.getAll();
    }

    @Override
    public Attendance getById(int id) {
        return attendanceDAO.getById(id);
    }

}
