package main.java.Abstraction.class_problems;
import java.util.Scanner;

abstract class Travel {
    protected static final double BOOKING_FEE = 50.0;
    protected double distance;

    public Travel(double distance) {
        this.distance = distance;
    }

    public abstract double fare();

    public double total() {
        return fare() + BOOKING_FEE;
    }
}

class Bus extends Travel {
    public Bus(double distance) {
        super(distance);
    }

    @Override
    public double fare() {
        return distance * 2.0;
    }
}

class Train extends Travel {
    public Train(double distance) {
        super(distance);
    }

    @Override
    public double fare() {
        return distance * 1.5;
    }
}

class Flight extends Travel {
    public Flight(double distance) {
        super(distance);
    }

    @Override
    public double fare() {
        return 2500.0 + (distance * 4.0);
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Travel ticket = null;

            switch (mode) {
                case "BUS":
                    ticket = new Bus(distance);
                    break;
                case "TRAIN":
                    ticket = new Train(distance);
                    break;
                case "FLIGHT":
                    ticket = new Flight(distance);
                    break;
            }

            if (ticket != null) {
                System.out.printf("%s: %.2f\n", mode, ticket.total());
            }
        }

        sc.close();
    }
}