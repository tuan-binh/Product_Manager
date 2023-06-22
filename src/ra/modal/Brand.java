package ra.modal;

import ra.config.InputMethod;

public class Brand {
    private int id;
    private String brandName;

    public Brand() {
    }

    public Brand(int id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void inputData() {
        System.out.print("Nhập vào id: ");
        this.brandName = InputMethod.getString();
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Brand: " + brandName;
    }
}
