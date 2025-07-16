package com.aurionpro.food;

public interface IMenuManager {
    void addMenu(String menuName);
    void deleteMenu(String menuName);
    void addMenuItem(String menuName, String itemName, double price, String courseType);
    void deleteMenuItem(String menuName, String itemName);
}
