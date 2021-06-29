package main;

import enums.Size;
import exceptions.ProductHasExpiredException;
import objects.Appliance;
import objects.Beverage;
import objects.Cashier;
import objects.Clothes;
import objects.Food;
import java.time.LocalDateTime;
import objects.Cart;

public class Main {

    public static void main(String[] args) throws ProductHasExpiredException {

        LocalDateTime now = LocalDateTime.now();

        Clothes t_shirt = new Clothes("T-shirt", "BrandT", 15.99, Size.M, "violet");
        Appliance laptop = new Appliance("laptop", "BrandL", 2345, "ModelL", "2021-03-03", 1.125);
        Food apple = new Food("apple", "BrandA", 1.50, "2021-06-29"); //<--- Enter the date you're reviewing this code at
        Beverage milk = new Beverage("milk", "BrandM", 0.99, "2022-02-02");

        Cart cart = new Cart();

        cart.addToCart(apple, 2.45);
        cart.addToCart(t_shirt, 2);
        cart.addToCart(laptop, 1);
        cart.addToCart(milk, 3);

        Cashier.printReceipt(cart, now);

    }

}
