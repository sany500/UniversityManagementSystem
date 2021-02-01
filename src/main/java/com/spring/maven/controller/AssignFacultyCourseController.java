/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.maven.controller.impl.IAssignFacultyCourseController;
import com.spring.maven.model.AssignFacultyCourse;
import com.spring.maven.model.Faculty;
import com.spring.maven.model.Student;
import com.spring.maven.service.impl.IAssignFacultyCourseService;
import com.spring.maven.service.impl.IFacultyService;
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
public class AssignFacultyCourseController implements IAssignFacultyCourseController{
    @Autowired
    IAssignFacultyCourseService assignFacultyCourseService;
    
    @Autowired
    IFacultyService facultyService;
    

    @Override
    @RequestMapping(value = "/afcSave")
    public ModelAndView save(HttpServletRequest request) {
        assignFacultyCourseService.save(request);
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
    public List<AssignFacultyCourse> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @RequestMapping(value = "/getFaculty/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getFaculty(@PathVariable("id") int id) {

        System.out.println("...................... " + id);
        GsonBuilder gson = new GsonBuilder();
        Gson g = gson.create();
        Faculty f = facultyService.getById(id);
        return g.toJson(f);
    }
    
}
