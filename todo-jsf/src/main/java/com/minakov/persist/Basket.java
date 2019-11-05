package com.minakov.persist;


import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@SessionScoped
@Stateful
public class Basket implements Serializable {
    private List<ToDo> list = new ArrayList<>();

    public List <ToDo> getList() {
        return list;
    }

    public void setList(List<ToDo> list) {
        this.list = list;
    }
    public void add(ToDo todo) {
        this.list.add(todo);
    }
    public void deleteFromBasket(ToDo todo){

        this.list.remove(todo);
    }

}
