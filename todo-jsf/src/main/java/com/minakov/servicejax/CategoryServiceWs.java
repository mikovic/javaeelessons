package com.minakov.servicejax;

import com.minakov.persist.Category;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface CategoryServiceWs {

    @WebMethod
    List<CategoryRepr> findAll();

    @WebMethod
    void insert(CategoryRepr categoryRepr);

}
