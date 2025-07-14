package com.aurionpro.food;

import java.util.*;

public class Menu {
    private String name;
    private List<MenuItem> items;
    private int itemIdCounter = 1;

    public Menu(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void addItem(String itemName, double price) {
        MenuItem item = new MenuItem(itemIdCounter++, itemName, price);
        items.add(item);
    }

    public boolean removeItem(String itemName) {
        return items.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
    }

    public MenuItem getItemById(int itemId) {
        return items.stream()
                .filter(item -> item.getId() == itemId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.println("-----------------------------------------");
        for (MenuItem item : items) {
            sb.append("   ").append(item).append("\n"); // Shows ID, name, price
            
        }
        return sb.toString();
    }
}
