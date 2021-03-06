package com.minakov.controller;

import com.minakov.UserService;
import com.minakov.interceptor.LoggerInterceptor;
import com.minakov.persist.Basket;
import com.minakov.persist.Category;
import com.minakov.persist.ToDoRepository;
import com.minakov.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.minakov.persist.ToDo;


import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class TodoBean implements Serializable {


    private static final Logger logger = LoggerFactory.getLogger(TodoBean.class);

    @Inject
    private TodoService todoService;
    @EJB(lookup = "java:global/users/UserServiceImpl!com.minakov.UserService")
    private UserService userService;
    @EJB
    private Basket basket;
    private ToDo toDo;

    private Category category;
    private List<ToDo> toDoList;

    public void preloadTodoList(ComponentSystemEvent componentSystemEvent) {
        logger.debug(("___________________!!!!!!!!!!!!!!____________________________"));
        this.toDoList = todoService.findAll();
        userService.findAll().forEach(u -> logger.info(u.getUsername()));
    }
    public ToDo getToDo() {
        return toDo;
    }

    public Basket getBasket() {

        return basket;
    }

    public void setToDo(ToDo toDo) {
        this.toDo = toDo;
    }

    public List<ToDo> getAllTodo()  {
        return toDoList;
    }
    public  List<ToDo> findAllToDo() {
        return todoService.findAll();
    }

    @Interceptors({LoggerInterceptor.class})
    public String createTodo() {
        this.toDo = new ToDo();
        return "/todo.xhtml?faces-redirect=true";
    }
    @Interceptors({LoggerInterceptor.class})
    public String saveTodo() throws SQLException {
        if (toDo.getId() == null) {
            todoService.insert(toDo);
        } else {
            todoService.update(toDo);
        }
        return "/index.xhtml?faces-redirect=true";
    }
    @Interceptors({LoggerInterceptor.class})
    public void deleteTodo(ToDo toDo) throws SQLException {
        logger.info("Deleting ToDo.");
        todoService.delete(toDo.getId());
    }
    @Interceptors({LoggerInterceptor.class})
    public void addToBasket(ToDo toDo) throws SQLException {
        logger.info("add ToDo to Basket.");
        getBasket().add(toDo);

    }
    @Interceptors({LoggerInterceptor.class})
    public String findToDos(Category category) throws SQLException {
        logger.debug("categoryId= "+category.getId());
        this.toDoList = todoService.findByCategoryId(category.getId());


        return "/category.xhtml?faces-redirect=true";
    }




    @Interceptors({LoggerInterceptor.class})
    public String editTodo(ToDo toDo) {
        this.toDo = toDo;
        return "/todo.xhtml?faces-redirect=true";
    }
    @Interceptors({LoggerInterceptor.class})
    public String showBasket() {

        return "/basket.xhtml?faces-redirect=true";
    }
    public String showIndex() {
        return "/index.xhtml?faces-redirect=true";
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }
}
