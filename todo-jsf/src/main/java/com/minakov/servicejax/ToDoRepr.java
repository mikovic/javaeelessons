package com.minakov.servicejax;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;

public class ToDoRepr {

    private Long id;

    private String description;

    private Date targetDate;
    private int categoryId;

    public ToDoRepr() {
    }

    public ToDoRepr(Long id, String description, int categoryId, Date targetDate) {
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

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setTargetDate(XMLGregorianCalendar newXMLGregorianCalendar) {
    }
}
