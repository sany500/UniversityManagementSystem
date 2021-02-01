/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.ISemesterDAO;
import com.spring.maven.dao.impl.ISemesterFeeDAO;

import com.spring.maven.model.SemesterFee;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author B13
 */
@Repository(value = "semesterFeeDAO")
@Transactional
public class SemesterFeeDAO implements ISemesterFeeDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public SemesterFee save(SemesterFee s) {
        sessionFactory.getCurrentSession().save(s);
        sessionFactory.getCurrentSession().flush();
        return s;
    }

    @Override
    public SemesterFee update(SemesterFee s) {
        sessionFactory.getCurrentSession().saveOrUpdate(s);
        sessionFactory.getCurrentSession().flush();
        return s;
    }

    @Override
    public SemesterFee delete(int id) {
        SemesterFee s = (SemesterFee) sessionFactory.getCurrentSession().load(SemesterFee.class, id);
        sessionFactory.getCurrentSession().delete(s);
        sessionFactory.getCurrentSession().flush();
        return s;
    }

    @Override
    public List<SemesterFee> getAll() {
        List<SemesterFee> s = sessionFactory.getCurrentSession().createCriteria(SemesterFee.class).list();
        sessionFactory.getCurrentSession().flush();
        return s;
    }

    @Override
    public SemesterFee getById(int id) {
        SemesterFee s = (SemesterFee) sessionFactory.getCurrentSession().get(SemesterFee.class, id);
        sessionFactory.getCurrentSession().flush();
        return s;
    }

}
