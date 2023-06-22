package ra.service;

import ra.controller.BrandController;
import ra.controller.CategoryController;
import ra.controller.ColorController;
import ra.modal.Brand;
import ra.modal.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductService implements IBaseService<Product, Integer> {

    private ArrayList<Product> listProduct = new ArrayList<>();

//    private ColorController colorController = new ColorController();
//    private BrandController brandController = new BrandController();
//    private CategoryController categoryController = new CategoryController();

    public ProductService() {
//        listProduct.add(new Product(1, "Áo thun", 1200, 20, , colorController.findById(1), categoryController.findById(2)));
//        listProduct.add(new Product(2, "Quần Jean", 2000, 25, brandController.findById(1), colorController.findById(1), categoryController.findById(2)));
//        listProduct.add(new Product(3, "Áo thun", 1200, 30, brandController.findById(3), colorController.findById(1), categoryController.findById(2)));
    }

    public ArrayList<Product> getAll() {
        return listProduct;
    }

    @Override
    public void save(Product product) {
        if (findById(product.getId()) == null) {
            listProduct.add(product);
            System.out.println(">>>========== Thêm thành công ==========<<<");
        } else {
            for (int i = 0; i < listProduct.size(); i++) {
                if (listProduct.get(i).getId() == product.getId()) {
                    listProduct.set(i, product);
                }
            }
            System.out.println(">>>========== Sửa thành công ==========<<<");
        }
    }


    @Override
    public void delete(Integer id, ArrayList<Product> list) {
        if (findById(id) != null) {
            for (int i = 0; i < listProduct.size(); i++) {
                if (listProduct.get(i).getId() == id) {
                    listProduct.remove(i);
                    break;
                }
            }
            System.out.println(">>>========== Xóa thành công ==========<<<");
        } else {
            System.err.println(">>>========== Không có phần tử để xóa ==========<<<");
        }
    }

    @Override
    public Product findById(Integer id) {
        for (Product product : listProduct) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public int getNewId() {
        int idMax = 0;
        for (Product product : listProduct) {
            if (idMax < product.getId()) {
                idMax = product.getId();
            }
        }
        return idMax + 1;
    }
}
