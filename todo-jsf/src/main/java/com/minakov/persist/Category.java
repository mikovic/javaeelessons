package com.minakov.persist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "categories")
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
        @NamedQuery(name = "Category.findById", query = "select distinct c from Category c right join fetch c.todos t where c.id =:id")
})

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Поле не должно быть пустым")
    @Column
    private String category;
    @Transient
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "category")

    private List<ToDo> toDos;
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

    public List<ToDo> getToDos() {
        if(this.toDos == null){
            toDos = new ArrayList<>();
        }
        return toDos;
    }
    public void addToDo(ToDo toDo){
        getToDos().add(toDo);
    }



}
