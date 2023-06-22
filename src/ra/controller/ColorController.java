package ra.controller;

import ra.modal.Color;
import ra.modal.Product;
import ra.service.ColorService;

import java.util.ArrayList;

public class ColorController implements IController<Color, Integer> {

    private ColorService colorService = new ColorService();

    @Override
    public ArrayList<Color> getAll() {
        return colorService.getAll();
    }

    @Override
    public void save(Color color) {
        colorService.save(color);
    }

    @Override
    public void delete(Integer id, ArrayList<Product> list) {
        colorService.delete(id, list);
    }

    @Override
    public Color findById(Integer id) {
        return colorService.findById(id);
    }

    @Override
    public int getNewId() {
        return colorService.getNewId();
    }
}
