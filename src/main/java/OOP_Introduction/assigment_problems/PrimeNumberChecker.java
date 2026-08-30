package main.java.OOP_Introduction.assigment_problems;

import java.util.*;

public class PrimeNumberChecker {
    public static void checkPrime(int number) {
        boolean prime = true;

        if (number <= 1)
            prime = false;

        for (int i = 2; i <= number / 2 && prime; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }

        if (prime)
            System.out.println("Prime");
        else
            System.out.println("Not Prime");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        checkPrime(number);
        sc.close();
    }
}