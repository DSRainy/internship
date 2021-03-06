/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.orm.service.impl;

import com.blogspot.na5cent.orm.model.User;
import com.blogspot.na5cent.orm.repository.UserRepository;
import com.blogspot.na5cent.orm.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anonymous
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findByNameLike(String name) {

        return userRepository.findByNameLike('%' + name + '%');

    }

    @Override
    public User findOne(int pk) {

        return userRepository.findOne(pk);
    }

    @Override
    public boolean exists(int id) {
        return userRepository.exists(id);
    }

    @Override
    public Page findAll(PageRequest pageRequest) {
        return userRepository.findAll(pageRequest);
    }
    


}
