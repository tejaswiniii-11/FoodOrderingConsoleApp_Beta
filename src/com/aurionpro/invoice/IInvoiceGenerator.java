package com.aurionpro.invoice;

import java.util.List;
import com.aurionpro.orders.CartItem;

public interface IInvoiceGenerator {
    void generateInvoice(List<CartItem> cart, double total, double discountedTotal, String paymentMethod, String deliveryPartner);
}
