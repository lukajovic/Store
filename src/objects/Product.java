package objects;

public abstract class Product {

    private String name, brand;
    private double price;

    public Product(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public Product() {
    }

    public Product(Product p) {

        this.name = p.name;
        this.brand = p.brand;
        this.price = p.price;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Brand: " + brand + "\n" + "Price: " + "$" + price + "\n";
    }

}
