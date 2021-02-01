/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.service;

import com.spring.maven.dao.impl.IPaymentDAO;
import com.spring.maven.model.Payment;
import com.spring.maven.service.impl.IPaymentService;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sany5
 */
@Service(value = "paymentService")
public class PaymentService implements IPaymentService {

    @Autowired
    IPaymentDAO paymentDAO;

    @Override
    public Payment save(HttpServletRequest request) {

        Payment p = new Payment();
        p.setStudentName(request.getParameter("studentName"));
        p.setStudentId(request.getParameter("studentId"));
        p.setSemesterName(request.getParameter("semesterName"));
        p.setPaymentMethod(request.getParameter("paymentMethod"));
        p.setMobileNo(request.getParameter("mobileNo"));
        p.setTrId(request.getParameter("trId"));

        LocalDate currentDate = LocalDate.now();
        String cDate = currentDate.toString();
        p.setPaymentDate(cDate);
        p.setTutionFee(Integer.parseInt(request.getParameter("tutionFee")));
        p.setSpecialFee(Integer.parseInt(request.getParameter("specialFee")));
        p.setFacilitiesFee(Integer.parseInt(request.getParameter("facilitiesFee")));
        p.setStudentIdFee(Integer.parseInt(request.getParameter("studentIdFee")));
        p.setLibraryFee(Integer.parseInt(request.getParameter("libraryFee")));
        p.setTechnologyFee(Integer.parseInt(request.getParameter("technologyFee")));
        p.setRegistrationFee(Integer.parseInt(request.getParameter("registrationFee")));
        p.setHousingFee(Integer.parseInt(request.getParameter("housingFee")));
        p.setFinancialAid(Integer.parseInt(request.getParameter("financialAid")));
        p.setTotalFee(Integer.parseInt(request.getParameter("totalPayment")));

        

        paymentDAO.save(p);

        return p;
    }

    @Override
    public Payment update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Payment delete(int id) {
        return paymentDAO.delete(id);
    }

    @Override
    public List<Payment> getAll() {
        return paymentDAO.getAll();
    }

    @Override
    public Payment getById(int id) {
        return paymentDAO.getById(id);
    }

}
