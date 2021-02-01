/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.controller;

import com.spring.maven.model.Notice;
import com.spring.maven.service.impl.INoticeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sany5
 */
@RestController
public class TestController {
    
    @Autowired
    INoticeService noticeService;
    
    @RequestMapping("/testJsp")
    public ModelAndView testJsp() {
       
        return new ModelAndView("/test/test");

    }
    
    
    @RequestMapping("/hello")
    public ModelAndView notice() {
        List<Notice> notice = noticeService.getAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("notice", notice);
        return new ModelAndView("/test/header", "map", map);
    }
}
