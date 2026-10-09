package main.java.Abstraction.assigment_problems;

import java.util.Scanner;

abstract class Appliance {
    abstract double getPower();

    double calculateUnits(double hours) {
        return getPower() * hours / 1000.0;
    }

    double calculateCost(double units) {
        return units * 8.0;
    }
}

interface SaverMode {
    double SAVING = 0.25;
}

class Fridge extends Appliance {
    double getPower() {
        return 150.0;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    double getPower() {
        return 1500.0;
    }

    double calculateSaverUnits(double hours) {
        return calculateUnits(hours) * (1 - SAVING);
    }
}

class Television extends Appliance {
    double getPower() {
        return 100.0;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    double getPower() {
        return 500.0;
    }

    double calculateSaverUnits(double hours) {
        return calculateUnits(hours) * (1 - SAVING);
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = sc.hasNext("SAVER");

            if (saver) {
                sc.next();
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge();
                    break;

                case "AC":
                    appliance = new AirConditioner();
                    break;

                case "TV":
                    appliance = new Television();
                    break;

                case "WASHER":
                    appliance = new WashingMachine();
                    break;

                default:
                    continue;
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units;

            if (saver) {
                units = appliance.calculateUnits(hours) * 0.75;
            } else {
                units = appliance.calculateUnits(hours);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}