package com.aurionpro.food;

import java.util.*;

public class MenuManager implements IMenuManager, IMenuViewer {
    private static final Map<String, Menu> menuMap = new LinkedHashMap<>();

    static {
        Menu indian = new Menu("Indian");
        indian.addItem("Paneer Tikka", 200);
        indian.addItem("Butter Naan", 50);
        menuMap.put("Indian", indian);

        Menu chinese = new Menu("Chinese");
        chinese.addItem("Fried Rice", 180);
        chinese.addItem("Spring Roll", 120);
        menuMap.put("Chinese", chinese);

        Menu japanese = new Menu("Japanese");
        japanese.addItem("Sushi", 300);
        japanese.addItem("Ramen", 250);
        menuMap.put("Japanese", japanese);
    }

    @Override
    public void addMenu(String menuName) {
        if (menuMap.containsKey(menuName)) {
            System.out.println("⚠️ Menu already exists.");
        } else {
            menuMap.put(menuName, new Menu(menuName));
            System.out.println("✅ Menu added successfully.");
        }
    }

    @Override
    public void deleteMenu(String menuName) {
        if (menuMap.remove(menuName) != null) {
            System.out.println("🗑 Menu deleted.");
        } else {
            System.out.println("❌ Menu not found.");
        }
    }

    @Override
    public void addMenuItem(String menuName, String itemName, double price) {
        Menu menu = menuMap.get(menuName);
        if (menu == null) {
            System.out.println("❌ Menu not found.");
        } else {
            menu.addItem(itemName, price);
            System.out.println("✅ Item added to " + menuName + " menu.");
        }
    }

    @Override
    public void deleteMenuItem(String menuName, String itemName) {
        Menu menu = menuMap.get(menuName);
        if (menu == null) {
            System.out.println("❌ Menu not found.");
        } else {
            boolean removed = menu.removeItem(itemName);
            System.out.println(removed ? "🗑 Item removed." : "❌ Item not found.");
        }
    }

    @Override
    public void viewMenus() {
        if (menuMap.isEmpty()) {
            System.out.println("📭 No menus available.");
        } else {
            int index = 1;
            for (Map.Entry<String, Menu> entry : menuMap.entrySet()) {
                System.out.println(index + ". " + entry.getKey());
                System.out.println(entry.getValue()); // show items with IDs
                index++;
            }
        }
    }

    public String getMenuNameByIndex(int index) {
        List<String> keys = new ArrayList<>(menuMap.keySet());
        if (index >= 1 && index <= keys.size()) {
            return keys.get(index - 1);
        }
        return null;
    }

    public static Map<String, Menu> getAllMenus() {
        return menuMap;
    }
}
