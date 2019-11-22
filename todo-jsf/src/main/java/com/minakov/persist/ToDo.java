package com.minakov.persist;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.inject.Inject;
import java.io.Serializable;
import java.time.LocalDate;



@Entity
@Table(name = "todos")
  @NamedQuery(name = "Todos.findByCategoryId", query = "select distinct t from ToDo t where t.categoryId =:categoryId")

public class ToDo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Поле не должно быть пустым")
    @Column
    private String description;
    @NotNull(message = "Поле не должно быть пустым")

    @Column
    private  int categoryId;

    @Column
    private LocalDate targetDate;

    private String category;
    public ToDo() {
    }

    public ToDo(Long id, String description, int categoryId, LocalDate targetDate) {
        this.id = id;
        this.description = description;
        this.categoryId = categoryId;
        this.targetDate = targetDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @ManyToOne(optional = false)
    private Category categories;

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }
}
