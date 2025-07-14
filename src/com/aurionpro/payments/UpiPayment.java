package com.aurionpro.payments;

import java.util.Scanner;

public class UpiPayment implements IPaymentService {

    @Override
    public void processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter UPI ID: ");
        String upiId = scanner.nextLine();
        System.out.print("Enter UPI Password: ");
        String password = scanner.nextLine();

        if (!upiId.contains("@")) {
            System.out.println("❌ Invalid UPI ID. It must contain '@'. Payment failed.");
            return;
        }

        if (upiId.isEmpty() || password.isEmpty()) {
            System.out.println("❌ UPI ID and password cannot be empty. Payment failed.");
            return;
        }

        System.out.println("✅ Payment of ₹" + amount + " successful via UPI.");
    }
}
