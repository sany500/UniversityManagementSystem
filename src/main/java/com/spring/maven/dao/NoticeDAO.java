/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.INoticeDAO;
import com.spring.maven.model.Attendance;

import com.spring.maven.model.Notice;
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
@Repository(value = "noticeDAO")
@Transactional
public class NoticeDAO implements INoticeDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Notice save(Notice n) {
        sessionFactory.getCurrentSession().save(n);
        sessionFactory.getCurrentSession().flush();
        return n;
    }

    @Override
    public Notice update(Notice n) {
        sessionFactory.getCurrentSession().saveOrUpdate(n);
        sessionFactory.getCurrentSession().flush();
        return n;
    }

    @Override
    public Notice delete(int id) {
        Notice n = (Notice) sessionFactory.getCurrentSession().load(Notice.class, id);
        sessionFactory.getCurrentSession().delete(n);
        sessionFactory.getCurrentSession().flush();
        return n;
    }

    @Override
    public List<Notice> getAll() {
        List<Notice> n = sessionFactory.getCurrentSession().createCriteria(Notice.class).list();
        sessionFactory.getCurrentSession().flush();
        return n;
    }

    @Override
    public Notice getById(int id) {
         Notice n = (Notice) sessionFactory.getCurrentSession().get(Notice.class, id);
        sessionFactory.getCurrentSession().flush();
        return n;
    }
    
    @Override
    public List<Notice> getAllByStudentPrivilege() {
        
       String hqlQuery = "from Notice where privilege=:privilege OR privilege=:privilegeAll";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
        query.setParameter("privilege", "Student");
        query.setParameter("privilegeAll", "All");
        List<Notice> nList = query.list();
        sessionFactory.getCurrentSession().flush();
        return nList;
    }

    @Override
    public List<Notice> getAllByFacultyPrivilege() {
        String hqlQuery = "from Notice where privilege=:privilege OR privilege=:privilegeAll";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
        query.setParameter("privilege", "Faculty");
        query.setParameter("privilegeAll", "All");
        List<Notice> nList = query.list();
        sessionFactory.getCurrentSession().flush();
        return nList;
    }

    

}
