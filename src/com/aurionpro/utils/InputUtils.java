package com.aurionpro.utils;

import java.util.Scanner;

public class InputUtils {
    public static int readPositiveIntInput(Scanner scanner, String prompt) {
        int value = -1;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            if (!input.matches("\\d+")) {
                System.out.println("❌ Invalid input! Please enter a positive number only.");
                continue;
            }

            value = Integer.parseInt(input);
            if (value <= 0) {
                System.out.println("❌ Value must be greater than 0.");
            } else {
                break;
            }
        }
        return value;
    }

    public static double readPositiveDoubleInput(Scanner scanner, String prompt) {
        double value = -1;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            if (!input.matches("\\d+(\\.\\d+)?")) {
                System.out.println("❌ Invalid input! Please enter a valid amount (e.g., 150 or 150.75).\n");
                continue;
            }

            value = Double.parseDouble(input);
            if (value <= 0) {
                System.out.println("❌ Amount must be greater than 0.");
            } else {
                break;
            }
        }
        return value;
    }
}
