package objects;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product, Double> products = new HashMap<>();

    public void addToCart(Product p, double number) {

       products.put(p,number);

    }

    public Map<Product, Double> getProducts() {
        return products;
    }

}
