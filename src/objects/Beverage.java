package objects;

import exceptions.ProductHasExpiredException;

public class Beverage extends Perishable {

    public Beverage(String name, String brand, double price, String expirationDate) throws ProductHasExpiredException {
        super(name, brand, price, expirationDate);
    }

    public Beverage() {
    }

    public Beverage(Perishable p) throws ProductHasExpiredException {
        super(p);
    }

}
