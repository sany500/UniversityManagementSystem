/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.controller;

import com.spring.maven.controller.impl.IResultController;
import com.spring.maven.model.AssignStudentCourse;
import com.spring.maven.model.Result;
import com.spring.maven.service.impl.IAssignStudentCourseService;

import com.spring.maven.service.impl.IResultService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sany5
 */
@RestController
public class ResultController implements IResultController {

    @Autowired
    IResultService resultService;

    @Autowired
    IAssignStudentCourseService assignStudentCourseService;

    @Override
    @RequestMapping(value = "/resultInputSave")
    public ModelAndView save(HttpServletRequest request) {
        resultService.save(request);
        return new ModelAndView("redirect:/createResult");
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
    public List<Result> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
