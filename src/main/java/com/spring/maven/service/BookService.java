/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.service;

import com.spring.maven.dao.impl.IBookDAO;
import com.spring.maven.model.Book;
import com.spring.maven.service.impl.IBookService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sany5
 */
@Service(value = "bookService")
public class BookService implements IBookService {

    @Autowired
    IBookDAO bookDAO;

    @Override
    public Book save(HttpServletRequest request) {
        Book b = new Book();
        b.setBookCode(request.getParameter("bookCode"));
        b.setBookName(request.getParameter("bookName"));
        b.setAuthor(request.getParameter("author"));
        b.setGenre(request.getParameter("genre"));
        b.setPublisher(request.getParameter("publisher"));
        b.setQuantity(request.getParameter("quantity"));
        b.setEdition(request.getParameter("edition"));
        b.setPrice(request.getParameter("price"));
        bookDAO.save(b);
        return b;

    }

    @Override
    public Book update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book delete(int id) {
       return bookDAO.delete(id);
    }

    @Override
    public List<Book> getAll() {
       return bookDAO.getAll();
    }

    @Override
    public Book getById(int id) {
        return bookDAO.getById(id);
    }

}
