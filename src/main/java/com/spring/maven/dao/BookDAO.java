/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.IBookDAO;
import com.spring.maven.model.Book;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sany5
 */
@Repository(value = "bookDAO")
@Transactional
public class BookDAO implements IBookDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Book save(Book b) {
        sessionFactory.getCurrentSession().save(b);
        sessionFactory.getCurrentSession().flush();
        return b;
    }

    @Override
    public Book update(Book b) {
        sessionFactory.getCurrentSession().saveOrUpdate(b);
        sessionFactory.getCurrentSession().flush();
        return b;
    }

    @Override
    public Book delete(int id) {
        Book b = (Book) sessionFactory.getCurrentSession().load(Book.class, id);
        sessionFactory.getCurrentSession().delete(b);
        sessionFactory.getCurrentSession().flush();
        return b;
    }

    @Override
    public List<Book> getAll() {
        List<Book> b = sessionFactory.getCurrentSession().createCriteria(Book.class).list();
        sessionFactory.getCurrentSession().flush();
        return b;
    }

    @Override
    public Book getById(int id) {
        Book b = (Book) sessionFactory.getCurrentSession().get(Book.class, id);
        sessionFactory.getCurrentSession().flush();
        return b;
    }

}
