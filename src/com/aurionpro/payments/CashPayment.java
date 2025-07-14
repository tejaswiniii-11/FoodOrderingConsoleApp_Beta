package com.aurionpro.payments;

public class CashPayment implements IPaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("💵 Please collect ₹" + amount + " in cash.");
        System.out.println("✅ Payment recorded successfully.");
    }
}
