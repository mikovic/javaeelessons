package com.minakov.service;

import com.minakov.persist.ToDo;
import com.minakov.persist.ToDoRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Stateless(description = "todoService")
public class TodoServiceImpl implements TodoService, Serializable {

    @EJB
    ToDoRepository toDoRepository;
    @Override
    public void insert(ToDo toDo) {
        toDoRepository.insert(toDo);
    }

    @Override
    public void update(ToDo toDo) {
toDoRepository.insert(toDo);
    }

    @Override
    public void delete(long id) {
toDoRepository.delete(id);
    }

    @Override
    public ToDo findById(long id) {
        return null;
    }

    @Override
    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    @Override
    public List<ToDo> findByCategoryId(int categoryId) {
        return toDoRepository.findByCategoryId(categoryId);
    }


}
