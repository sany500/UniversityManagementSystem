/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.service;

import com.spring.maven.dao.impl.IUniversityDAO;
import com.spring.maven.model.University;
import com.spring.maven.service.impl.IUniversityService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author B13
 */
@Service(value = "universityService")
public class UniversityService implements IUniversityService{
    @Autowired
    IUniversityDAO universityDAO;

    @Override
    public University save(HttpServletRequest request) {
        
        University u= new University();
        
        
        u.setUniCode(request.getParameter("uid"));
        u.setUniName(request.getParameter("name"));
        System.out.println(u.getId());
        universityDAO.save(u);
        return u;
    }

    @Override
    public University update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public University delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<University> getAll() {
        return universityDAO.getAll();
    }

    @Override
    public University getById(int id) {
       return universityDAO.getById(id);
    }
    
}
