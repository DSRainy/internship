/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blogspot.na5cent.orm.controller;

import com.blogspot.na5cent.orm.model.User;
import com.blogspot.na5cent.orm.repository.UserRepository;
import com.blogspot.na5cent.orm.service.UserService;
import com.blogspot.na5cent.orm.util.JSFSpringUtils;
import java.io.Serializable;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import static org.apache.taglibs.standard.functions.Functions.toLowerCase;
import static org.apache.taglibs.standard.functions.Functions.toUpperCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author anonymous
 */
@ManagedBean
@SessionScoped
public class UserController implements Serializable {

    private static final Logger LOG = Logger.getLogger(UserController.class.getName());
    private final UserService userService = JSFSpringUtils.getBean(UserService.class);

    private List<User> users;
    private List<User> searchUsers = null;
    private User user;
    private String keyword = "";
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @PostConstruct
    public void postContruct() {

    }

    public void reset() {
        users = userService.findAll();
    }

    public void onCreateUser() {
        user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        if (users == null) {
            users = new ArrayList<>();
        }

        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getSearchUsers() {
        return searchUsers;
    }

    public void setSearchUsers(List<User> searchUsers) {
        this.searchUsers = searchUsers;
    }

    public void onSave() {
        try {
            user = userService.save(user);
            showMessage(FacesMessage.SEVERITY_INFO, "save user", "success");
        } catch (Exception ex) {
            LOG.log(Level.INFO, ex.getMessage(), ex);
            showMessage(FacesMessage.SEVERITY_ERROR, "save user", "fail");
        }
    }

    public void onSelectUser() {
        String userId = requestParam("userId");

        Integer id = Integer.valueOf(userId);
        int indexOf = this.getUsers().indexOf(new User(id));
        user = this.getUsers().get(indexOf);
    }

    public void onDelete() {

//        this.getUsers().remove(user);
        userService.delete(user);

        showMessage(FacesMessage.SEVERITY_INFO, "delete user", "success");
    }

    private String requestParam(String paramName) {
        return FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get(paramName);

    }

    private void showMessage(FacesMessage.Severity severity, String title, String body) {
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(severity, title, body));
    }

    public List<User> onSearchUserByName() {
//        String name = requestParam("searchUsername");
        if (!(this.keyword.equals(""))) {
            
            searchUsers = userService.findByNameLike(this.keyword);
            
            if (searchUsers == null) {
                this.keyword = toLowerCase(this.keyword);
                searchUsers = userService.findByNameLike(this.keyword);
            }

            if (searchUsers == null) {
                this.keyword = toUpperCase(this.keyword);
                searchUsers = userService.findByNameLike(this.keyword);
            }
        }
        return searchUsers;

    }

    public void onCheckHaveUser() {
        int key;
        key = parseInt(this.keyword);

        if (userService.exists(key)) {
            this.word = "Yes , I have.";
        } else {
            this.word = "No , I haven't.";
        }
    }

}
