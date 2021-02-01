/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.IAttendanceDAO;
import com.spring.maven.model.Attendance;
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
@Repository(value = "attendanceDAO")
@Transactional
public class AttendanceDAO implements IAttendanceDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Attendance save(Attendance a) {
        sessionFactory.getCurrentSession().save(a);
        sessionFactory.getCurrentSession().flush();
        return a;
    }

    @Override
    public Attendance update(Attendance a) {
        sessionFactory.getCurrentSession().saveOrUpdate(a);
        sessionFactory.getCurrentSession().flush();
        return a;
    }

    @Override
    public Attendance delete(int id) {
        Attendance a = (Attendance) sessionFactory.getCurrentSession().load(Attendance.class, id);
        sessionFactory.getCurrentSession().delete(a);
        sessionFactory.getCurrentSession().flush();
        return a;
    }

    @Override
    public List<Attendance> getAll() {
        List<Attendance> aList = sessionFactory.getCurrentSession().createCriteria(Attendance.class).list();
        sessionFactory.getCurrentSession().flush();
        return aList;
    }

    @Override
    public Attendance getById(int id) {
        Attendance a = (Attendance) sessionFactory.getCurrentSession().get(Attendance.class, id);
        sessionFactory.getCurrentSession().flush();
        return a;
    }
//Test Purpose

    public void hqlQuery(String st) {
        String hqlQuery = "from emp where area=:area";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
        query.setParameter("area", st);
        List<Attendance> aList = query.list();
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public List<Attendance> getAttendancebySemesterAndCourse(String courseName, String studentSemester) {

        String hqlQuery = "from Attendance where courseName=:courseName and studentSemester=:studentSemester";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
        query.setParameter("courseName", courseName);
        query.setParameter("studentSemester", studentSemester);
        List<Attendance> aList = query.list();
        
        return aList;
    }

    @Override
    public List<Attendance> getAttendancebyUserId(String userId) {
       
        String hqlQuery = "from Attendance where studentId=:userId";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
        query.setParameter("userId", userId);
        
        List<Attendance> aList = query.list();
        
        return aList;
    }

}
