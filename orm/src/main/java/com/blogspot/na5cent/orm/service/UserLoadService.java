/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.na5cent.orm.service;

import com.blogspot.na5cent.orm.model.User;
import java.util.List;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Rain
 */
public interface UserLoadService {
    
    public User getRowData(String id);
    
    public Object getRowKey(User user);
    
    public void setRowIndex(final int rowIndex);
    
    public List<User> load(int first,int pageSize,String sortField,SortOrder sortOrder);
}
