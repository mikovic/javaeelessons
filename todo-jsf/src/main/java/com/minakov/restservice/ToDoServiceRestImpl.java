package com.minakov.restservice;

import com.minakov.persist.ToDo;
import com.minakov.persist.ToDoRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
@Stateless
public class ToDoServiceRestImpl implements ToDoServiceRest{

    @EJB
    private ToDoRepository toDoRepository;
    @Override
    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    @Override
    public void insert(ToDo todo) {
        toDoRepository.insert(todo);
    }

    @Override
    public void delete(ToDo todo) {
        toDoRepository.delete(todo.getId());
    }

    @Override
    public ToDo findById(Long id) {
        return toDoRepository.findById(id);
    }

    @Override
    public List<ToDo> findByCategoryId(int categoryId) {
        return toDoRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<ToDo> findByName(String name) {
        return null;
    }
}
