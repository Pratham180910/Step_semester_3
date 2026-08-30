package main.java.OOP_Introduction.class_problems;

import java.util.*;

public class PalindromeNumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        int origNumber = number;
        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        boolean isPalindrome = reversedNumber == origNumber;
        System.out.println("Is the number " + origNumber + " a Palindrome? " + isPalindrome);
        sc.close();
    }
}