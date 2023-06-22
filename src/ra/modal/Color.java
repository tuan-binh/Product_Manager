package ra.modal;

import ra.config.InputMethod;

public class Color {
    private int id;
    private String colorName;

    public Color() {
    }

    public Color(int id, String colorName) {
        this.id = id;
        this.colorName = colorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public void inputData() {
        System.out.println("Nhập tên màu: ");
        this.colorName = InputMethod.getString();
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Color: " + colorName;
    }
}
