/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.controller;

import com.spring.maven.dao.impl.IUserDAO;
import com.spring.maven.model.Notice;
import com.spring.maven.model.User;
import com.spring.maven.service.impl.INoticeService;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    IUserDAO userDAO;
    @Autowired
    INoticeService noticeService;

    @RequestMapping("/helloworld")
    public ModelAndView hello(ModelMap model, Principal principal) {

        String loggedInUserName = principal.getName();
        User u = userDAO.getUserByUserName(loggedInUserName);
        List<Notice> notice = noticeService.getAllByStudentPrivilege();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("notice", notice);

        map.put("user", u);

        return new ModelAndView("student/s_info", "map", map);
    }

    @RequestMapping("/admin")
    public ModelAndView helloAdmin(ModelMap model, Principal principal) {

        String loggedInUserName = principal.getName();

        return new ModelAndView("student/s_info", "userName", loggedInUserName);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "test/login";
    }

    @RequestMapping(value = "/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "test/login";
    }

    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied(Principal user) {

        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", You can not access this page!");
        } else {
            model.addObject("msg",
                    "You can not access this page!");
        }

        model.setViewName("403");
        return model;
    }

}
