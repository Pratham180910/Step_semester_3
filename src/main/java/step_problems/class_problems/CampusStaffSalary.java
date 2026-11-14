import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Staff {
    protected String name;
    protected double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getBonus() {
        return 0;
    }

    String getType() {
        return "Staff";
    }

    double getTotal() {
        return baseSalary + getBonus();
    }
}

class Teacher extends Staff {
    Teacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double getBonus() {
        return 5000;
    }

    @Override
    String getType() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {
    LabAssistant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double getBonus() {
        return 2000;
    }

    @Override
    String getType() {
        return "LabAssistant";
    }
}

public class CampusStaffSalary {

    static String fmt(double value) {
        String s = BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
        if (!s.contains(".")) {
            s += ".0";
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Staff[] staff = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double base = sc.nextDouble();
            if (type.equalsIgnoreCase("Teacher")) {
                staff[i] = new Teacher(name, base);
            } else if (type.equalsIgnoreCase("LabAssistant")) {
                staff[i] = new LabAssistant(name, base);
            } else {
                staff[i] = new Staff(name, base);
            }
        }

        double grandTotal = 0;
        for (Staff s : staff) {
            System.out.println(s.name + " (" + s.getType() + "): base " + fmt(s.baseSalary)
                    + ", bonus " + fmt(s.getBonus()) + ", total " + fmt(s.getTotal()));
            grandTotal += s.getTotal();
        }
        System.out.println("Grand Total Salary: " + fmt(grandTotal));
    }
}
