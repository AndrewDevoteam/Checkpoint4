package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public abstract class Vehicle implements GetVehicleType {

    private String model;
    private String color;
    private String year;
    private AutoMaker autoMaker;
    private VehicleTypeEnum vehicleTypeEnum;
    public final LocalDateTime createdAt= createdAt();

    private final LocalDateTime createdAt() {
        Random random = new Random();
        int upperbound = 10000;
        int int_random = random.nextInt(upperbound);
        LocalDateTime now = LocalDateTime.now();

        //generates a random ldt based on todays date
        LocalDateTime randomldt = now.plusDays(int_random).plusMinutes(int_random);

        return randomldt;
    }


    public Vehicle(String model, String color, String year, AutoMaker autoMaker) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.autoMaker = autoMaker;

    }

    public Vehicle(String model, String color, String year, AutoMaker autoMaker, VehicleTypeEnum vehicleTypeEnum) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.autoMaker = autoMaker;
        this.vehicleTypeEnum = vehicleTypeEnum;
    }



    public void prettyPrint() {
        String pattern = "MMM d, yyyy, HH:mm:ss a";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
        System.out.println("#------------------------------------------------------#");
        System.out.println("Registration Date: " + createdAt.format(format));
        System.out.println("AutoMaker: " + autoMaker.getName());
        System.out.println("Model: " + model);
        System.out.println("Vehicle Type: " + getVehicleType());
        System.out.println("Color: " + color);
        System.out.println("Year: " + year);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public AutoMaker getAutoMaker() {
        return autoMaker;
    }

    public void setAutoMaker(AutoMaker autoMaker) {
        this.autoMaker = autoMaker;
    }

    public VehicleTypeEnum getVehicleTypeEnum() {
        return vehicleTypeEnum;
    }

    public void setVehicleTypeEnum(VehicleTypeEnum vehicleTypeEnum) {
        this.vehicleTypeEnum = vehicleTypeEnum;
    }


};

