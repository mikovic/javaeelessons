package com.minakov.controller;
import com.minakov.persist.Category;
import com.minakov.persist.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.UserTransaction;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class CategoryBean implements Serializable{
    private static final Logger logger = LoggerFactory.getLogger(TodoBean.class);

    @Inject
    private CategoryRepository categoryRepository;


    private Category category;
    private List<Category> categories;

    public CategoryBean(){

    }
    public List<Category> getCategories(){

        this.categories = categoryRepository.findAll();

        return categories;

    }



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }




}
