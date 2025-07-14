package com.aurionpro.food;

import java.util.*;

public class Menu {
    private final String name;
    private final List<MenuItem> items = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public void addItem(String itemName, double price, String courseType, boolean isVeg) {
        items.add(new MenuItem(itemName, price, courseType, isVeg));
    }

    public boolean removeItem(String itemName) {
        return items.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
    }

    public MenuItem getItemById(int id) {
        if (id >= 1 && id <= items.size()) {
            return items.get(id - 1);
        }
        return null;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        if (items.isEmpty()) return "  No items in this menu.";

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-4s | %-20s | %-8s | %-12s | %-10s%n", "ID", "Item Name", "Price", "Course", "Veg/Non-Veg"));
        sb.append("----------------------------------------------------------------------------\n");

        for (int i = 0; i < items.size(); i++) {
            sb.append(String.format("%-4d | %s%n", i + 1, items.get(i)));
        }

        return sb.toString();
    }
}
