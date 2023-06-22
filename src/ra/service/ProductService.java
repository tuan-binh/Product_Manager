package ra.service;

import ra.modal.Brand;
import ra.modal.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductService<T> implements IBaseService<Product, Integer> {

    private ArrayList<Product> listProduct = new ArrayList<>();

    public ProductService() {
//        listProduct.add(new Product(1,""))
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
    public void delete(Integer id) {
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
