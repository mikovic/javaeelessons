package com.minakov.servicejax;

import com.minakov.persist.Category;
import com.minakov.persist.CategoryRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(endpointInterface = "com.minakov.servicejax.CategoryServiceWs", serviceName = "CategoryService")
public class CategoryService {
    @EJB
    private CategoryRepository categoryRepository;

    List<Category> findAll(){
        return categoryRepository.findAll();
    }
    void insert(Category category){
        categoryRepository.insert(category);
    }
}
