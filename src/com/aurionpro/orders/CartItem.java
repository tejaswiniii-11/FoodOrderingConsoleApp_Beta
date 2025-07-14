// File: com/aurionpro/orders/CartItem.java
package com.aurionpro.orders;

public class CartItem {
    private final String itemName;
    private final double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Optional: Increase quantity
    public void addQuantity(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        }
    }

    // Optional: Set quantity directly
    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    @Override
    public String toString() {
        return itemName + " x " + quantity + " @ ₹" + price + " each";
    }
}
