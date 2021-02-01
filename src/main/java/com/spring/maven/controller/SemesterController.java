/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.maven.controller.impl.ISemesterController;
import com.spring.maven.model.AssignFacultyCourse;
import com.spring.maven.model.Semester;
import com.spring.maven.service.impl.ISemesterService;
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
public class SemesterController implements ISemesterController{
    @Autowired
    ISemesterService semesterService;
    
    
    @Override
    @RequestMapping(value = "/semisterSave")
    public ModelAndView save(HttpServletRequest request) {
        semesterService.save(request);
        return new ModelAndView("redirect:/semister");
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
    public List<Semester> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @RequestMapping(value = "/getSemester1/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSemester1(@PathVariable("id") int id) {

        
        GsonBuilder gson = new GsonBuilder();
        Gson g = gson.create();
        Semester s = semesterService.getById(id);
        return g.toJson(s);
    }
    
    
}
