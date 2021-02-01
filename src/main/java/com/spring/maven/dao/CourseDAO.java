/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.ICourseDAO;
import com.spring.maven.model.Course;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sany5
 */
@Repository(value = "courseDAO")
@Transactional
public class CourseDAO implements ICourseDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Course save(Course c) {
        sessionFactory.getCurrentSession().save(c);
        sessionFactory.getCurrentSession().flush();
        return c;
    }

    @Override
    public Course update(Course c) {
        sessionFactory.getCurrentSession().saveOrUpdate(c);
        sessionFactory.getCurrentSession().flush();
        return c;
    }

    @Override
    public Course delete(int id) {
        Course c = (Course) sessionFactory.getCurrentSession().load(Course.class, id);
        sessionFactory.getCurrentSession().delete(c);
        sessionFactory.getCurrentSession().flush();
        return c;
    }

    @Override
    public List<Course> getAll() {
        List<Course> c = sessionFactory.getCurrentSession().createCriteria(Course.class).list();
        sessionFactory.getCurrentSession().flush();
        return c;
    }

    @Override
    public Course getById(int id) {
        Course c = (Course) sessionFactory.getCurrentSession().get(Course.class, id);
        sessionFactory.getCurrentSession().flush();
        return c;
    }

}
