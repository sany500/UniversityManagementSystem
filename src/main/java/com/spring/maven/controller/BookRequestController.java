/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.controller;

import com.spring.maven.controller.impl.IBookRequestController;
import com.spring.maven.model.BookRequest;
import com.spring.maven.service.impl.IBookRequestService;
import java.security.Principal;
import java.util.List;
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
public class BookRequestController implements IBookRequestController{
    
    @Autowired
    IBookRequestService bookRequestService;

    @Override
    @RequestMapping(value = "/bookRequestSave1")
    public ModelAndView save(HttpServletRequest request) {
        bookRequestService.save(request);
        return new ModelAndView("redirect:/sLibrary");
    }
    
    @RequestMapping(value = "/bookRequestSave")
    public ModelAndView save1(HttpServletRequest request, Principal p) {
        //request.
        bookRequestService.save(request);
        return new ModelAndView("redirect:/sLibrary");
    }

    @Override
    public ModelAndView edit(int id) {
       
        return new ModelAndView("redirect:/library");
    }

    @Override
    @RequestMapping(value = "/approveBookRequest")
    public ModelAndView update(HttpServletRequest request) {
       bookRequestService.update(request);
        return new ModelAndView("redirect:/library");
    }

    @Override
    public ModelAndView delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BookRequest> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
