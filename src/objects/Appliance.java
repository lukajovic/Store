package objects;

public class Appliance extends Product {

    private String model;
    private String productionDate;
    private double weight;

    public Appliance(String name, String brand, double price, String model, String productionDate, double weight) {
        super(name, brand, price);
        this.model = model;
        this.productionDate = productionDate;
        this.weight = weight;
    }

    public Appliance() {
    }

    public Appliance(Appliance a) {
        super(a.getName(), a.getBrand(), a.getPrice());
        this.model = a.model;
        this.productionDate = a.productionDate;
        this.weight = a.weight;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return super.toString() + "Model: " + model + "\n" + "Production date: " + productionDate + "\n" + "Weight: " + weight +" kg";
    }

}
