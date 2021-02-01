/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.controller;

import com.spring.maven.controller.impl.IPaymentController;
import com.spring.maven.model.Payment;
import com.spring.maven.model.Student;
import com.spring.maven.service.impl.IPaymentService;
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
public class PaymentController implements IPaymentController{
    @Autowired
    IPaymentService paymentService;
    
    @Override
    @RequestMapping(value = "/paymentSave")
    public ModelAndView save(HttpServletRequest request) {
        paymentService.save(request);
        return new ModelAndView("redirect:/sSemesterFee");
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
    public List<Payment> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @RequestMapping(value = "/paymentInvoice/{id}", method = RequestMethod.GET)
    public ModelAndView paymentInvoice(@PathVariable("id") int id) {
       Map<String, Object> map=new HashMap<String, Object>(); 
       Payment p= paymentService.getById(id);
       
       map.put("p", p);
       return new ModelAndView("/admin/payment_invoice", "map",map);
       
    }
    
}
