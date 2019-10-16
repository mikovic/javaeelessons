package com.minakov.persist;


import javax.validation.constraints.NotNull;
import javax.inject.Inject;
import java.time.LocalDate;

public class ToDo {

    private Long id;
    @NotNull(message = "Поле не должно быть пустым")
    private String description;
    private  int categoryId;
    private String category;
    private LocalDate targetDate;

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
}
