/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.IDepartmentDAO;
import com.spring.maven.model.Department;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sany5
 */
@Repository(value = "departmentDAO")
@Transactional
public class DepartmentDAO implements IDepartmentDAO{
    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public Department save(Department d) {
        sessionFactory.getCurrentSession().save(d);
        sessionFactory.getCurrentSession().flush();
        return d;
    }

    @Override
    public Department update(Department d) {
        sessionFactory.getCurrentSession().saveOrUpdate(d);
        sessionFactory.getCurrentSession().flush();
        return d;
    }

    @Override
    public Department delete(int id) {
        Department d=(Department) sessionFactory.getCurrentSession().load(Department.class, id);
        sessionFactory.getCurrentSession().delete(d);
        sessionFactory.getCurrentSession().flush();
        return d;
    }

    @Override
    public List<Department> getAll() {
         List<Department>  d = sessionFactory.getCurrentSession().createCriteria(Department.class).list();
        sessionFactory.getCurrentSession().flush();
        return d;
    }

    @Override
    public Department getById(int id) {
       Department d = (Department) sessionFactory.getCurrentSession().get(Department.class, id);
        sessionFactory.getCurrentSession().flush();
        return d;
    }
    
}
