package com.company;

//Product
class Car {
    private final String chassisNo;
    private final String engineNo;
    private final String engineType;
    private final String paint;
    private final String manufacturer;
    private final Integer price;

    public Car(){
        this.paint = "None";
        this.engineType = "None";
        this.engineNo = "None";
        this.manufacturer = "None";
        this.chassisNo = "None";
        this.price = 0;
    }

    public Car(String chassisNo, String engineNo, String engineType, String paint, String manufacturer, Integer price) {
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
        this.engineType = engineType;
        this.paint = paint;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public boolean validate() {
        return !chassisNo.isEmpty() && !engineNo.isEmpty() && !engineType.isEmpty() && !paint.isEmpty() && !manufacturer.isEmpty() && price > 0;
    }

    @Override
    public String toString() {
        return this.manufacturer + ":\nYour car chassisNo: " + this.chassisNo + ",\nYour EngineNo: " + this.engineNo +
                ",\nYour car is of type " + this.engineType + ",\nPaint Colour: " + this.paint + " color.\n" +
                "Priced at: " + this.price;
    }
}

// All necessary steps to be taken to build a car(Builder)
interface CarBuilder {
    public CarBuilder fixChassisNo();
    public CarBuilder fixEngineNo();
    public CarBuilder fixEngineType();
    public CarBuilder fixPaint();
    public CarBuilder setManufacturer();
    public CarBuilder setPrice();
    public Car build();
}

// ConcreteBuilders are below
class KiaCarBuilder implements CarBuilder {
    private String chassisNo;
    private String engineNo;
    private String engineType;
    private String paint;
    private String manufacturer;
    private Integer price;

    public KiaCarBuilder(String chassisNo, String engineNo, String engineType, String paint, Integer price) {
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
        this.engineType = engineType;
        this.paint = paint;
        this.manufacturer = "KIA";
        this.price = price;
    }

    @Override
    public CarBuilder fixChassisNo(){
        System.out.println("Fixing Chassis for KIA");
        return this;
    }

    @Override
    public CarBuilder fixEngineNo(){
        System.out.println("Fixing Engine for KIA");
        return this;
    }

    @Override
    public  CarBuilder fixEngineType(){
        System.out.println("Type of your car is: " + this.engineType);
        return this;
    }

    @Override
    public CarBuilder fixPaint(){
        System.out.println("Painting your car with the color: " + this.paint);
        return this;
    }

    @Override
    public  CarBuilder setManufacturer(){
        System.out.println("Fixing the manufacturer logo");
        return this;
    }

    @Override
    public CarBuilder setPrice() {
        System.out.println("The price of your car is set to: " + this.price);
        return this;
    }

    //String chassisNo, String engineNo, String engineType, String paint, String manufacturer, Integer price
    @Override
    public Car build(){
        Car car = new Car(chassisNo, engineNo, engineType, paint, manufacturer, price);

        if(car.validate()){
            return car;
        } else {
            System.out.println("KIA car is not yet ready....");
        }
        return null;
    }
}

class TataCarBuilder implements CarBuilder {
    private String chassisNo;
    private String engineNo;
    private String engineType;
    private String paint;
    private String manufacturer;
    private Integer price;

    public TataCarBuilder(String chassisNo, String engineNo, String engineType, String paint, Integer price) {
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
        this.engineType = engineType;
        this.paint = paint;
        this.manufacturer = "TATA";
        this.price = price;
    }

    @Override
    public CarBuilder fixChassisNo(){
        System.out.println("Fixing Chassis for TATA");
        return this;
    }

    @Override
    public CarBuilder fixEngineNo(){
        System.out.println("Fixing Engine for TATA");
        return this;
    }

    @Override
    public  CarBuilder fixEngineType(){
        System.out.println("Type of your car is: " + this.engineType);
        return this;
    }

    @Override
    public CarBuilder fixPaint(){
        System.out.println("Painting your car with the color: " + this.paint);
        return this;
    }

    @Override
    public  CarBuilder setManufacturer(){
        System.out.println("Fixing the manufacturer logo");
        return this;
    }

    @Override
    public CarBuilder setPrice() {
        System.out.println("The price of your car is set to: " + this.price);
        return this;
    }

