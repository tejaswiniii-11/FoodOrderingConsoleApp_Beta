package com.aurionpro.discount;

public class PercentageDiscount implements IDiscountStrategy {

    private static final double DISCOUNT_PERCENT = 12.0; // fixed discount

    @Override
    public double applyDiscount(double amount) {
        System.out.println("Applying fixed discount. Current %: " + DISCOUNT_PERCENT);
        if (amount > 500) {
            double discount = amount * (DISCOUNT_PERCENT / 100);
            System.out.println("💸 Discount Applied: ₹" + discount);
            return amount - discount;
        }
        System.out.println("ℹ️ No discount applied. Total is ₹" + amount);
        return amount;
    }
}