/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.IUserDAO;
import com.spring.maven.model.User;
import com.spring.maven.model.UserRole;
import com.spring.maven.model.Users;
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
@Repository(value = "userDAO")
@Transactional
public class UserDAO implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User save(User u) {
        sessionFactory.getCurrentSession().save(u);
        sessionFactory.getCurrentSession().flush();
        return u;
    }

    @Override
    public User save(User u, Users us, UserRole role) {
        sessionFactory.getCurrentSession().save(u);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().save(us);
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().save(role);
        sessionFactory.getCurrentSession().flush();
        return u;
    }

    @Override
    public User update(User u) {
        sessionFactory.getCurrentSession().save(u);
        sessionFactory.getCurrentSession().flush();
        return u;
    }

    @Override
    public User delete(int id) {
        User u = (User) sessionFactory.getCurrentSession().load(User.class, id);
        sessionFactory.getCurrentSession().delete(u);
        sessionFactory.getCurrentSession().flush();
        return u;
    }

    @Override
    public List<User> getAll() {
        List<User> u = sessionFactory.getCurrentSession().createCriteria(User.class).list();
        sessionFactory.getCurrentSession().flush();
        return u;
    }

    @Override
    public User getById(int id) {
        User u = (User) sessionFactory.getCurrentSession().get(User.class, id);
        sessionFactory.getCurrentSession().flush();
        return u;
    }

    @Override
    public User getUserByUserName(String userName) {
        String hql = "from User where userId =:username";
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        q.setParameter("username", userName);
        return (User) q.uniqueResult();
    }

}
