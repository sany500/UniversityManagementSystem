/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.service;

import com.spring.maven.dao.impl.IFacultyDAO;
import com.spring.maven.dao.impl.IUserDAO;
import com.spring.maven.model.Faculty;
import com.spring.maven.model.User;
import com.spring.maven.model.UserRole;
import com.spring.maven.model.Users;
import com.spring.maven.service.impl.IFacultyService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sany5
 */
@Service(value = "facultyService")
public class FacultyService implements IFacultyService {

    @Autowired
    IFacultyDAO facultyDAO;
    @Autowired
    IUserDAO userDAO;

    @Override
    public Faculty save(HttpServletRequest request) {

        Faculty f = new Faculty();
        f.setFid(Integer.parseInt(request.getParameter("fid")));
        f.setName(request.getParameter("name"));
        f.setEmail(request.getParameter("email"));
        f.setPhone(request.getParameter("phone"));
        f.setAddress(request.getParameter("address"));
        f.setDesignation(request.getParameter("designation"));
        f.setDob(request.getParameter("dob"));
        f.setReligion(request.getParameter("religion"));
        f.setBloodGroup(request.getParameter("bloodgroup"));
        f.setGender(request.getParameter("gender"));
        
        //Users Deatil Section
       User user=new User();
       user.setUserId(request.getParameter("fid"));
       user.setUserName(request.getParameter("name"));
       user.setUserEmail(request.getParameter("email"));
       user.setUserPhone(request.getParameter("phone"));
       user.setUserPassword(request.getParameter("fid"));
       user.setAddress(request.getParameter("address"));
       user.setDob(request.getParameter("dob"));
       user.setGender(request.getParameter("gender"));
       user.setUserRole("Faculty");
       
       //Login Section
       Users users = new Users();
       users.setUsername(request.getParameter("fid"));
       users.setPassword(request.getParameter("fid"));
       users.setActive(1);
       //Users Role Section
       UserRole urole = new UserRole();
       urole.setUsername(request.getParameter("fid"));
       urole.setRole("ROLE_ADMIN");
       
       
       userDAO.save(user, users, urole);
        

        facultyDAO.save(f);
        return f;
    }

    @Override
    public Faculty update(HttpServletRequest request) {
        Faculty f = new Faculty();
        f.setId(Integer.parseInt(request.getParameter("id")));
        f.setFid(Integer.parseInt(request.getParameter("fid")));
        f.setName(request.getParameter("name"));
        f.setEmail(request.getParameter("email"));
        f.setPhone(request.getParameter("phone"));
        f.setAddress(request.getParameter("address"));
        f.setDesignation(request.getParameter("designation"));
        f.setDob(request.getParameter("dob"));
        f.setReligion(request.getParameter("religion"));
        f.setBloodGroup(request.getParameter("bloodgroup"));
        f.setGender(request.getParameter("gender"));

        facultyDAO.update(f);
        return f;
    }

    @Override
    public Faculty delete(int id) {
        return facultyDAO.delete(id);
    }

    @Override
    public List<Faculty> getAll() {
        return facultyDAO.getAll();
    }

    @Override
    public Faculty getById(int id) {
        return facultyDAO.getById(id);
    }

}
