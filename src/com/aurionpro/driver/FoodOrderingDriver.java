package com.aurionpro.driver;

import java.util.Scanner;
import com.aurionpro.users.Admin;
import com.aurionpro.users.Customer;
import com.aurionpro.users.ICheckUser;
import com.aurionpro.food.*;
import com.aurionpro.orders.*;

public class FoodOrderingDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Mini Food Ordering App ===");

        ICheckUser admin = new Admin();
        ICheckUser customer = new Customer();

        while (true) {
            System.out.print("\nEnter username: ");
            String username = scanner.nextLine().trim();

            System.out.print("Enter password: ");
            String password = scanner.nextLine().trim();

            if (admin.login(username, password)) {
                System.out.println("\n✅ Login successful as Admin.");
                ((Admin) admin).showAdminInterface();

                // 🔁 Prompt for customer login or exit
                System.out.print("\nNow do you wish to continue as customer or exit? (customer/exit): ");
                String nextChoice = scanner.nextLine().trim();

                if (nextChoice.equalsIgnoreCase("customer")) {
                    // Clear buffer in case of leftover input
                    while (true) {
                        System.out.print("Enter username: ");
                        username = scanner.nextLine().trim();
                        System.out.print("Enter password: ");
                        password = scanner.nextLine().trim();

                        if (customer.login(username, password)) {
                            System.out.println("\n✅ Login successful as Customer.");
                            ((Customer) customer).showCustomerInterface();
                            break;
                        } else {
                            System.out.println("❌ Invalid credentials. Please try again.");
                            System.out.print("Do you want to try again? (Y/N): ");
                            String choice = scanner.nextLine();
                            if (choice.equalsIgnoreCase("N")) {
                                System.out.println("👋 Exiting application. Goodbye!");
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("👋 Exiting application. Goodbye!");
                }
                break; // Exit the outermost loop after admin + customer flow
            } else if (customer.login(username, password)) {
                System.out.println("\n✅ Login successful as Customer.");
                ((Customer) customer).showCustomerInterface();
                break;
            } else {
                System.out.println("❌ Invalid credentials. Please try again.");
                System.out.print("Do you want to try again? (Y/N): ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("N")) {
                    System.out.println("👋 Exiting application. Goodbye!");
                    break;
                }
            }
        }

        scanner.close();
    }
}
