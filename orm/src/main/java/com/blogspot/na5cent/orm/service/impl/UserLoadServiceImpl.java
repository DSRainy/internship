/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.na5cent.orm.service.impl;

import com.blogspot.na5cent.orm.model.User;
import com.blogspot.na5cent.orm.service.UserLoadService;
import java.util.List;
import org.primefaces.model.SortOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rain
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserLoadServiceImpl implements UserLoadService{

    @Override
    public User getRowData(String id) {
        return null;
    }

    @Override
    public Object getRowKey(User user) {
        return null;
        
    }

    @Override
    public void setRowIndex(int rowIndex) {
    }

    @Override
    public List<User> load(int first, int pageSize, String sortField, SortOrder sortOrder) {
        return null;
        
    }
    
}
