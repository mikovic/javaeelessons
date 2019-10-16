package com.minakov.persist;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private int id;
    private String category;
    private List<ToDo> list = new ArrayList<>();
    public Category() {
    }
    public Category(int id, String category) {
        this.id =id;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<ToDo> getList() {
        return list;
    }
    public void addToDo(ToDo toDo){
        this.list.add(toDo);
    }

    public void setList(List<ToDo> list) {
        this.list = list;
    }
}
