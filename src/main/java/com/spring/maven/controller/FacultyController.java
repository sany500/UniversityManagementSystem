/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.controller;

import com.spring.maven.controller.impl.IFacultyController;
import com.spring.maven.model.Faculty;
import com.spring.maven.service.impl.IFacultyService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FacultyController implements IFacultyController{
    @Autowired
    IFacultyService facultyService;
    
    
    @Override
    @RequestMapping(value = "/fSave")
    public ModelAndView save(HttpServletRequest request) {
        facultyService.save(request);
        return new ModelAndView("/admin/faculty");
    }

    @Override
    @RequestMapping(value = "/fEdit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int id) {
       Map<String, Object> map=new HashMap<String, Object>(); 
       Faculty f= facultyService.getById(id);
       
       map.put("f", f);
       return new ModelAndView("/admin/f_update", "map",map);
       
    }

    @Override
    @RequestMapping(value = "/fUpdate")
    public ModelAndView update(HttpServletRequest request) {
        facultyService.update(request);
        return new ModelAndView("redirect:/fView");
    }

    @Override
    @RequestMapping(value = "/fDelete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        facultyService.delete(id);
        return new ModelAndView("redirect:/fView");  
    }

    @Override
    public List<Faculty> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     @RequestMapping(value = "/fView")
    public ModelAndView viewAll() {
        List<Faculty> f = facultyService.getAll();
        
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("faculties", f);
        
        return new ModelAndView("/admin/f_view", "map",map);
        
        
    }
   
}
