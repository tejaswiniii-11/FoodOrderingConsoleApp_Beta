package com.aurionpro.orders;

import java.util.List;

public interface IOrderManager {
    void addToCart(int menuId, int itemId, int quantity);
    void removeFromCart(String itemName);
    void showCart();
    double calculateTotal();
    List<CartItem> getCartItems();
}
