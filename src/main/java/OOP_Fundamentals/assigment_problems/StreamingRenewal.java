package main.java.OOP_Fundamentals.assigment_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Subscription {
    protected String name;
    protected LocalDate startDate;

    public Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract LocalDate calculateRenewalDate();
    public String getName() { return name; }
}

class BasicPlan extends Subscription {
    public BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public LocalDate calculateRenewalDate() { return startDate.plusDays(30); }
}

class StandardPlan extends Subscription {
    public StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public LocalDate calculateRenewalDate() { return startDate.plusDays(90); }
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
    @Override
    public LocalDate calculateRenewalDate() { return startDate.plusDays(365); }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Subscription> subscribers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String planType = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2]);

            switch (planType) {
                case "BASIC": subscribers.add(new BasicPlan(name, startDate)); break;
                case "STANDARD": subscribers.add(new StandardPlan(name, startDate)); break;
                case "PREMIUM": subscribers.add(new PremiumPlan(name, startDate)); break;
            }
        }

        for (Subscription s : subscribers) {
            System.out.println(s.getName() + ": " + s.calculateRenewalDate());
        }
        
        scanner.close();
    }
}