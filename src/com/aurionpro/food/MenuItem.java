package com.aurionpro.food;

public class MenuItem {
    private final String name;
    private final double price;
    private final String courseType;
    private final boolean isVeg;

    public MenuItem(String name, double price, String courseType, boolean isVeg) {
        this.name = name;
        this.price = price;
        this.courseType = courseType;
        this.isVeg = isVeg;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCourseType() {
        return courseType;
    }

    public boolean isVeg() {
        return isVeg;
    }

    @Override
    public String toString() {
        return String.format("%-20s | ₹%-6.2f | %-12s | %s", name, price, courseType, isVeg ? "Veg 🥦" : "Non-Veg 🍗");
    }
}
