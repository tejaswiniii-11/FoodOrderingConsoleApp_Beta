package com.aurionpro.food;

public class MenuItem {
    private int MenuItemid;         // Unique item ID within the menu
    private String name;
    private double price;

    public MenuItem(int MenuItemid, String name, double price) {
        this.MenuItemid = MenuItemid;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return MenuItemid;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return MenuItemid + ". " + name + " - ₹" + price;
    }
}
