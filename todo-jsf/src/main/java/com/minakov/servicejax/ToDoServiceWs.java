package com.minakov.servicejax;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ToDoServiceWs {
    @WebMethod
    List<ToDoRepr> findAll();
    @WebMethod
    void insert(ToDoRepr todo);
    @WebMethod
    public void delete(ToDoRepr todo);
    @WebMethod
    public ToDoRepr findById(Long id);
    @WebMethod
    public List<ToDoRepr> findByCategoryId(int categoryId);
    @WebMethod
    public List<ToDoRepr> findByName(String name);
}