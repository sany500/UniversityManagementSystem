/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.IAssignFacultyCourseDAO;
import com.spring.maven.model.AssignFacultyCourse;
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
@Repository(value = "assignFacultyCourseDAO")
@Transactional
public class AssignFacultyCourseDAO implements IAssignFacultyCourseDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public AssignFacultyCourse save(AssignFacultyCourse afc) {
        sessionFactory.getCurrentSession().save(afc);
        sessionFactory.getCurrentSession().flush();
        return afc;
    }

    @Override
    public AssignFacultyCourse update(AssignFacultyCourse afc) {
        sessionFactory.getCurrentSession().saveOrUpdate(afc);
        sessionFactory.getCurrentSession().flush();
        return afc;
    }

    @Override
    public AssignFacultyCourse delete(int id) {
       AssignFacultyCourse afc = (AssignFacultyCourse) sessionFactory.getCurrentSession().load(AssignFacultyCourse.class, id);
        sessionFactory.getCurrentSession().delete(afc);
        sessionFactory.getCurrentSession().flush();
        return afc;
    }

    @Override
    public List<AssignFacultyCourse> getAll() {
        List<AssignFacultyCourse> afc = sessionFactory.getCurrentSession().createCriteria(AssignFacultyCourse.class).list();
        sessionFactory.getCurrentSession().flush();
        return afc;
    }

    @Override
    public AssignFacultyCourse getById(int id) {
        AssignFacultyCourse afc = (AssignFacultyCourse) sessionFactory.getCurrentSession().get(AssignFacultyCourse.class, id);
        sessionFactory.getCurrentSession().flush();
        return afc;
    }
    
    
    @Override
    public List<AssignFacultyCourse> getAllFacultyCourseById(int fid) {
        String hqlQuery = "from AssignFacultyCourse where fid=:fid";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
        query.setParameter("fid", fid);
        List<AssignFacultyCourse> afcList = query.list();
        
        return afcList;
    }
}