    //String chassisNo, String engineNo, String engineType, String paint, String manufacturer, Integer price
    @Override
    public Car build(){
        Car car = new Car(chassisNo, engineNo, engineType, paint, manufacturer, price);

        if(car.validate()){
            return car;
        } else {
            System.out.println("TATA car is not yet ready....");
        }
        return null;
    }
}

class HyundaiCarBuilder implements CarBuilder {
    private String chassisNo;
    private String engineNo;
    private String engineType;
    private String paint;
    private String manufacturer;
    private Integer price;

    public HyundaiCarBuilder(String chassisNo, String engineNo, String engineType, String paint, Integer price) {
        this.chassisNo = chassisNo;
        this.engineNo = engineNo;
        this.engineType = engineType;
        this.paint = paint;
        this.manufacturer = "Hyundai";
        this.price = price;
    }

    @Override
    public CarBuilder fixChassisNo(){
        System.out.println("Fixing Chassis for Hyundai");
        return this;
    }

    @Override
    public CarBuilder fixEngineNo(){
        System.out.println("Fixing Engine for Hyundai");
        return this;
    }

    @Override
    public  CarBuilder fixEngineType(){
        System.out.println("Type of your car is: " + this.engineType);
        return this;
    }

    @Override
    public CarBuilder fixPaint(){
        System.out.println("Painting your car with the color: " + this.paint);
        return this;
    }

    @Override
    public  CarBuilder setManufacturer(){
        System.out.println("Fixing the manufacturer logo");
        return this;
    }

    @Override
    public CarBuilder setPrice() {
        System.out.println("The price of your car is set to: " + this.price);
        return this;
    }

    //String chassisNo, String engineNo, String engineType, String paint, String manufacturer, Integer price
    @Override
    public Car build(){
        Car car = new Car(chassisNo, engineNo, engineType, paint, manufacturer, price);

        if(car.validate()){
            return car;
        } else {
            System.out.println("Hyundai car is not yet ready....");
        }
        return null;
    }
}

//Director
class AutomotiveEngineer {
    private CarBuilder builder;

    public AutomotiveEngineer(CarBuilder builder){
        this.builder = builder;
        if(this.builder == null) {
            throw new IllegalArgumentException("Automotive Engineer can't work without Car...");
        }
    }

    public Car ManufactureCar(){
        return builder.fixChassisNo().fixEngineNo().fixEngineType().fixPaint().setManufacturer().setPrice().build();
    }
}

public class BuilderDesignPattern {
    public static void main(String[] args) {
        CarBuilder kiaBuilder = new KiaCarBuilder("KIAC54321","KIAE989", "Non Ev", "Midnight Black", 500000);
        CarBuilder tataBuilder = new TataCarBuilder("TATAC54321","TATAE989", "Ev", "Deep Blue", 550000);
        CarBuilder hyundaiBuilder = new HyundaiCarBuilder("HYUC54321","HYUE989", "Hybrid", "Crimson Red", 600000);

        System.out.println("-----------------------------------------------------------------------------------------");
        AutomotiveEngineer engineer = new AutomotiveEngineer(kiaBuilder);
        Car car = engineer.ManufactureCar();
        if(car != null){
            System.out.println("\nBelow Car Delivered....");
            System.out.println("***************************");
            System.out.println(car);
            System.out.println("***************************");
        }
        System.out.println("-----------------------------------------------------------------------------------------\n");

        System.out.println("-----------------------------------------------------------------------------------------");
        engineer = new AutomotiveEngineer(tataBuilder);
        car = engineer.ManufactureCar();
        if(car != null){
            System.out.println("\nBelow Car Delivered....");
            System.out.println("***************************");
            System.out.println(car);
            System.out.println("***************************");
        }
        System.out.println("-----------------------------------------------------------------------------------------\n");

        System.out.println("-----------------------------------------------------------------------------------------");
        engineer = new AutomotiveEngineer(hyundaiBuilder);
        car = engineer.ManufactureCar();
        if(car != null){
            System.out.println("\nBelow Car Delivered....");
            System.out.println("***************************");
            System.out.println(car);
            System.out.println("***************************");
        }
        System.out.println("-----------------------------------------------------------------------------------------\n");
    }
}
