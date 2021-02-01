/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.IBookRequestDAO;
import com.spring.maven.model.BookRequest;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sany5
 */
@Repository(value = "bookRequestDAO")
@Transactional
public class BookRequestDAO implements IBookRequestDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public BookRequest save(BookRequest b) {
        sessionFactory.getCurrentSession().save(b);
        sessionFactory.getCurrentSession().flush();
        return b;
    }

    @Override
    public BookRequest update(BookRequest b) {
        sessionFactory.getCurrentSession().saveOrUpdate(b);
        sessionFactory.getCurrentSession().flush();
        return b;
    }

    @Override
    public BookRequest delete(int id) {
        BookRequest b = (BookRequest) sessionFactory.getCurrentSession().load(BookRequest.class, id);
        sessionFactory.getCurrentSession().delete(b);
        sessionFactory.getCurrentSession().flush();
        return b;
    }

    @Override
    public List<BookRequest> getAll() {
        List<BookRequest> b = sessionFactory.getCurrentSession().createCriteria(BookRequest.class).list();
        sessionFactory.getCurrentSession().flush();
        return b;
    }

    @Override
    public BookRequest getById(int id) {
        BookRequest b = (BookRequest) sessionFactory.getCurrentSession().get(BookRequest.class, id);
        sessionFactory.getCurrentSession().flush();
        return b;
    }
    
    

}
