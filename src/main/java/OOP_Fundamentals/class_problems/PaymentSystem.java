import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAdjustedAmount();
    public abstract String getType();
}

class CardPayment extends Payment {
    public CardPayment(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() { return amount * 1.02; }
    @Override
    public String getType() { return "CARD"; }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() { return amount * 1.01; }
    @Override
    public String getType() { return "WALLET"; }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() { return amount; }
    @Override
    public String getType() { return "BANKTRANSFER"; }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Payment> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            switch (type) {
                case "CARD": payments.add(new CardPayment(amount)); break;
                case "WALLET": payments.add(new WalletPayment(amount)); break;
                case "BANKTRANSFER": payments.add(new BankTransferPayment(amount)); break;
            }
        }

        double grandTotal = 0;
        for (Payment p : payments) {
            double adjusted = p.calculateAdjustedAmount();
            grandTotal += adjusted;
            System.out.printf("%s: %.2f\n", p.getType(), adjusted);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    scanner.close();}
}