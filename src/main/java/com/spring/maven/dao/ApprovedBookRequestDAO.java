/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.IApprovedBookRequestDAO;
import com.spring.maven.model.ApprovedBookRequest;
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
@Repository(value = "approvedBookRequestDAO")
@Transactional
public class ApprovedBookRequestDAO implements IApprovedBookRequestDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public ApprovedBookRequest save(ApprovedBookRequest b) {
       sessionFactory.getCurrentSession().save(b);
        sessionFactory.getCurrentSession().flush();
        return b;
    }

    @Override
    public ApprovedBookRequest update(ApprovedBookRequest b) {
        sessionFactory.getCurrentSession().saveOrUpdate(b);
        sessionFactory.getCurrentSession().flush();
        return b;
    }

    @Override
    public ApprovedBookRequest delete(int id) {
        ApprovedBookRequest b = (ApprovedBookRequest) sessionFactory.getCurrentSession().load(ApprovedBookRequest.class, id);
        sessionFactory.getCurrentSession().delete(b);
        sessionFactory.getCurrentSession().flush();
        return b;
    }

    @Override
    public List<ApprovedBookRequest> getAll() {
        List<ApprovedBookRequest> b = sessionFactory.getCurrentSession().createCriteria(ApprovedBookRequest.class).list();
        sessionFactory.getCurrentSession().flush();
        return b;
    }

    @Override
    public ApprovedBookRequest getById(int id) {
       ApprovedBookRequest b = (ApprovedBookRequest) sessionFactory.getCurrentSession().get(ApprovedBookRequest.class, id);
        sessionFactory.getCurrentSession().flush();
        return b;
    }
    
    @Override
    public List<ApprovedBookRequest> getApprovedBookRequestBySId(int sid) {
        String hqlQuery = "from ApprovedBookRequest where sid=:sid";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
        query.setParameter("sid", sid);
        
        List<ApprovedBookRequest> asc = query.list();
        sessionFactory.getCurrentSession().flush();

        return asc;
    }
    
}
