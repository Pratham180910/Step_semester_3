package main.java.OOP_Fundamentals.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Customer {
    protected double amount;
    public Customer(double amount) { this.amount = amount; }
    public abstract double calculateFinalAmount();
    public abstract String getType();
}

class Student extends Customer {
    public Student(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount * 0.90; }
    @Override
    public String getType() { return "STUDENT"; }
}

class Staff extends Customer {
    public Staff(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount * 0.95; }
    @Override
    public String getType() { return "STAFF"; }
}

class Guest extends Customer {
    public Guest(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount + 10; }
    @Override
    public String getType() { return "GUEST"; }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            switch (type) {
                case "STUDENT": customers.add(new Student(amount)); break;
                case "STAFF": customers.add(new Staff(amount)); break;
                case "GUEST": customers.add(new Guest(amount)); break;
            }
        }

        double grandTotal = 0;
        for (Customer c : customers) {
            double finalAmount = c.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf("%s: %.2f\n", c.getType(), finalAmount);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        
        scanner.close();
    }
}