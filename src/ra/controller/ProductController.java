package ra.controller;

import ra.modal.Product;
import ra.service.ProductService;

import java.util.ArrayList;

public class ProductController implements IController<Product, Integer> {

    private ProductService productService = new ProductService();

    @Override
    public ArrayList<Product> getAll() {
        return productService.getAll();
    }

    @Override
    public void save(Product product) {
        productService.save(product);
    }

    @Override
    public void delete(Integer id) {
        productService.delete(id);
    }

    @Override
    public Product findById(Integer id) {
        return productService.findById(id);
    }

    @Override
    public int getNewId() {
        return productService.getNewId();
    }
}
