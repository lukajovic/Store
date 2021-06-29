package objects;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

public class Cashier {

    public static void printReceipt(Cart cart, LocalDateTime now_date_time) {

        LocalDate dateOfPurchase = LocalDate.now();

        String now1 = now_date_time.toString();
        String[] date_and_time = now1.split("T");
        String time = date_and_time[1];

        String newTime = time.substring(0, time.length() - 4);

        LocalDate dateOfPurchasePlusFiveDays = dateOfPurchase.plusDays(6);

        System.out.println("Date: " + date_and_time[0] + " " + newTime + "\n");
        System.out.println("---Products---" + "\n");

        double discoutOf50 = 50;
        double discoutOf10 = 10;
        double discountOf5 = 5;

        String discount_message1 = "#discount 50%";
        String discount_message2 = "#discount 10%";
        String discount_message3 = "#discount 5%";

        double clothes_sum = 0;
        double discount_cloth = 0;
        double appliance_sum = 0;
        double discount_appliance = 0;
        double food_sum = 0;
        double discount_food = 0;
        double beverages_sum = 0;
        double discount_beverage = 0;

        for (Map.Entry<Product, Double> entry : cart.getProducts().entrySet()) {

            Product product = entry.getKey();
            Double amount = entry.getValue();

            if (product instanceof Clothes) {
                Clothes cloth = (Clothes) product;
                double cloth_price = cloth.getPrice();

                clothes_sum = cloth_price * amount;

                if (!(dateOfPurchase.getDayOfWeek() == DayOfWeek.SATURDAY || dateOfPurchase.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                    discount_cloth = (discoutOf10 * (cloth_price * amount) / 100);

                    System.out.println(cloth.getName() + " " + cloth.getBrand() + " M " + cloth.getColor() + "\n" + amount + " x " + cloth_price + " = " + Math.round(clothes_sum * 100.0) / 100.0 + "\n" + discount_message2 + " -$" + Math.round(discount_cloth * 100.0) / 100.0 + "\n");
                } else {

                    System.out.println(cloth.getName() + " " + cloth.getBrand() + " M " + cloth.getColor() + "\n" + cloth.getPrice());
                }

            } else if (product instanceof Appliance) {
                Appliance appliance = (Appliance) product;
                double appliance_price = appliance.getPrice();

                appliance_sum = appliance_price * amount;

                if ((dateOfPurchase.getDayOfWeek() == DayOfWeek.SATURDAY || dateOfPurchase.getDayOfWeek() == DayOfWeek.SUNDAY) && appliance_price > 999) {
                    discount_appliance = (discountOf5 * (appliance_price * amount) / 100);

                    System.out.println(appliance.getName() + " " + appliance.getBrand() + " " + appliance.getModel() + "\n" + amount + " x $" + appliance_price + " = $" + Math.round(appliance_sum * 100.0) / 100.0 + "\n" + discount_message3 + " -$" + Math.round(discount_appliance * 100.0) / 100.0);
                } else {
                    System.out.println(appliance.getName() + " " + appliance.getBrand() + " " + appliance.getModel() + "\n" + amount + " x $" + appliance_price + " = $" + Math.round(appliance_sum * 100.0) / 100.0 + "\n");
                }

            } else if (product instanceof Food) {

                Food food = (Food) product;

                double food_price = food.getPrice();

                food_sum = food_price * amount;

                String foodExpDate = food.getExpirationDate();

                LocalDate foodExpirationDate = LocalDate.parse(foodExpDate);

                if (foodExpirationDate.isEqual(dateOfPurchase)) {

                    discount_food = (discoutOf50 * (food_price * amount) / 100);

                    System.out.println(food.getName() + " " + food.getBrand() + "\n" + amount + " x $" + food_price + " = $" + Math.round(food_sum * 100.0) / 100.0 + "\n" + discount_message1 + " -$" + Math.round(discount_food * 100.0) / 100.0 + "\n");

                } else if (foodExpirationDate.isBefore(dateOfPurchasePlusFiveDays) && foodExpirationDate.isAfter(dateOfPurchase)) {
                    discount_food = (discoutOf10 * (food_price * amount) / 100);

                    System.out.println(food.getName() + " " + food.getBrand() + "\n" + amount + " x $" + food_price + " = $" + Math.round(food_sum * 100.0) / 100.0 + "\n" + discount_message2 + " -$" + Math.round(discount_food * 100.0) / 100.0 + "\n");
                } else if (foodExpirationDate.isAfter(dateOfPurchasePlusFiveDays)) {
                    System.out.println(food.getName() + " " + food.getBrand() + "\n" + "%" + food.getPrice() + "\n");
                }

            } else if (product instanceof Beverage) {

                Beverage beverage = (Beverage) product;
                double beverage_price = beverage.getPrice();

                beverages_sum = beverage_price * amount;

                String beverageExpDate = beverage.getExpirationDate();
                LocalDate beverageExpirationDate = LocalDate.parse(beverageExpDate);

                if (beverageExpirationDate.isEqual(dateOfPurchase)) {
                    discount_beverage = (discoutOf50 * (beverage_price * amount) / 100);

                    System.out.println(beverage.getName() + " " + beverage.getBrand() + "\n" + amount + " x $" + beverage_price + " = $" + Math.round(beverages_sum * 100.0) / 100.0 + "\n" + discount_message1 + " -$" + Math.round(discount_beverage * 100.0) / 100.0 + "\n");

                } else if (beverageExpirationDate.isBefore(dateOfPurchasePlusFiveDays) && beverageExpirationDate.isAfter(dateOfPurchase)) {
                    discount_beverage = (discoutOf10 * beverage.getPrice() / 100);

                    System.out.println(beverage.getName() + " " + beverage.getBrand() + "\n" + amount + " x $" + beverage_price + " = $" + Math.round(beverages_sum * 100.0) / 100.0 + "\n" + discount_message2 + " -$" + Math.round(discount_beverage * 100.0) / 100.0 + "\n");
                } else if (beverageExpirationDate.isAfter(dateOfPurchasePlusFiveDays)) {
                    System.out.println(beverage.getName() + " " + beverage.getBrand() + "\n" + amount + " x $" + beverage_price + " = $" + Math.round(beverages_sum * 100.0) / 100.0 + "\n");
                }
            }

        }

        double sub_total = clothes_sum + appliance_sum + food_sum + beverages_sum;
        double discount = discount_beverage + discount_cloth + discount_food + discount_appliance;
        double total = sub_total - discount;

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("SUBTOTAL: $" + Math.round(sub_total * 100.0) / 100.0);
        System.out.println("DISCOUNT: $" + Math.round(discount * 100.0) / 100.0 + "\n");
        System.out.println("TOTAL: $" + Math.round(total * 100.0) / 100.0);

    }

}
