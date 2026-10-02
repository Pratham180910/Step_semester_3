import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Transport {
    protected double distance;
    public Transport(double distance) { this.distance = distance; }
    public abstract double calculateFare();
    public abstract String getType();
}

class Bus extends Transport {
    public Bus(double distance) { super(distance); }
    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0);
    }
    @Override
    public String getType() { return "BUS"; }
}

class Train extends Transport {
    public Train(double distance) { super(distance); }
    @Override
    public double calculateFare() { return 3.0 + (0.15 * distance); }
    @Override
    public String getType() { return "TRAIN"; }
}

class Metro extends Transport {
    private double peakHourFactor;
    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }
    @Override
    public double calculateFare() { return (1.50 + (0.20 * distance)) * peakHourFactor; }
    @Override
    public String getType() { return "METRO"; }
}

public class TransportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Transport> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);

            switch (type) {
                case "BUS":
                    journeys.add(new Bus(distance)); break;
                case "TRAIN":
                    journeys.add(new Train(distance)); break;
                case "METRO":
                    double factor = Double.parseDouble(parts[2]);
                    journeys.add(new Metro(distance, factor)); break;
            }
        }

        double totalFare = 0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            totalFare += fare;
            System.out.printf("%s: %.2f\n", t.getType(), fare);
        }
        System.out.printf("Total: %.2f\n", totalFare);
    scanner.close();}
}