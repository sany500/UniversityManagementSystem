/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.controller;

import com.spring.maven.controller.impl.IStudentController;
import com.spring.maven.model.Student;
import com.spring.maven.service.impl.IStudentService;
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
public class StudentController implements IStudentController {

    @Autowired
    IStudentService studentService;

    @Override
    @RequestMapping(value = "/save")
    public ModelAndView save(HttpServletRequest request) {
        studentService.save(request);
       
        return new ModelAndView("/admin/students");
        
    }

    @Override
    @RequestMapping(value = "/sEdit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int id) {
       Map<String, Object> map=new HashMap<String, Object>(); 
       Student s= studentService.getById(id);
       
       map.put("s", s);
       return new ModelAndView("/admin/s_update", "map",map);
       
    }

    @Override
    @RequestMapping(value = "/sUpdate")
    public ModelAndView update(HttpServletRequest request) {
        studentService.update(request);
        return new ModelAndView("redirect:/sView");
    }

    @Override
    public ModelAndView delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/getAll")
    public List<Student> getAll() {
         List<Student> students= studentService.getAll();
//         for (Student student : students) {
//             System.out.println(student.getName());
//        }
         System.out.println("Hitted");
        return students;
    }

    @RequestMapping(value = "/sView")
    public ModelAndView viewAll() {
        List<Student> s = studentService.getAll();
        
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("students", s);
        
        return new ModelAndView("/admin/s_view", "map",map);
        
        
    }
    
    
    @RequestMapping(value = "/sDelete/{id}", method = RequestMethod.GET)
    public ModelAndView facultyDelete(@PathVariable("id") int id) { 
        studentService.delete(id);
        return new ModelAndView("redirect:/sView");  
    }
}
