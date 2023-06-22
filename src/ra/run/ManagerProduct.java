package ra.run;

import ra.config.InputMethod;
import ra.controller.BrandController;
import ra.controller.CategoryController;
import ra.controller.ColorController;
import ra.controller.ProductController;
import ra.modal.Brand;
import ra.modal.Category;
import ra.modal.Color;
import ra.modal.Product;

import java.util.HashMap;
import java.util.Map;

public class ManagerProduct {

    static BrandController brandController = new BrandController();
    static CategoryController categoryController = new CategoryController();
    static ColorController colorController = new ColorController();
    static ProductController productController = new ProductController();

    public static void main(String[] args) {
        int choose = 0;
        while (choose != 5) {
            System.out.println(">>>============== MENU ==============<<<");
            System.out.println("1. Quản Lý Sản Phẩm");
            System.out.println("2. Quản Lý Màu");
            System.out.println("3. Quản Lý Hãng");
            System.out.println("4. Quản Lý Phân Loại");
            System.out.println("5. Thoát");
            System.out.println(">>>==================================<<<");
            System.out.print("Mời bạn lựa chọn: ");
            choose = InputMethod.getInteger();
            switch (choose) {
                case 1:
                    menuProduct();
                    break;
                case 2:
                    menuColor();
                    break;
                case 3:
                    menuBrand();
                    break;
                case 4:
                    menuCategory();
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Vui lòng chọn lại (1 -> 5)");
                    break;
            }
        }
    }

