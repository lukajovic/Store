package objects;

import exceptions.ProductHasExpiredException;

public class Food extends Perishable {

    public Food(String name, String brand, double price, String expirationDate) throws ProductHasExpiredException {
        super(name, brand, price, expirationDate);
    }

    public Food() {
    }

    public Food(Perishable p) throws ProductHasExpiredException {
        super(p);
    }

}
