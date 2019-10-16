package com.minakov.controller;
import com.minakov.persist.Catalog;
import com.minakov.persist.Category;
import com.minakov.persist.CategoryRepository;
import com.minakov.persist.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named
public class CategoryBean implements Serializable{
    private static final Logger logger = LoggerFactory.getLogger(TodoBean.class);

    @Inject
    private CategoryRepository categoryRepository;

    private Category category;
    private Catalog catalog;





    public CategoryBean(){

    }
    public Catalog getCatalog() throws SQLException {

        this.catalog = categoryRepository.getCatalog();

        return catalog;

    }



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }


}
