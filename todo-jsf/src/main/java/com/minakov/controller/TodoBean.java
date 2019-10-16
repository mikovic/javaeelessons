package com.minakov.controller;

import com.minakov.persist.Basket;
import com.minakov.persist.Category;
import com.minakov.persist.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.minakov.persist.ToDo;


import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class TodoBean implements Serializable {


    private static final Logger logger = LoggerFactory.getLogger(TodoBean.class);

    @Inject
    private ToDoRepository toDoRepository;

    private ToDo toDo;
    private Basket basket;
    private Category category;

    public ToDo getToDo() {
        return toDo;
    }

    public Basket getBasket() {
        if(this.basket == null){
            this.basket = new Basket();
        }
        return basket;
    }

    public void setToDo(ToDo toDo) {
        this.toDo = toDo;
    }

    public List<ToDo> getAllTodo() throws SQLException {
        return toDoRepository.findAll();
    }

    public String createTodo() {
        this.toDo = new ToDo();
        return "/todo.xhtml?faces-redirect=true";
    }

    public String saveTodo() throws SQLException {
        if (toDo.getId() == null) {
            toDoRepository.insert(toDo);
        } else {
            toDoRepository.update(toDo);
        }
        return "/index.xhtml?faces-redirect=true";
    }

    public void deleteTodo(ToDo toDo) throws SQLException {
        logger.info("Deleting ToDo.");
        toDoRepository.delete(toDo.getId());
    }
    public void addToBasket(ToDo toDo) throws SQLException {
        logger.info("add ToDo to Basket.");
        getBasket().add(toDo);

    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public String editTodo(ToDo toDo) {
        this.toDo = toDo;
        return "/todo.xhtml?faces-redirect=true";
    }
    public String showBasket() {

        return "/basket.xhtml?faces-redirect=true";
    }
    public String showIndex() {
        return "/index.xhtml?faces-redirect=true";
    }
    public String findToDos(Category category) throws SQLException {
        logger.debug("categoryId= "+category.getId());
       this.category = toDoRepository.findToDos(category);
       logger.debug("CATEGORY=CATEGORY+CATEGORY!!!!!!!!!!!");

        for(ToDo t: category.getList()){
            logger.debug("id TODO TODO="+t.getId());
            logger.debug("Category TODO="+t.getCategory());
            logger.debug("DESCRIPTION= " + t.getDescription());
            logger.debug(("___________________"));
        }
        return "/category.xhtml?faces-redirect=true";
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}