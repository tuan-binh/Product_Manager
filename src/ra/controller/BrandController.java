package ra.controller;

import ra.modal.Brand;
import ra.modal.Product;
import ra.service.BrandService;

import java.util.ArrayList;

public class BrandController implements IController<Brand, Integer> {
    private BrandService brandService = new BrandService();

    @Override
    public ArrayList<Brand> getAll() {
        return brandService.getAll();
    }

    @Override
    public void save(Brand brand) {
        brandService.save(brand);
    }

    @Override
    public void delete(Integer id, ArrayList<Product> list) {
        brandService.delete(id, list);
    }

    @Override
    public Brand findById(Integer id) {
        return brandService.findById(id);
    }

    @Override
    public int getNewId() {
        return brandService.getNewId();
    }
}
