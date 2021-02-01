/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.maven.controller.impl.IDepartmentController;
import com.spring.maven.model.Department;
import com.spring.maven.model.University;
import com.spring.maven.service.impl.IDepartmentService;
import com.spring.maven.service.impl.IUniversityService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class DepartmentController implements IDepartmentController{
    
    @Autowired
    IUniversityService universityService;
    
    @Autowired
    IDepartmentService departmentService;
    
    
    
    @Override
    @RequestMapping(value = "/dSave")
    public ModelAndView save(HttpServletRequest request) {
       
        departmentService.save(request);
       return new ModelAndView("redirect:/department");
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
    public List<Department> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    public ModelAndView getAllUniversity() {
        
        List<University> u=universityService.getAll();
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("u", u);
        return new ModelAndView("/admin/department","map",map);
        
    }
    
    
    @RequestMapping(value = "/getDepartment/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllUniversity(@PathVariable("id") int id) {
        
        System.out.println("...................... " + id);
        GsonBuilder gson = new GsonBuilder();
        Gson g = gson.create();
        Department d=departmentService.getById(id);
        return g.toJson(d);
    }
    
    
    
}
