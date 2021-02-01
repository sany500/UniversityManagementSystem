/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.service;

import com.spring.maven.dao.impl.IStudentDAO;
import com.spring.maven.dao.impl.IUserDAO;
import com.spring.maven.model.Student;
import com.spring.maven.model.User;
import com.spring.maven.model.UserRole;
import com.spring.maven.model.Users;

import com.spring.maven.service.impl.IStudentService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sany5
 */
@Service(value = "studentService")
public class StudentService implements IStudentService{
   @Autowired
   IStudentDAO studentDAO;
   
   @Autowired
   IUserDAO userDAO;
   

    @Override
    public Student save(HttpServletRequest request) {
       
       Student s = new Student();
       s.setSid(Integer.parseInt(request.getParameter("sid")));
       s.setName(request.getParameter("name"));
       s.setEmail(request.getParameter("email"));
       s.setPhone(request.getParameter("phone"));
       s.setAddress(request.getParameter("address"));
       s.setfName(request.getParameter("fname"));
       s.setmName(request.getParameter("mname"));
       s.setDob(request.getParameter("dob"));
       s.setReligion(request.getParameter("religion"));
       s.setBloodGroup(request.getParameter("bloodgroup"));
       s.setGender(request.getParameter("gender"));
       studentDAO.save(s);
       
       //Users Deatil Section
       User user=new User();
       user.setUserId(request.getParameter("sid"));
       user.setUserName(request.getParameter("name"));
       user.setUserEmail(request.getParameter("email"));
       user.setUserPhone(request.getParameter("phone"));
       user.setUserPassword(request.getParameter("sid"));
       user.setAddress(request.getParameter("address"));
       user.setDob(request.getParameter("dob"));
       user.setGender(request.getParameter("gender"));
       user.setUserRole("Student");
       
       //Login Section
       Users users = new Users();
       users.setUsername(request.getParameter("sid"));
       users.setPassword(request.getParameter("sid"));
       users.setActive(1);
       //Users Role Section
       UserRole urole = new UserRole();
       urole.setUsername(request.getParameter("sid"));
       urole.setRole("ROLE_ADMIN");
       
       
       userDAO.save(user, users, urole);
       return s;
    }

    @Override
    public Student update(HttpServletRequest request) {
       Student s = new Student();
       s.setId(Integer.parseInt(request.getParameter("id")));
       s.setSid(Integer.parseInt(request.getParameter("sid")));
       s.setName(request.getParameter("name"));
       s.setEmail(request.getParameter("email"));
       s.setPhone(request.getParameter("phone"));
       s.setAddress(request.getParameter("address"));
       s.setfName(request.getParameter("fname"));
       s.setmName(request.getParameter("mname"));
       s.setDob(request.getParameter("dob"));
       s.setReligion(request.getParameter("religion"));
       s.setBloodGroup(request.getParameter("bloodgroup"));
       s.setGender(request.getParameter("gender"));
       studentDAO.update(s);
       return s;
    }

    @Override
    public Student delete(int id) {
        return studentDAO.delete(id);
    }

    @Override
    public List<Student> getAll() {
        return studentDAO.getAll();
    }

    @Override
    public Student getById(int id) {
       return studentDAO.getById(id);
    }
   
   
}
