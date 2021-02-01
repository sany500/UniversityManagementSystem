/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.controller;

import com.spring.maven.controller.impl.IAttendanceController;
import com.spring.maven.dao.impl.IAttendanceDAO;
import com.spring.maven.dao.impl.IUserDAO;
import com.spring.maven.model.AssignStudentCourse;
import com.spring.maven.model.Attendance;
import com.spring.maven.model.Course;
import com.spring.maven.model.Faculty;
import com.spring.maven.model.Semester;
import com.spring.maven.model.User;
import com.spring.maven.service.AssignStudentCourseService;

import com.spring.maven.service.impl.IAttendanceService;
import com.spring.maven.service.impl.ICourseService;
import com.spring.maven.service.impl.ISemesterService;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author B13
 */
@RestController
public class AttendanceController implements IAttendanceController {

    @Autowired
    IAttendanceService attendanceService;

    @Autowired
    AssignStudentCourseService assignStudentCourseService2;

    @Autowired
    IAttendanceDAO attendanceDAO;

    @Autowired
    ISemesterService semesterService;

    @Autowired
    ICourseService courseService;
    
    @Autowired
    IUserDAO userDAO;

    @Override
    @RequestMapping(value = "/attendanceSave")
    public ModelAndView save(HttpServletRequest request) {
        System.out.println("ct");
        attendanceService.save(request);
        return new ModelAndView("redirect:/createAttendance");
    }

    @Override
    public ModelAndView edit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Attendance> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @RequestMapping(value = "/attendanceReportMain")
    public ModelAndView attendanceReportMain(ModelMap model, Principal principal) {
        String loggedInUserName = principal.getName();
        User u = userDAO.getUserByUserName(loggedInUserName);
        List<Course> courses = courseService.getAll();
        List<Semester> semesters = semesterService.getAll();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("courses", courses);
        map.put("semesters", semesters);
        map.put("user", u);
        
        return new ModelAndView("/faculty/attendance_report_main", "map", map);

    }

    @RequestMapping(value = "/viewAttendance")
    public ModelAndView viewAttendance(HttpServletRequest request) {
        String uname = request.getUserPrincipal().getName();
        User u = userDAO.getUserByUserName(uname);
        String courseName = request.getParameter("courseName");
        String semesterName = request.getParameter("semesterName");

        List<Attendance> aList = attendanceDAO.getAttendancebySemesterAndCourse(courseName, semesterName);
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("aList", aList);
        map.put("user", u);

        return new ModelAndView("/faculty/attendance_view", "map", map);

    }

}
