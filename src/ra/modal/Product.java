package ra.modal;

import ra.config.InputMethod;

import java.util.ArrayList;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private Brand brand;
    private Color color;
    private Category category;

    public Product() {
    }

    public Product(int id, String name, double price, int quantity, Brand brand, Color color, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.color = color;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void inputData(ArrayList<Brand> listBrand, ArrayList<Color> listColor, ArrayList<Category> listCategory) {
        System.out.print("Nhập tên sản phẩm: ");
        this.name = InputMethod.getString();
        System.out.print("Nhập giá sản phẩm: ");
        this.price = InputMethod.getDouble();
        System.out.print("Nhập vào số lượng: ");
        this.quantity = InputMethod.getInteger();
        // choose brand
        for (Brand brand : listBrand) {
            System.out.println(brand);
        }
        while (true) {
            System.out.print("Nhập vào ID hãng bạn muốn chọn: ");
            int id = InputMethod.getInteger();
            boolean flag = false;
            for (Brand s : listBrand) {
                if (s.getId() == id) {
                    this.brand = s;
                    flag = true;
                }
            }
            if (flag) {
                break;
            } else {
                System.err.print("\nKhông có hãng đó, Vui lòng nhập lại: ");
            }
        }
        // choose color
        for (Color color : listColor) {
            System.out.println(color);
        }
        while (true) {
            System.out.print("Nhập vào ID màu bạn muốn chọn: ");
            int id = InputMethod.getInteger();
            boolean flag = false;
            for (Color s : listColor) {
                if (s.getId() == id) {
                    this.color = s;
                    flag = true;
                }
            }
            if (flag) {
                break;
            } else {
                System.err.print("\nKhông có hãng đó, Vui lòng nhập lại: ");
            }
        }
        // choose phân loại
        for (Category category : listCategory) {
            System.out.println(category);
        }
        while (true) {
            System.out.print("Nhập vào ID phân loại bạn muốn chọn: ");
            int id = InputMethod.getInteger();
            boolean flag = false;
            for (Category s : listCategory) {
                if (s.getId() == id) {
                    this.category = s;
                    flag = true;
                }
            }
            if (flag) {
                break;
            } else {
                System.err.print("\nKhông có phân loại đó, Vui lòng nhập lại: ");
            }
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Price: " + price + " | Quantity: " + quantity +
                "\nBrand: " + brand.getBrandName() + " | Color: " + color.getColorName() + " | Category: " + category.getCategoryName();
    }
}
