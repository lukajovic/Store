 package objects;

import enums.Size;

public class Clothes extends Product {

    private Size size;
    private String color;

    public Clothes(String name, String brand, double price, Size size, String color) {
        super(name, brand, price);
        this.size = size;
        this.color = color;
    }

    public Clothes() {
    }

    public Clothes(Clothes c) {
        super(c.getName(), c.getBrand(), c.getPrice());
        this.size = c.size;
        this.color = c.color;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public String getColor() {
        return color;

    }

    @Override
    public String toString() {
        return super.toString() + "Size: " + size + "\n" + "Color: " + color + "\n";
    }

}
