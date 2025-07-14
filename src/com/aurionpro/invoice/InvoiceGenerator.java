package com.aurionpro.invoice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.aurionpro.orders.CartItem;

public class InvoiceGenerator implements IInvoiceGenerator {

    @Override
    public void generateInvoice(List<CartItem> cart, double total, double discountedTotal, String paymentMethod, String deliveryPartner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentTime = LocalDateTime.now().format(formatter);

        System.out.println("\n\n=============== 🧾 INVOICE 🧾 ===============");
        System.out.println("🕒 Order Time       : " + currentTime);
        System.out.println("🚚 Delivery Partner : " + deliveryPartner);
        System.out.println("💳 Payment Method   : " + paymentMethod);
        System.out.println("--------------------------------------------");
        System.out.printf("%-20s %-10s %-10s%n", "Item", "Qty", "Price");

        for (CartItem item : cart) {
            double itemTotal = item.getPrice() * item.getQuantity();
            System.out.printf("%-20s %-10d ₹%-10.2f%n", item.getItemName(), item.getQuantity(), itemTotal);
        }

        System.out.println("--------------------------------------------");
        System.out.printf("Total Before Discount : ₹%.2f%n", total);
        System.out.printf("Discounted Total      : ₹%.2f%n", discountedTotal);
        System.out.println("==========================================\n\n");
        System.out.println("\n Thankyou and visit again!");
       
    }
}
