/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.service;

import com.spring.maven.dao.impl.IApprovedBookRequestDAO;
import com.spring.maven.dao.impl.IBookRequestDAO;
import com.spring.maven.dao.impl.IUserDAO;
import com.spring.maven.model.ApprovedBookRequest;
import com.spring.maven.model.BookRequest;
import com.spring.maven.model.User;
import com.spring.maven.service.impl.IBookRequestService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sany5
 */
@Service(value = "bookRequestService")
public class BookRequestService implements IBookRequestService{
  @Autowired
  IBookRequestDAO bookRequestDAO;  

  @Autowired
  IUserDAO userDAO;
  
  @Autowired
  IApprovedBookRequestDAO ApprovedBookRequestDAO;
  
    @Override
    public BookRequest save(HttpServletRequest request) {
        String uname = request.getUserPrincipal().getName();
        User u = userDAO.getUserByUserName(uname);
        
        System.out.println(u.getUserName());
        System.out.println(u.getUserName());
        BookRequest b=new BookRequest();
        b.setBookCode(request.getParameter("bookCode"));
        b.setBookName(request.getParameter("bookName"));
        b.setAuthor(request.getParameter("author"));
        b.setGenre(request.getParameter("genre"));
        b.setPublisher(request.getParameter("publisher"));
        b.setQuantity(request.getParameter("quantity"));
        b.setEdition(request.getParameter("edition"));
        b.setPrice(request.getParameter("price"));
        b.setSid(Integer.parseInt(u.getUserId()));
        
        
        b.setName(u.getUserName());
        b.setEmail(u.getUserEmail());
        b.setPhone(u.getUserPhone());
        b.setAddress(u.getUserName());
        b.setStatus("Not Approved");
        
        
        
        
        bookRequestDAO.save(b);
        return b;
    }


    @Override
    public BookRequest update(HttpServletRequest request) {
         BookRequest b=new BookRequest();
        b.setId(Integer.parseInt(request.getParameter("id")));
        b.setBookCode(request.getParameter("bookCode"));
        b.setBookName(request.getParameter("bookName"));
        b.setAuthor(request.getParameter("author"));
        b.setGenre(request.getParameter("genre"));
        b.setPublisher(request.getParameter("publisher"));
        b.setQuantity(request.getParameter("quantity"));
        b.setEdition(request.getParameter("edition"));
        b.setPrice(request.getParameter("price"));
        b.setSid(Integer.parseInt(request.getParameter("sid")));
        b.setName(request.getParameter("name"));
        b.setEmail(request.getParameter("email"));
        b.setPhone(request.getParameter("phone"));
        b.setAddress(request.getParameter("address"));
        b.setStatus("Approved");
        bookRequestDAO.update(b);
        
        
        //Approve Book Request
        ApprovedBookRequest abr=new ApprovedBookRequest();
        
        abr.setId(Integer.parseInt(request.getParameter("id")));
        abr.setBookCode(request.getParameter("bookCode"));
        abr.setBookName(request.getParameter("bookName"));
        abr.setAuthor(request.getParameter("author"));
        abr.setGenre(request.getParameter("genre"));
        abr.setPublisher(request.getParameter("publisher"));
        abr.setQuantity(request.getParameter("quantity"));
        abr.setEdition(request.getParameter("edition"));
        abr.setPrice(request.getParameter("price"));
        abr.setSid(Integer.parseInt(request.getParameter("sid")));
        abr.setName(request.getParameter("name"));
        abr.setEmail(request.getParameter("email"));
        abr.setPhone(request.getParameter("phone"));
        abr.setAddress(request.getParameter("address"));
        abr.setStatus("Approved");
        
        ApprovedBookRequestDAO.save(abr);
        
        return b;
    }

    @Override
    public BookRequest delete(int id) {
        return bookRequestDAO.delete(id);
    }

    @Override
    public List<BookRequest> getAll() {
        return bookRequestDAO.getAll();
    }

    @Override
    public BookRequest getById(int id) {
         return bookRequestDAO.getById(id);
    }
}
