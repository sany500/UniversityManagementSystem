/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.maven.dao.impl;

import com.spring.maven.common.ICommonDAO;
import com.spring.maven.model.User;
import com.spring.maven.model.UserRole;
import com.spring.maven.model.Users;

/**
 *
 * @author B13
 */
public interface IUserDAO extends ICommonDAO<User>{
    public User save(User u, Users us, UserRole role);
    public User getUserByUserName(String userName);
}
