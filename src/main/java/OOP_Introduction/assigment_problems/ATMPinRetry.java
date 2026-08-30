package main.java.OOP_Introduction.assigment_problems;

import java.util.*;

public class ATMPinRetry {
    public static void atmPinRetry(String correctPin, String[] attempts) {
        int count = 0;
        boolean success = false;

        while (count < attempts.length && count < 3 && !success) {
            if (attempts[count].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }
            count++;
        }

        if (!success)
            System.out.println("Card blocked — too many incorrect attempts");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter correct PIN: ");
        String correctPin = sc.nextLine();

        String[] attempts = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter attempt " + (i + 1) + ": ");
            attempts[i] = sc.nextLine();
        }

        atmPinRetry(correctPin, attempts);
        sc.close();
    }
}