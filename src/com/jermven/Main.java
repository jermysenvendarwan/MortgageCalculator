package com.jermven;

import java.security.Principal;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Principal: ");
        int principal = scanner.nextInt();

        System.out.println("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.println("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        // Mortgage means the amount of money to be paid monthly to pay off the home
        double mortgage = principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));

        double totalAmountPaid = numberOfPayments * mortgage;

        double totalInterestPaid = totalAmountPaid - principal;

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        String totalAmountPaidFormatted = NumberFormat.getCurrencyInstance().format(totalAmountPaid);
        String totalInterestPaidFormatted = NumberFormat.getCurrencyInstance().format(totalInterestPaid);

        System.out.println("Mortgage: " + mortgageFormatted + "\nTotal Interest paid: " + totalInterestPaidFormatted
         + "\nTotal amount paid in " + numberOfPayments + " payments: " + totalAmountPaidFormatted);


    }
}
