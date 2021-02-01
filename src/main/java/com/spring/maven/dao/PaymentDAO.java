/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao;

import com.spring.maven.dao.impl.IPaymentDAO;
import com.spring.maven.model.Attendance;
import com.spring.maven.model.Payment;
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
@Repository(value = "paymentDAO")
@Transactional
public class PaymentDAO implements IPaymentDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Payment save(Payment p) {
         sessionFactory.getCurrentSession().save(p);
        sessionFactory.getCurrentSession().flush();
        return p;
    }

    @Override
    public Payment update(Payment p) {
        sessionFactory.getCurrentSession().saveOrUpdate(p);
        sessionFactory.getCurrentSession().flush();
        return p;
    }

    @Override
    public Payment delete(int id) {
        Payment p = (Payment) sessionFactory.getCurrentSession().load(Payment.class, id);
        sessionFactory.getCurrentSession().delete(p);
        sessionFactory.getCurrentSession().flush();
        return p;
    }

    @Override
    public List<Payment> getAll() {
        List<Payment> p = sessionFactory.getCurrentSession().createCriteria(Payment.class).list();
        sessionFactory.getCurrentSession().flush();
        return p;
    }

    @Override
    public Payment getById(int id) {
        Payment p = (Payment) sessionFactory.getCurrentSession().get(Payment.class, id);
        sessionFactory.getCurrentSession().flush();
        return p;
    }
    
     @Override
    public Payment getAllById(String semester, String studentId) {
        
        
        String hqlQuery = "from Payment where semesterName=:semesterName and studentId=:studentId";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery);
        query.setParameter("semesterName", semester);
        query.setParameter("studentId", studentId);
        Payment p = (Payment) query.uniqueResult();
         
        if(p != null){
            return p;
        }else{
        return null;
        }
        
    }
    
    

}
