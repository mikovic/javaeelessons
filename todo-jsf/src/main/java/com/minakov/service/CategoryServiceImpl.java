package com.minakov.service;

import com.minakov.persist.Category;
import com.minakov.persist.CategoryRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;
@Stateless(description = "categoryService")
public class CategoryServiceImpl implements CategoryService, Serializable {

    @EJB
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }
}
