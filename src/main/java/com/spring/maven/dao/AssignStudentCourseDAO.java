/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.IAssignStudentCourseDAO;
import com.spring.maven.model.AssignStudentCourse;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author B13
 */
@Repository(value = "assignStudentCourseDAO")
@Transactional
public class AssignStudentCourseDAO implements IAssignStudentCourseDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public AssignStudentCourse save(AssignStudentCourse asc) {
        System.out.println(asc.getEmail());
        sessionFactory.getCurrentSession().save(asc);
        sessionFactory.getCurrentSession().flush();
        return asc;
    }

    @Override
    public AssignStudentCourse update(AssignStudentCourse asc) {

        sessionFactory.getCurrentSession().saveOrUpdate(asc);
        sessionFactory.getCurrentSession().flush();
        return asc;
    }

    @Override
    public AssignStudentCourse delete(int id) {
        AssignStudentCourse asc = (AssignStudentCourse) sessionFactory.getCurrentSession().load(AssignStudentCourse.class, id);
        sessionFactory.getCurrentSession().delete(asc);
        sessionFactory.getCurrentSession().flush();
        return asc;
    }

    @Override
    public List<AssignStudentCourse> getAll() {
        List<AssignStudentCourse> asc = sessionFactory.getCurrentSession().createCriteria(AssignStudentCourse.class).list();
        sessionFactory.getCurrentSession().flush();
        return asc;
    }

    @Override
    public AssignStudentCourse getById(int id) {
        AssignStudentCourse asc = (AssignStudentCourse) sessionFactory.getCurrentSession().get(AssignStudentCourse.class, id);
        sessionFactory.getCurrentSession().flush();
        return asc;
    }

    /////Querry/////////
    @Override
    public List<AssignStudentCourse> getAllbyCourse(String courseName, String semesterName) {
        String hqlQuery = "from AssignStudentCourse where courseName=:courseName and semesterName=:semesterName";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
        query.setParameter("courseName", courseName);
        query.setParameter("semesterName", semesterName);
        System.out.println("-------" + courseName + "-------" + semesterName);
        List<AssignStudentCourse> aList = query.list();
        sessionFactory.getCurrentSession().flush();

        for (AssignStudentCourse aList1 : aList) {
            System.out.println(aList1.getDeptName());
            System.out.println(aList1.getName());
        }

        return aList;
    }

    @Override
    public AssignStudentCourse getStudentbyId(String id) {
        String hqlQuery = "from AssignStudentCourse where id=:id";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
        query.setParameter("id", id);

        AssignStudentCourse asc = (AssignStudentCourse) query.uniqueResult();
        sessionFactory.getCurrentSession().flush();

        System.out.println(asc.getName());

        return asc;
    }

    @Override
    public List<AssignStudentCourse> getStudentCourseById(int sid) {
        String hqlQuery = "from AssignStudentCourse where sid=:sid";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
        query.setParameter("sid", sid);

        List<AssignStudentCourse> asc = query.list();
        for (AssignStudentCourse asc1 : asc) {
            System.out.println(asc1.getCourseName());
        }
        sessionFactory.getCurrentSession().flush();

        return asc;
    }

    

}
