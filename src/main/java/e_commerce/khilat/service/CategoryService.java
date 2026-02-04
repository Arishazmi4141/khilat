package e_commerce.khilat.service;

import e_commerce.khilat.entity.Category;


import java.util.List;

public interface CategoryService {

    Category addCategory(Category category);

    List<Category> addMultipleCategories(List<Category> categories);

    List<Category> getAllCategories();
}
