/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.orm.controller;

import com.blogspot.na5cent.orm.model.User;
import com.blogspot.na5cent.orm.service.UserLoadService;
import com.blogspot.na5cent.orm.service.UserService;
import com.blogspot.na5cent.orm.util.JSFSpringUtils;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 *
 * @author Rain
 */
public class UserLoadLazy extends LazyDataModel<User> {

    static final Logger LOG = LoggerFactory.getLogger(UserLoadLazy.class);

    private List<User> users;
    private long totalElements;

    private UserService userService = JSFSpringUtils.getBean(UserService.class);

    public UserLoadLazy() {
    }

    @Override
    public User getRowData(String id) {
        for (User user : users) {
            if (user.getId().toString().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void setRowIndex(final int rowIndex) {
        if (rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        } else {
            super.setRowIndex(rowIndex % getPageSize());
        }
    }

//    public List<User> load(int first, int pageSize, String sortField, SortOrder sortOrder) {
//        Sort.Direction direction;
//        if (sortOrder == SortOrder.ASCENDING) {
//            direction = Sort.Direction.ASC;
//        } else {
//            direction = Sort.Direction.DESC;
//        }
//
//        Page page = userService.findAll(new PageRequest(first / pageSize, pageSize, direction, sortField));
//        users = page.getContent();
//        totalElements = page.getTotalElements();
//        this.setRowCount((int) page.getTotalElements());
//        return users;
//    }

    public List<User> getContents() {
        return users;
    }

    public long getTotalElements() {
        return totalElements;
    }


    @Override
    public List<User> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
//        return super.load(first, pageSize, sortField, sortOrder, filters); //To change body of generated methods, choose Tools | Templates.
        Sort.Direction direction;
        if (sortOrder == SortOrder.ASCENDING) {
            direction = Sort.Direction.ASC;
        } else {
            direction = Sort.Direction.DESC;
        }
        Page page = userService.findAll(new PageRequest(first / pageSize, pageSize , Sort.Direction.ASC ,sortField));
        users = page.getContent();
        totalElements = page.getTotalElements();
        this.setRowCount((int) page.getTotalElements());
        return users;
    }

}
