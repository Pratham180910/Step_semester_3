package main.java.OOP_Introduction.class_problems;

import java.util.*;

public class ArmstrongNumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        int origNumber = number;
        int sum = 0;

        while (number != 0) {
            int digit = number % 10;
            sum += digit * digit * digit;
            number /= 10;
        }

        boolean isArmstrong = sum == origNumber;
        System.out.println("Is the number " + origNumber + " an Armstrong number? " + isArmstrong);
        sc.close();
    }
}