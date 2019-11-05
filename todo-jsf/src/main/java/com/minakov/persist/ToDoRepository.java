package com.minakov.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Stateless
//@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class ToDoRepository implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ToDoRepository.class);


    @PersistenceContext(unitName = "ds")
    private EntityManager em;



    @PostConstruct
    public void init()  {

           if (this.findAll().isEmpty()) {

                this.insert(new ToDo(-1L, "First",1, LocalDate.now()));
                this.insert(new ToDo(-1L, "Second", 2, LocalDate.now().plusDays(1)));
                this.insert(new ToDo(-1L, "Third",3, LocalDate.now().plusDays(2)));
            }


    }

    @TransactionAttribute
    public void insert(ToDo toDo) {
        em.persist(toDo);
    }

    @TransactionAttribute
    public void update(ToDo toDo) {
        em.merge(toDo);
    }

    @TransactionAttribute
    public void delete(long id) {
        ToDo toDo = em.find(ToDo.class, id);
        if (toDo != null) {
            em.remove(toDo);
        }
    }

    public ToDo findById(long id) {
        return em.find(ToDo.class, id);
    }



    public List<ToDo> findAll() {
        return em.createQuery("select distinct t from ToDo t").getResultList();
    }


    public void addToBasket(Long id) {

    }
    public  List<ToDo> findByCategoryId(int categoryId) {
        return em.createNamedQuery("Todos.findByCategoryId", ToDo.class).setParameter("categoryId", categoryId).getResultList();
    }

}





