package ra.modal;

import ra.config.InputMethod;

public class Category {
    private int id;
    private String categoryName;

    public Category() {
    }

    public Category(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void inputData() {
        System.out.print("Nhập tên loại sản phẩm: ");
        this.categoryName = InputMethod.getString();
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Category: " + categoryName;
    }
}
