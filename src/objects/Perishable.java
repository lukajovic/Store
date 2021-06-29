package objects;

import exceptions.ProductHasExpiredException;
import java.time.LocalDate;

public abstract class Perishable extends Product {

    private String expirationDate;
    LocalDate date = LocalDate.now();

    public Perishable(String name, String brand, double price, String expirationDate) throws ProductHasExpiredException {
        super(name, brand, price);
        setExpirationDate(expirationDate);
    }

    public Perishable() {
    }

    public Perishable(Perishable p) throws ProductHasExpiredException {
        super(p.getName(), p.getBrand(), p.getPrice());
        this.expirationDate = p.expirationDate;
    }

    public void setExpirationDate(String expirationDate) throws ProductHasExpiredException {

        LocalDate localDate = LocalDate.parse(expirationDate);

        if (!localDate.isBefore(date)) {

            this.expirationDate = expirationDate;
        } else {
            throw new ProductHasExpiredException("Invalid date entered! The item has long since expired");
        }

    }

    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return super.toString() + "Expiration Date: " + expirationDate;
    }

}
