/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao.impl;

import com.spring.maven.common.ICommonDAO;
import com.spring.maven.model.Student;

/**
 *
 * @author sany5
 */
public interface IStudentDAO extends ICommonDAO<Student>{
    public Student getStudentbySId(int sid);
}