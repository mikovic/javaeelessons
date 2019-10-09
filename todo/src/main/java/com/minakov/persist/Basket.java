package com.minakov.persist;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Basket {
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
    public void delete(long id){
        ToDo toDo = null;
        for (ToDo td: this.list){
            if(td.getId()==id){
                toDo = td;
                break;
            }
        }
        this.list.remove(toDo);
    }
}
