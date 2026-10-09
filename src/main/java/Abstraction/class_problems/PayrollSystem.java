package main.java.Abstraction.class_problems
;import java.util.Scanner;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double pay();
}

class FullTime extends Staff {
    private double salary;

    public FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double pay() {
        return salary;
    }
}

class Hourly extends Staff {
    private double hours;
    private double rate;

    public Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double pay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * 1.5 * rate);
        }
    }
}

class Intern extends Staff {
    private double stipend;

    public Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double pay() {
        return stipend;
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        double totalPayroll = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff staff = null;

            switch (type) {
                case "FULLTIME":
                    double salary = sc.nextDouble();
                    staff = new FullTime(name, salary);
                    break;
                case "HOURLY":
                    double hours = sc.nextDouble();
                    double rate = sc.nextDouble();
                    staff = new Hourly(name, hours, rate);
                    break;
                case "INTERN":
                    double stipend = sc.nextDouble();
                    staff = new Intern(name, stipend);
                    break;
            }

            if (staff != null) {
                double payAmount = staff.pay();
                System.out.printf("%s: %.2f\n", staff.getName(), payAmount);
                totalPayroll += payAmount;
            }
        }

        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
        sc.close();
    }
}