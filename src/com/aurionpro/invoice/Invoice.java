package com.aurionpro.invoice;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import com.aurionpro.orders.CartItem;

public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;

    private String customerName;
    private List<CartItem> cartItems;
    private double total;
    private double discount;
    private double finalAmount;
    private String paymentMode;
    private String deliveryPartner;
    private LocalDateTime timestamp;

    public Invoice(String customerName, List<CartItem> cartItems, double total,
                   double discount, double finalAmount, String paymentMode,
                   String deliveryPartner, LocalDateTime timestamp) {
        this.customerName = customerName;
        this.cartItems = cartItems;
        this.total = total;
        this.discount = discount;
        this.finalAmount = finalAmount;
        this.paymentMode = paymentMode;
        this.deliveryPartner = deliveryPartner;
        this.timestamp = timestamp;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double getTotal() {
        return total;
    }

    public double getDiscount() {
        return discount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public String getDeliveryPartner() {
        return deliveryPartner;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
