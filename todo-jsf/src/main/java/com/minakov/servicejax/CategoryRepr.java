package com.minakov.servicejax;

import java.util.List;

public class CategoryRepr {

    private int id;


    private String category;


    private List<ToDoRepr> toDoReprs;
    public CategoryRepr() {
    }
    public CategoryRepr(int id, String category) {
        this.id =id;
        this.category = category;
    }
    public CategoryRepr(String category) {
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

    public List<ToDoRepr> getToDoReprs() {
        return toDoReprs;
    }

    public void setToDoReprs(List<ToDoRepr> toDoReprs) {
        this.toDoReprs = toDoReprs;
    }
}
