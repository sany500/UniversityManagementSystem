/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.service;

import com.spring.maven.dao.impl.INoticeDAO;
import com.spring.maven.model.Notice;
import com.spring.maven.service.impl.INoticeService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sany5
 */
@Service(value = "noticeService")
public class NoticeService implements INoticeService{
    @Autowired
    INoticeDAO noticeDAO;
    @Override
    public Notice save(HttpServletRequest request) {
        
        Notice n=new Notice();
        n.setNoticeHeader(request.getParameter("noticeHeader"));
        n.setNoticeBody(request.getParameter("noticeBody"));
        n.setPrivilege(request.getParameter("privilege"));
        n.setNoticeDate(request.getParameter("noticeDate"));
        noticeDAO.save(n);
        return n;
    }

    @Override
    public Notice update(HttpServletRequest request) {
       Notice n=new Notice();
       n.setId(Integer.parseInt(request.getParameter("id")));
        n.setNoticeHeader(request.getParameter("noticeHeader"));
        n.setNoticeBody(request.getParameter("noticeBody"));
        n.setPrivilege(request.getParameter("privilege"));
        noticeDAO.update(n);
        return n;
    }

    @Override
    public Notice delete(int id) {
        return noticeDAO.delete(id);
    }

    @Override
    public List<Notice> getAll() {
        return noticeDAO.getAll();
    }

    @Override
    public Notice getById(int id) {
       return noticeDAO.getById(id);
    }
    
    @Override
    public List<Notice> getAllByStudentPrivilege() {
        return noticeDAO.getAllByStudentPrivilege();
    }
    @Override
    public List<Notice> getAllByFacultyPrivilege() {
        return noticeDAO.getAllByFacultyPrivilege();
    }
    
}
