/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.IMarksDAO;
import com.spring.maven.model.Marks;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sany5
 */
@Repository(value = "marksDAO")
@Transactional
public class MarksDAO implements IMarksDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Marks save(Marks m) {
        sessionFactory.getCurrentSession().save(m);
        sessionFactory.getCurrentSession().flush();
        return m;
    }

    @Override
    public Marks update(Marks m) {
        sessionFactory.getCurrentSession().save(m);
        sessionFactory.getCurrentSession().flush();
        return m;
    }

    @Override
    public Marks delete(int id) {
        Marks m = (Marks) sessionFactory.getCurrentSession().load(Marks.class, id);
        sessionFactory.getCurrentSession().delete(m);
        sessionFactory.getCurrentSession().flush();
        return m;
    }

    @Override
    public List<Marks> getAll() {
        List<Marks> m = sessionFactory.getCurrentSession().createCriteria(Marks.class).list();
        sessionFactory.getCurrentSession().flush();
        return m;
    }

    @Override
    public Marks getById(int id) {
        Marks m = (Marks) sessionFactory.getCurrentSession().get(Marks.class, id);
        sessionFactory.getCurrentSession().flush();
        return m;
    }

}
