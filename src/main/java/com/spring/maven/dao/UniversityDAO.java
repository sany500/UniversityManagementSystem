/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.IUniversityDAO;
import com.spring.maven.model.University;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author B13
 */
@Repository(value = "universityDAO")
@Transactional
public class UniversityDAO implements IUniversityDAO{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public University save(University u) {
        sessionFactory.getCurrentSession().save(u);
        sessionFactory.getCurrentSession().flush();
        return u;
    }

    @Override
    public University update(University t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public University delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<University> getAll() {
        List<University> u = sessionFactory.getCurrentSession().createCriteria(University.class).list();
        sessionFactory.getCurrentSession().flush();
        return u;
    }

    @Override
    public University getById(int id) {
       University u = (University) sessionFactory.getCurrentSession().get(University.class, id);
        sessionFactory.getCurrentSession().flush();
        return u;
    }
    
}
