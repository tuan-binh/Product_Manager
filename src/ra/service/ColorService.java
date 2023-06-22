package ra.service;

import ra.controller.ProductController;
import ra.modal.Brand;
import ra.modal.Color;
import ra.modal.Product;

import java.util.ArrayList;

public class ColorService implements IBaseService<Color, Integer> {
    private ArrayList<Color> listColor = new ArrayList<>();

    public ColorService() {
        listColor.add(new Color(1, "Red"));
        listColor.add(new Color(2, "Green"));
        listColor.add(new Color(3, "Blue"));
    }

    public ArrayList<Color> getAll() {
        return listColor;
    }

    @Override
    public void save(Color color) {
        if (findById(color.getId()) == null) {
            listColor.add(color);
            System.out.println(">>>========== Thêm thành công ==========<<<");
        } else {
            for (int i = 0; i < listColor.size(); i++) {
                if (listColor.get(i).getId() == color.getId()) {
                    listColor.set(i, color);
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
                if (list.get(i).getColor().getId() == id) {
                    checked = false;
                    break;
                }
            }

            if (checked) {
                for (int i = 0; i < listColor.size(); i++) {
                    if (listColor.get(i).getId() == id) {
                        listColor.remove(i);
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
    public Color findById(Integer id) {
        for (Color color : listColor) {
            if (color.getId() == id) {
                return color;
            }
        }
        return null;
    }

    @Override
    public int getNewId() {
        int idMax = 0;
        for (Color color : listColor) {
            if (idMax < color.getId()) {
                idMax = color.getId();
            }
        }
        return idMax + 1;
    }
}
