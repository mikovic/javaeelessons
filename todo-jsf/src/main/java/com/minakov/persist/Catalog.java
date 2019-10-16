package com.minakov.persist;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private List<Category> list =new ArrayList<>();

    public Catalog(){

    }
    public void addCategory(Category category){

        getList().add(category);
}
    public List<Category> getList() {
        return list;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }
}
