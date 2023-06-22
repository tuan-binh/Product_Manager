package ra.service;


import ra.modal.Brand;
import ra.modal.Category;

import java.util.ArrayList;

public class CategoryService implements IBaseService<Category, Integer> {

    private ArrayList<Category> listCategory = new ArrayList<>();

    public CategoryService() {
        listCategory.add(new Category(1, "Quần"));
        listCategory.add(new Category(2, "Áo"));
        listCategory.add(new Category(3, "Giầy"));
    }

    public ArrayList<Category> getAll() {
        return listCategory;
    }

    @Override
    public void save(Category category) {
        if (findById(category.getId()) == null) {
            listCategory.add(category);
            System.out.println(">>>========== Thêm thành công ==========<<<");
        } else {
            for (int i = 0; i < listCategory.size(); i++) {
                if (listCategory.get(i).getId() == category.getId()) {
                    listCategory.set(i, category);
                }
            }
            System.out.println(">>>========== Sửa thành công ==========<<<");
        }
    }

    @Override
    public void delete(Integer id) {
        if (findById(id) != null) {
            for (int i = 0; i < listCategory.size(); i++) {
                if (listCategory.get(i).getId() == id) {
                    listCategory.remove(i);
                    break;
                }
            }
            System.out.println(">>>========== Xóa thành công ==========<<<");
        } else {
            System.err.println(">>>========== Không có phần tử để xóa ==========<<<");
        }
    }

    @Override
    public Category findById(Integer id) {
        for (Category category : listCategory) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    @Override
    public int getNewId() {
        int idMax = 0;
        for (Category category : listCategory) {
            if (idMax < category.getId()) {
                idMax = category.getId();
            }
        }
        return idMax + 1;
    }
}
