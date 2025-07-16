package com.aurionpro.food;

import java.util.*;

public class MenuManager implements IMenuManager, IMenuViewer {
    private static final Map<String, Menu> menuMap = new LinkedHashMap<>();

    static {
        Menu indian = new Menu("Indian");
        indian.addItem("Paneer Tikka", 200, "Starters", true);
        indian.addItem("Chicken Malai Tikka", 250, "Starters", false);
        indian.addItem("Butter Naan", 50, "Main Course", true);
        indian.addItem("Chicken Curry", 220, "Main Course", false);
        indian.addItem("Gulab Jamun", 80, "Desserts", true);
        menuMap.put("Indian", indian);

        Menu chinese = new Menu("Chinese");
        chinese.addItem("Spring Roll", 120, "Starters", true);
        chinese.addItem("Chicken Spring Roll", 140, "Starters", false);
        chinese.addItem("Veg Fried Rice", 180, "Main Course", true);
        chinese.addItem("Chicken Fried Rice", 200, "Main Course", false);
        chinese.addItem("Mango Pudding", 90, "Desserts", true);
        menuMap.put("Chinese", chinese);

        Menu japanese = new Menu("Japanese");
        japanese.addItem("Miso Soup", 150, "Starters", true);
        japanese.addItem("Chicken Gyoza", 200, "Starters", false);
        japanese.addItem("Veg Ramen", 250, "Main Course", true);
        japanese.addItem("Chicken Teriyaki", 280, "Main Course", false);
        japanese.addItem("Mochi Ice Cream", 200, "Desserts", true);
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
                System.out.println(entry.getValue());
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

    @Override
    public void addMenuItem(String menuName, String itemName, double price, String courseType) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Is the item Veg? (true/false): ");
        boolean isVeg = Boolean.parseBoolean(scanner.nextLine());

        Menu menu = menuMap.get(menuName);
        if (menu == null) {
            System.out.println("❌ Menu not found.");
        } else {
            menu.addItem(itemName, price, courseType, isVeg);
            System.out.println("✅ Item added to " + menuName + " menu.");
        }
    }
}
