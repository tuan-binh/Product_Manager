package ra.controller;

import ra.modal.Category;
import ra.service.CategoryService;

import java.util.ArrayList;

public class CategoryController implements IController<Category, Integer> {
    private CategoryService categoryService = new CategoryService();


    @Override
    public ArrayList<Category> getAll() {
        return categoryService.getAll();
    }

    @Override
    public void save(Category category) {
        categoryService.save(category);
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);
    }

    @Override
    public Category findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public int getNewId() {
        return categoryService.getNewId();
    }
}
