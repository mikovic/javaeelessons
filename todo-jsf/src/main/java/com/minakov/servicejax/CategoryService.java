package com.minakov.servicejax;

import com.minakov.persist.Category;
import com.minakov.persist.CategoryRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@WebService(endpointInterface = "com.minakov.servicejax.CategoryServiceWs", serviceName = "CategoryService")
public class CategoryService {
    @EJB
    private CategoryRepository categoryRepository;

    List<CategoryRepr> findAll(){
        List<ToDoRepr> toDoReprs;
        List<CategoryRepr> categoryReprsList = null;
        for(Category category:categoryRepository.findAll()){
            CategoryRepr categoryRepr = new CategoryRepr(category.getId(), category.getCategory());
            toDoReprs = category.getToDos().stream().map(t -> new ToDoRepr(t.getId(), t.getDescription(), t.getCategoryId(), Date.from(t.getTargetDate()
                    .atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant())))
                    .collect(Collectors.toList());
            categoryRepr.setToDoReprs(toDoReprs);
            categoryReprsList.add(categoryRepr);
        }
    return categoryReprsList;
    }
    void insert(CategoryRepr categoryRepr){
        Category category = new Category();
        category.setCategory(categoryRepr.getCategory());
        categoryRepository.insert(category);
    }
}
