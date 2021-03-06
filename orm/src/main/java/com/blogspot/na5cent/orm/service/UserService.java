/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.na5cent.orm.service;

import com.blogspot.na5cent.orm.model.User;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author anonymous
 */
public interface UserService {
    
    public User save(User user);
    
    public List<User> findAll();
    
    public void delete(User user);

    public List<User> findByNameLike(String name);
    
    public User findOne(int id);
    
    public boolean exists(int id);

    public Page findAll(PageRequest pageRequest);
   
}
