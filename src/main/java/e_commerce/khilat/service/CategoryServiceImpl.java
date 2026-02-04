package e_commerce.khilat.service;

import e_commerce.khilat.entity.Category;
import e_commerce.khilat.repository.CategoryRepo;
import org.springframework.stereotype.Service;
import java.util.List;  


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepository;

    public CategoryServiceImpl(CategoryRepo categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

   
    @Override
    public List<Category> addMultipleCategories(List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
