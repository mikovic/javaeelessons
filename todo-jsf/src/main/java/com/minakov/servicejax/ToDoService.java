package com.minakov.servicejax;

import com.minakov.persist.ToDo;
import com.minakov.persist.ToDoRepository;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@WebService(endpointInterface = "com.minakov.servicejax.ToDoServiceWs", serviceName = "ToDoService")
public class ToDoService {

    @EJB
    private ToDoRepository toDoRepository;

    public List<ToDoRepr> findAll() {
        return toDoRepository.findAll()
                .stream()
                .map(t -> new ToDoRepr(t.getId(), t.getDescription(), t.getCategoryId(), Date.from(t.getTargetDate()
                        .atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant())))
                .collect(Collectors.toList());
    }

    public void insert(ToDoRepr todo) {
        ToDo toDo = new ToDo();
        toDo.setDescription(todo.getDescription());
        toDo.setCategoryId(todo.getCategoryId());
        toDo.setTargetDate(todo.getTargetDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
        toDoRepository.insert(toDo);
    }

    public void delete(ToDoRepr todo){
        toDoRepository.delete(todo.getId());
    }

    public ToDoRepr findById(Long id){
    ToDo toDo = toDoRepository.findById(id);
        ToDoRepr toDoRepr = new ToDoRepr();
        toDoRepr.setDescription(toDo.getDescription());
        toDoRepr.setCategoryId(toDo.getCategoryId());
        toDoRepr.setTargetDate(Date.from(toDo.getTargetDate()
                .atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant()));
        return toDoRepr;
    }
    public List<ToDoRepr> findByCategoryId(int categoryId) {
        return toDoRepository.findByCategoryId(categoryId)
                .stream()
                .map(t -> new ToDoRepr(t.getId(), t.getDescription(), t.getCategoryId(), Date.from(t.getTargetDate()
                        .atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant())))
                .collect(Collectors.toList());
    }
    public List<ToDoRepr> findByName(String name) {
        return toDoRepository.findByName(name)
                .stream()
                .map(t -> new ToDoRepr(t.getId(), t.getDescription(), t.getCategoryId(), Date.from(t.getTargetDate()
                        .atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant())))
                .collect(Collectors.toList());
    }

}