package main.java.Abstraction.assigment_problems;

import java.util.Scanner;

abstract class Cab {
    static final double MINIMUM_FARE = 100.0;

    abstract double getRate();

    double calculateFare(double km) {
        return Math.max(MINIMUM_FARE, km * getRate());
    }

    double calculateNightFare(double km) {
        return calculateFare(km) * 1.20;
    }
}

interface NightService {
    double NIGHT_SURCHARGE = 0.20;
}

class MiniCab extends Cab {
    double getRate() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightService {
    double getRate() {
        return 14.0;
    }
}

class SUVCab extends Cab implements NightService {
    double getRate() {
        return 18.0;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab();
                    break;

                case "SEDAN":
                    cab = new SedanCab();
                    break;

                case "SUV":
                    cab = new SUVCab();
                    break;

                default:
                    continue;
            }

            double fare;

            if (time.equals("NIGHT")) {
                if (!(cab instanceof NightService)) {
                    System.out.println(
                        type + ": night service not available"
                    );
                    continue;
                }

                fare = cab.calculateNightFare(km);
            } else {
                fare = cab.calculateFare(km);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}