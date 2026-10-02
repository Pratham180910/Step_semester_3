package main.java.OOP_Fundamentals.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Vehicle {
    protected int hours;
    public Vehicle(int hours) { this.hours = hours; }
    public abstract double calculateCharge();
    public abstract String getType();
}

class Bike extends Vehicle {
    public Bike(int hours) { super(hours); }
    @Override
    public double calculateCharge() { return hours * 10.0; }
    @Override
    public String getType() { return "BIKE"; }
}

class Car extends Vehicle {
    public Car(int hours) { super(hours); }
    @Override
    public double calculateCharge() {
        if (hours == 1) return 30.0;
        return 30.0 + ((hours - 1) * 20.0);
    }
    @Override
    public String getType() { return "CAR"; }
}

class Truck extends Vehicle {
    public Truck(int hours) { super(hours); }
    @Override
    public double calculateCharge() { return Math.max(100.0, hours * 50.0); }
    @Override
    public String getType() { return "TRUCK"; }
}

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);

            switch (type) {
                case "BIKE": vehicles.add(new Bike(hours)); break;
                case "CAR": vehicles.add(new Car(hours)); break;
                case "TRUCK": vehicles.add(new Truck(hours)); break;
            }
        }

        double grandTotal = 0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f\n", v.getType(), charge);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        
        scanner.close();
    }
}