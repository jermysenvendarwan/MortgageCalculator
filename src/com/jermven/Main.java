package com.jermven;

import java.security.Principal;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        int principal = 0;
        float annualInterest = 0;
        byte years = 0;

        System.out.print("Principal ($100k - $1M): ");
        principal = scanner.nextInt();

        while (principal < 100_000 || principal > 1_000_000) {
            System.out.print("Enter a number between 100,000 amd 1,000,000: ");
            principal = scanner.nextInt();
        }

        System.out.print("Annual Interest Rate (0-5%): ");
        annualInterest = scanner.nextFloat();

        while (annualInterest > 5.0) {
            System.out.print("Enter a number between 0 and 5%: ");
            annualInterest = scanner.nextFloat();
        }

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (1-35 years): ");
        years = scanner.nextByte();

        while (years < 1 || years > 35) {
            System.out.print("Enter a number between 1 and 35: ");
            years = scanner.nextByte();
        }
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
