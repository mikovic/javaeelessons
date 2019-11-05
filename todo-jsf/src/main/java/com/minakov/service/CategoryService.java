package com.minakov.service;

import com.minakov.persist.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> findAll();

    public Category findById(int id);
}
