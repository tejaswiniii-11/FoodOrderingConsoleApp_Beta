package com.aurionpro.driver;

import java.util.Scanner;
import com.aurionpro.users.Admin;
import com.aurionpro.users.Customer;
import com.aurionpro.users.ICheckUser;

public class FoodOrderingDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== 🍽️ Welcome to Mini Food Ordering App ===");

        while (running) {
            System.out.println("\n🔐 Login Options:");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Customer");
            System.out.println("3. Exit");
            System.out.print("Choose your option (1/2/3): ");

            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    loginAsAdmin(scanner);
                    break;

                case "2":
                    loginAsCustomer(scanner);
                    break;

                case "3":
                    System.out.println("👋 Exiting application. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("❌ Invalid option. Please choose 1, 2, or 3.");
            }
        }

        scanner.close();
    }

    private static void loginAsAdmin(Scanner scanner) {
        ICheckUser admin = new Admin();

        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine().trim();

        if (admin.login(username, password)) {
            System.out.println("✅ Admin Login Successful!");
            ((Admin) admin).showAdminInterface();

            postSessionPrompt(scanner);
        } else {
            System.out.println("❌ Invalid Admin credentials.");
        }
    }

    private static void loginAsCustomer(Scanner scanner) {
        System.out.print("Enter Customer Username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Enter Customer Password: ");
        String password = scanner.nextLine().trim();

        ICheckUser customer = new Customer();
        if (customer.login(username, password)) {
            System.out.println("✅ Customer Login Successful!");
            ((Customer) customer).showCustomerInterface();

            postSessionPrompt(scanner);
        } else {
            System.out.println("❌ Invalid Customer credentials.");
        }
    }

    private static void postSessionPrompt(Scanner scanner) {
        while (true) {
            System.out.print("\n🔁 Do you want to login again as (admin/customer/exit)? ");
            String next = scanner.nextLine().trim();

            switch (next.toLowerCase()) {
                case "admin":
                    loginAsAdmin(scanner);
                    return;
                case "customer":
                    loginAsCustomer(scanner);
                    return;
                case "exit":
                    System.out.println("👋 Thank you for using the Food Ordering App!");
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid input. Please enter admin, customer, or exit.");
            }
        }
    }
}