    // ==================== MENU PRODUCT ===================
    public static void menuProduct() {
        int choose = 0;
        while (choose != 5) {
            System.out.println(">>>============== MENU PRODUCT ==============<<<");
            System.out.println("1. Thêm Sản Phẩm");
            System.out.println("2. Sửa Sản Phẩm");
            System.out.println("3. Xóa Sản Phẩm");
            System.out.println("4. Tìm Kiếm");
            System.out.println("5. Quay lại");
            System.out.println(">>>==========================================<<<");
            System.out.print("Mời bạn lựa chọn: ");
            choose = InputMethod.getInteger();
            switch (choose) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Vui lòng chọn lại (1 -> 5)");
                    break;
            }
        }
    }

    public static void addNewProduct() {
        System.out.print("Bạn muốn thêm bao nhiêu sản phầm: ");
        int n = InputMethod.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("Sản phẩm thứ " + (i + 1));
            Product newProduct = new Product();
            newProduct.setId(productController.getNewId());
            newProduct.inputData(brandController.getAll(), colorController.getAll(), categoryController.getAll());
            productController.save(newProduct);
        }
    }

    public static void editProduct() {
        System.out.print("Bạn muốn sửa sản phẩm có id là: ");
        int id = InputMethod.getInteger();
        Product product = productController.findById(id);
        if (product == null) {
            System.err.println("Không có sản phẩm đó");
            return;
        }
        product.inputData(brandController.getAll(), colorController.getAll(), categoryController.getAll());
        productController.save(product);
    }

    public static void deleteProduct() {
        System.out.print("Bạn muốn xóa sản phẩm có id là: ");
        int id = InputMethod.getInteger();
        productController.delete(id, productController.getAll());
    }

    public static void searchProduct() {
        System.out.println("=============== SEARCH ===============");
        System.out.println("1.Search theo color");
        System.out.println("2.Search theo brand");
        System.out.println("3.Search theo category");
        System.out.println("4.Thoát");
        System.out.println("======================================");
        System.out.print("Mời bạn lựa chọn: ");
        int choose = InputMethod.getInteger();
        switch (choose) {
            case 1:
                searchByColor();
                break;
            case 2:
                searchByBrand();
                break;
            case 3:
                searchByCategory();
                break;
            case 4:
                return;
            default:
                break;
        }
    }

    public static void searchByColor() {
        String text = InputMethod.getString();
        for (Product p : productController.getAll()) {
            if (p.getColor().getColorName().toLowerCase().equals(text.toLowerCase())) {
                System.out.println(p);
            }
        }
    }

    public static void searchByBrand() {
        String text = InputMethod.getString();
        for (Product p : productController.getAll()) {
            if (p.getBrand().getBrandName().toLowerCase().equals(text.toLowerCase())) {
                System.out.println(p);
            }
        }
    }

    public static void searchByCategory() {
        String text = InputMethod.getString();
        for (Product p : productController.getAll()) {
            if (p.getCategory().getCategoryName().toLowerCase().equals(text.toLowerCase())) {
                System.out.println(p);
            }
        }
    }

    // ==================== MENU COLOR ===================
    public static void menuColor() {
        int choose = 0;
        while (choose != 4) {
            showListColor();
            System.out.println(">>>============== MENU COLOR ==============<<<");
            System.out.println("1. Thêm Màu");
            System.out.println("2. Sửa Màu");
            System.out.println("3. Xóa Màu");
            System.out.println("4. Quay lại");
            System.out.println(">>>=======================================<<<");
            System.out.print("Mời bạn lựa chọn: ");
            choose = InputMethod.getInteger();
            switch (choose) {
                case 1:
                    addColor();
                    break;
                case 2:
                    editColor();
                    break;
                case 3:
                    deleteColor();
                    break;
                case 4:
                    break;
                default:
                    System.err.println("Vui lòng chọn lại (1 -> 4)");
                    break;
            }
        }
    }

    public static void showListColor() {
        Map<String, Integer> listColor = new HashMap<>();
        for (Color c : colorController.getAll()) {
            listColor.put(c.getColorName(), 0);
        }
        for (Map.Entry<String, Integer> entry : listColor.entrySet()) {
            for (Product p : productController.getAll()) {
                if (entry.getKey().equals(p.getColor().getColorName())) {
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : listColor.entrySet()) {
            System.out.printf("\nMàu: %5s | Số Lượng Sản Phẩm: %d", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public static void addColor() {
        System.out.print("Bạn muốn thêm bao nhiêu màu: ");
        int n = InputMethod.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("Màu thứ " + (i + 1));
            Color newColor = new Color();
            newColor.setId(colorController.getNewId());
            newColor.inputData();
            colorController.save(newColor);
        }
    }

    public static void editColor() {
        System.out.print("Bạn muốn sửa màu có id là: ");
        int id = InputMethod.getInteger();
        Color color = colorController.findById(id);
        if (color == null) {
            System.err.println("Không có màu đó");
            return;
        }
        color.inputData();
        colorController.save(color);
    }

    public static void deleteColor() {
        System.out.print("Bạn muốn xóa màu có id là: ");
        int id = InputMethod.getInteger();
        colorController.delete(id, productController.getAll());
    }

    // ==================== MENU BRAND ===================
    public static void menuBrand() {
        int choose = 0;
        while (choose != 4) {
            showListBrand();
            System.out.println(">>>============== MENU BRAND ==============<<<");
            System.out.println("1. Thêm Brand");
            System.out.println("2. Sửa Brand");
            System.out.println("3. Xóa Brand");
            System.out.println("4. Quay lại");
            System.out.println(">>>=======================================<<<");
            System.out.print("Mời bạn lựa chọn: ");
            choose = InputMethod.getInteger();
            switch (choose) {
                case 1:
                    addBrand();
                    break;
                case 2:
                    editBrand();
                    break;
                case 3:
                    deleteBrand();
                    break;
                case 4:
                    break;
                default:
                    System.err.println("Vui lòng chọn lại (1 -> 4)");
                    break;
            }
        }
    }

    public static void showListBrand() {
        Map<String, Integer> listBrand = new HashMap<>();
        for (Brand c : brandController.getAll()) {
            listBrand.put(c.getBrandName(), 0);
        }
        for (Product p : productController.getAll()) {
            String key = p.getBrand().getBrandName();
            int value = listBrand.get(key) + 1;
            listBrand.put(key, value);
        }
        for (Map.Entry<String, Integer> entry : listBrand.entrySet()) {
            System.out.printf("\nBrand: %10s | Số Lượng Sản Phẩm: %d", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public static void addBrand() {
        System.out.print("Bạn muốn thêm bao nhiêu brand: ");
        int n = InputMethod.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("brand thứ " + (i + 1));
            Brand newBrand = new Brand();
            newBrand.setId(brandController.getNewId());
            newBrand.inputData();
            brandController.save(newBrand);
        }
    }

    public static void editBrand() {
        System.out.print("Bạn muốn sửa brand có id là: ");
        int id = InputMethod.getInteger();
        Brand brand = brandController.findById(id);
        if (brand == null) {
            System.err.println("Không có brand đó");
            return;
        }
        brand.inputData();
        brandController.save(brand);
    }

    public static void deleteBrand() {
        System.out.print("Bạn muốn xóa brand có id là: ");
        int id = InputMethod.getInteger();
        brandController.delete(id, productController.getAll());
    }

    // ==================== MENU CATEGORY ===================
    public static void menuCategory() {
        int choose = 0;
        while (choose != 4) {
            showListCategory();
            System.out.println(">>>============== MENU CATEGORY ==============<<<");
            System.out.println("1. Thêm Category");
            System.out.println("2. Sửa Category");
            System.out.println("3. Xóa Category");
            System.out.println("4. Quay lại");
            System.out.println(">>>===========================================<<<");
            System.out.print("Mời bạn lựa chọn: ");
            choose = InputMethod.getInteger();
            switch (choose) {
                case 1:
                    addCategory();
                    break;
                case 2:
                    editCategory();
                    break;
                case 3:
                    deleteCategory();
                    break;
                case 4:
                    break;
                default:
                    System.err.println("Vui lòng chọn lại (1 -> 4)");
                    break;
            }
        }
    }


    public static void showListCategory() {
        Map<String, Integer> listCategory = new HashMap<>();
        for (Category c : categoryController.getAll()) {
            listCategory.put(c.getCategoryName(), 0);
        }
        for (Product p : productController.getAll()) {
            String key = p.getCategory().getCategoryName();
            int value = listCategory.get(key) + 1;
            listCategory.put(key, value);
        }
        for (Map.Entry<String, Integer> entry : listCategory.entrySet()) {
            System.out.printf("\nCategory: %10s | Số Lượng Sản Phẩm: %d", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    public static void addCategory() {
        System.out.print("Bạn muốn thêm bao nhiêu category: ");
        int n = InputMethod.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("category thứ " + (i + 1));
            Category newCategory = new Category();
            newCategory.setId(categoryController.getNewId());
            newCategory.inputData();
            categoryController.save(newCategory);
        }
    }

    public static void editCategory() {
        System.out.print("Bạn muốn sửa category có id là: ");
        int id = InputMethod.getInteger();
        Category category = categoryController.findById(id);
        if (category == null) {
            System.err.println("Không có category đó");
            return;
        }
        category.inputData();
        categoryController.save(category);
    }

    public static void deleteCategory() {
        System.out.print("Bạn muốn xóa category có id là: ");
        int id = InputMethod.getInteger();
        categoryController.delete(id, productController.getAll());
    }

}
