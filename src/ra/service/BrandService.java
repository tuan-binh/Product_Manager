package ra.service;

import ra.controller.ProductController;
import ra.modal.Brand;
import ra.modal.Product;

import java.util.ArrayList;

public class BrandService implements IBaseService<Brand, Integer> {
    private ArrayList<Brand> listBrand = new ArrayList<>();

    public BrandService() {
        listBrand.add(new Brand(1, "GUCCI"));
        listBrand.add(new Brand(2, "RAZA"));
        listBrand.add(new Brand(3, "PLAZA"));
    }

    public ArrayList<Brand> getAll() {
        return listBrand;
    }

    @Override
    public void save(Brand o) {
        if (findById(o.getId()) == null) {
            listBrand.add(o);
            System.out.println(">>>========== Thêm thành công ==========<<<");
        } else {
            for (int i = 0; i < listBrand.size(); i++) {
                if (listBrand.get(i).getId() == o.getId()) {
                    listBrand.set(i, o);
                }
            }
            System.out.println(">>>========== Sửa thành công ==========<<<");
        }
    }

    @Override
    public void delete(Integer id, ArrayList<Product> list) {
        if (findById(id) != null) {
            boolean checked = true;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getBrand().getId() == id) {
                    checked = false;
                    break;
                }
            }

            if (checked) {
                for (int i = 0; i < listBrand.size(); i++) {
                    if (listBrand.get(i).getId() == id) {
                        listBrand.remove(i);
                        break;
                    }
                }
                System.out.println(">>>========== Xóa thành công ==========<<<");
            } else {
                System.out.println(">>>========== Xóa thất bại ==========<<<");
            }
        } else {
            System.err.println(">>>========== Không có phần tử để xóa ==========<<<");
        }
    }

    @Override
    public Brand findById(Integer id) {
        for (Brand brand : listBrand) {
            if (brand.getId() == id) {
                return brand;
            }
        }
        return null;
    }

    @Override
    public int getNewId() {
        int idMax = 0;
        for (Brand brand : listBrand) {
            if (idMax < brand.getId()) {
                idMax = brand.getId();
            }
        }
        return idMax + 1;
    }
}
