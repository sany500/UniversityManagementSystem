/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.ISemesterDAO;

import com.spring.maven.model.Semester;
import com.spring.maven.model.SemesterFee;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sany5
 */
@Repository(value = "semesterDAO")
@Transactional
public class SemesterDAO implements ISemesterDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Semester save(Semester s) {
        sessionFactory.getCurrentSession().save(s);
        sessionFactory.getCurrentSession().flush();
        return s;
    }

    @Override
    public Semester update(Semester s) {
        sessionFactory.getCurrentSession().saveOrUpdate(s);
        sessionFactory.getCurrentSession().flush();
        return s;
    }

    @Override
    public Semester delete(int id) {
        Semester s = (Semester) sessionFactory.getCurrentSession().load(Semester.class, id);
        sessionFactory.getCurrentSession().delete(s);
        sessionFactory.getCurrentSession().flush();
        return s;
    }

    @Override
    public List<Semester> getAll() {
        List<Semester> s = sessionFactory.getCurrentSession().createCriteria(Semester.class).list();
        sessionFactory.getCurrentSession().flush();
        return s;
    }

    @Override
    public Semester getById(int id) {
        Semester s = (Semester) sessionFactory.getCurrentSession().get(Semester.class, id);
        sessionFactory.getCurrentSession().flush();
        return s;
    }


}
