/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.IResultDAO;
import com.spring.maven.model.Result;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sany5
 */
@Repository(value = "resultDAO")
@Transactional
public class ResultDAO implements IResultDAO{
   @Autowired
    SessionFactory sessionFactory; 

    @Override
    public Result save(Result r) {
       sessionFactory.getCurrentSession().save(r);
        sessionFactory.getCurrentSession().flush();
        return r;
    }

    @Override
    public Result update(Result r) {
        sessionFactory.getCurrentSession().saveOrUpdate(r);
        sessionFactory.getCurrentSession().flush();
        return r;
    }

    @Override
    public Result delete(int id) {
        Result r = (Result) sessionFactory.getCurrentSession().load(Result.class, id);
        sessionFactory.getCurrentSession().delete(r);
        sessionFactory.getCurrentSession().flush();
        return r;
    }

    @Override
    public List<Result> getAll() {
        List<Result> r = sessionFactory.getCurrentSession().createCriteria(Result.class).list();
        sessionFactory.getCurrentSession().flush();
        return r;
    }

    @Override
    public Result getById(int id) {
        Result r = (Result) sessionFactory.getCurrentSession().get(Result.class, id);
        sessionFactory.getCurrentSession().flush();
        return r;
    }

    @Override
    public List<Result> getResultByUserId(String sid) {
       String hqlQuery = "from Result where sid=:sid";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
        query.setParameter("sid", sid);
        
        List<Result> rList = query.list();
        
        return rList;
    }
    
    
}
