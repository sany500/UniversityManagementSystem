/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.IStudentDAO;
import com.spring.maven.model.Student;

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
@Repository(value = "studentDAO")
@Transactional
public class StudentDAO implements IStudentDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Student save(Student s) {

        sessionFactory.getCurrentSession().save(s);
        sessionFactory.getCurrentSession().flush();
        return s;
    }

    @Override
    public Student update(Student s) {
        sessionFactory.getCurrentSession().saveOrUpdate(s);
        sessionFactory.getCurrentSession().flush();
        return s;
    }

    @Override
    public Student delete(int id) {
        Student st = (Student) sessionFactory.getCurrentSession().load(Student.class, id);
        sessionFactory.getCurrentSession().delete(st);
        sessionFactory.getCurrentSession().flush();
        return st;
    }

    @Override
    public List<Student> getAll() {
        List<Student> s = sessionFactory.getCurrentSession().createCriteria(Student.class).list();
        sessionFactory.getCurrentSession().flush();
        return s;
    }

    @Override
    public Student getById(int id) {
        Student s = (Student) sessionFactory.getCurrentSession().get(Student.class, id);
        sessionFactory.getCurrentSession().flush();
        return s;
    }
    @Override
    public Student getStudentbySId(int sid) {
        String hqlQuery = "from Student where sid=:sid";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
        query.setParameter("sid", sid);
        
        Student asc = (Student) query.uniqueResult();
        sessionFactory.getCurrentSession().flush();

        System.out.println(asc.getName());

        return asc;
    }
}
