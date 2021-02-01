/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.IFacultyDAO;
import com.spring.maven.model.Faculty;
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
@Repository(value = "facultyDAO")
@Transactional
public class FacultyDAO implements IFacultyDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Faculty save(Faculty f) {
        sessionFactory.getCurrentSession().save(f);
        sessionFactory.getCurrentSession().flush();
        return f;
    }

    @Override
    public Faculty update(Faculty f) {
        sessionFactory.getCurrentSession().saveOrUpdate(f);
        sessionFactory.getCurrentSession().flush();
        return f;
    }

    @Override
    public Faculty delete(int id) {
        Faculty f=(Faculty) sessionFactory.getCurrentSession().load(Faculty.class, id);
        sessionFactory.getCurrentSession().delete(f);
        sessionFactory.getCurrentSession().flush();
        return f;
    }

    @Override
    public List<Faculty> getAll() {
       List<Faculty>  f = sessionFactory.getCurrentSession().createCriteria(Faculty.class).list();
        sessionFactory.getCurrentSession().flush();
        return f;
    }

    @Override
    public Faculty getById(int id) {
       Faculty f = (Faculty) sessionFactory.getCurrentSession().get(Faculty.class, id);
        sessionFactory.getCurrentSession().flush();
        return f;
    }
    
    @Override
    public Faculty getFacultyByFid(int fid) {
        String hqlQuery = "from Faculty where fid=:fid";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
        query.setParameter("fid", fid);
        
        Faculty afc = (Faculty) query.uniqueResult();
        sessionFactory.getCurrentSession().flush();

        System.out.println(afc.getName());

        return afc;
    }
}
