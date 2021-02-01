/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.maven.controller.impl.IBookController;
import com.spring.maven.dao.impl.IUserDAO;
import com.spring.maven.model.Book;
import com.spring.maven.model.BookRequest;
import com.spring.maven.model.Student;
import com.spring.maven.model.User;
import com.spring.maven.service.impl.IBookRequestService;
import com.spring.maven.service.impl.IBookService;
import com.spring.maven.service.impl.IStudentService;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author B13
 */
@RestController
public class BookController implements IBookController{
    @Autowired
    IBookService bookService;
    @Autowired
    IStudentService studentService;
    
    @Autowired
    IBookRequestService bookRequestService;
    
    @Autowired
    IUserDAO userDAO;

    @Override
    @RequestMapping(value = "/bookSave")
    public ModelAndView save(HttpServletRequest request) {
       bookService.save(request);
        return new ModelAndView("/admin/library");
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
    public List<Book> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @RequestMapping(value = "/bookRequestConfirm/{id}", method = RequestMethod.GET)
    public ModelAndView bookRequestConfirm(@PathVariable("id") int id,ModelMap model, Principal principal) {
        String loggedInUserName = principal.getName();
        User u = userDAO.getUserByUserName(loggedInUserName);
       Map<String, Object> map=new HashMap<String, Object>(); 
       Book book= bookService.getById(id);
       
       
       map.put("book", book);
       map.put("user", u);
       
       return new ModelAndView("/student/book_request_confirm", "map",map);
       
    }
   
    
     @RequestMapping(value = "/bookRequestConfirm/getStudent/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getStudent(@PathVariable("id") int id) {

        System.out.println("...................... " + id);
        GsonBuilder gson = new GsonBuilder();
        Gson g = gson.create();
        Student s = studentService.getById(id);
        return g.toJson(s);
    }

    @RequestMapping(value = "/bookApproval/{id}", method = RequestMethod.GET)
    public ModelAndView bookApproval(@PathVariable("id") int id) {
       Map<String, Object> map=new HashMap<String, Object>(); 
       BookRequest book= bookRequestService.getById(id);
       
       
       map.put("book", book);
      
       return new ModelAndView("/admin/book_approval", "map",map);
       
    }
}
