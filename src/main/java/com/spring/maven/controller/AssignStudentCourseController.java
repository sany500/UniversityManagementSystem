/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.maven.controller.impl.IAssignStudentCourseController;
import com.spring.maven.model.AssignStudentCourse;
import com.spring.maven.model.Course;
import com.spring.maven.model.Semester;

import com.spring.maven.model.Student;
import com.spring.maven.service.impl.IAssignStudentCourseService;
import com.spring.maven.service.impl.ICourseService;
import com.spring.maven.service.impl.ISemesterService;
import com.spring.maven.service.impl.IStudentService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sany5
 */
@RestController
public class AssignStudentCourseController implements IAssignStudentCourseController {

    @Autowired
    IAssignStudentCourseService assignStudentCourseService;

    @Autowired
    IStudentService studentService;

    @Autowired
    ISemesterService semesterService;

    @Autowired
    ICourseService courseService;

    @Override
    @RequestMapping(value = "/ascSave")
    public ModelAndView save(HttpServletRequest request) {
        assignStudentCourseService.save(request);
        return new ModelAndView("redirect:/assignCourse");
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
    public List<AssignStudentCourse> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    @RequestMapping(value = "/getStudent/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getStudent(@PathVariable("id") int id) {

        System.out.println("...................... " + id);
        GsonBuilder gson = new GsonBuilder();
        Gson g = gson.create();
        Student s = studentService.getById(id);
        return g.toJson(s);
    }

    
    
    
    @RequestMapping(value = "/getSemester/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSemester(@PathVariable("id") int id) {

        System.out.println("...................... " + id);
        GsonBuilder gson = new GsonBuilder();
        Gson g = gson.create();
        Semester s = semesterService.getById(id);
        return g.toJson(s);
    }

    
    
    @RequestMapping(value = "/getCourse/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCourse(@PathVariable("id") int id) {

        System.out.println("...................... " + id);
        GsonBuilder gson = new GsonBuilder();
        Gson g = gson.create();
        Course c = courseService.getById(id);
        return g.toJson(c);
    }

}
