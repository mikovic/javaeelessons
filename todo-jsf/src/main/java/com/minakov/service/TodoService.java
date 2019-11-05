package com.minakov.service;

import com.minakov.persist.ToDo;

import javax.ejb.TransactionAttribute;
import java.util.List;

public interface TodoService {

    public void insert(ToDo toDo);

    public void update(ToDo toDo);

    public void delete(long id);

    public ToDo findById(long id);

    public List<ToDo> findAll();
    public List<ToDo> findByCategoryId(int categoryId);


}
