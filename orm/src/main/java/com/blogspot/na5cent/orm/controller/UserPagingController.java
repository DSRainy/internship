/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.orm.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Rain
 */
@ManagedBean
@SessionScoped
public class UserPagingController  implements Serializable{

    private static final Logger LOG = LoggerFactory.getLogger(UserPagingController.class);

    private UserLoadLazy userLoadLazy;
    
    @PostConstruct
    public void postConstruct() {
        reset();
    }

    public UserLoadLazy getUserLoadLazy() {
        return userLoadLazy;
    }

    public void setUserLoadLazy(UserLoadLazy userLoadLazy) {
        this.userLoadLazy = userLoadLazy;
    }

    private void reset() {
        userLoadLazy = new UserLoadLazy();

    }

}
