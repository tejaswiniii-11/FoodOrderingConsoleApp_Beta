package com.aurionpro.orders;

import com.aurionpro.food.*;
import java.util.*;

public class OrderManager implements IOrderManager {
    private final List<CartItem> cart = new ArrayList<>();

    @Override
    public void addToCart(int menuId, int itemId, int quantity) {
        if (menuId < 1 || itemId < 1 || quantity < 1) {
            System.out.println("❌ Invalid ID or quantity. All values must be positive.");
            return;
        }

        List<Menu> menus = new ArrayList<>(MenuManager.getAllMenus().values());

        if (menuId > menus.size()) {
            System.out.println("❌ Invalid Menu ID.");
            return;
        }

        Menu menu = menus.get(menuId - 1);
        MenuItem item = menu.getItemById(itemId);

        if (item == null) {
            System.out.println("❌ Item ID not found in the selected menu.");
            return;
        }

        boolean found = false;
        for (CartItem cartItem : cart) {
            if (cartItem.getItemName().equalsIgnoreCase(item.getName())) {
                int newQty = cartItem.getQuantity() + quantity;
                cart.remove(cartItem);
                cart.add(new CartItem(item.getName(), item.getPrice(), newQty));
                found = true;
                break;
            }
        }

        if (!found) {
            cart.add(new CartItem(item.getName(), item.getPrice(), quantity));
        }

        System.out.println("🛒 Add Order: ✅ " + quantity + " item(s) of '" + item.getName() + "' added to cart.");
    }

    @Override
    public void removeFromCart(String itemName) {
        Iterator<CartItem> iterator = cart.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        System.out.println(removed ? "🗑 Delete Order: Item removed from cart." : "❌ Item not found in cart.");
    }

    @Override
    public void showCart() {
        if (cart.isEmpty()) {
            System.out.println("🛒 View Cart: Cart is empty.");
        } else {
            System.out.println("🛒 View Cart:");
            for (CartItem item : cart) {
                System.out.println(item.getItemName() + " x" + item.getQuantity() + " - ₹" + item.getPrice());
            }
        }
    }

    @Override
    public double calculateTotal() {
        return cart.stream()
                   .mapToDouble(item -> item.getPrice() * item.getQuantity())
                   .sum();
    }

    @Override
    public List<CartItem> getCartItems() {
        return cart;
    }
}
