package main.java.Abstraction.class_problems;
import java.util.Scanner;

abstract class Connection {
    protected double units;

    public Connection(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class Home extends Connection {
    public Home(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class Shop extends Connection {
    public Shop(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class Factory extends Connection {
    public Factory(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }
}

public class ElectricityBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String connType = sc.next();
            double units = sc.nextDouble();
            Connection conn = null;

            switch (connType) {
                case "HOME":
                    conn = new Home(units);
                    break;
                case "SHOP":
                    conn = new Shop(units);
                    break;
                case "FACTORY":
                    conn = new Factory(units);
                    break;
            }

            if (conn != null) {
                double bill = conn.calculateBill();
                System.out.printf("%s: %.2f\n", connType, bill);
                total += bill;
            }
        }

        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}