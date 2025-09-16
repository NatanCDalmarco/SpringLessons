package SpringLessons.project03.Services;

import SpringLessons.project03.Models.Category;
import SpringLessons.project03.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category crate(Category category) {
        return categoryRepository.save(category);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("You dont have this category"));
    }

    public Category update(Long id, Category updatedCategory) {
        Category foundCategory = findById(id);

        foundCategory.setName(updatedCategory.getName());
        return categoryRepository.save(foundCategory);
    }

    public void deleteById(Long id) {
        Category foundCategory = findById(id);
        categoryRepository.delete(foundCategory);
    }
}
