package main.java.java_string.class_problems;

import java.util.*;

public class ReverseCustomerName {
    public static String reverseCustomerName(String customerName) {
        StringBuilder reversed = new StringBuilder(customerName);
        return reversed.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
        sc.close();
    }
}