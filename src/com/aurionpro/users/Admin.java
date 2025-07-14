package com.aurionpro.users;

import com.aurionpro.food.*;
import com.aurionpro.delivery.*;
import java.util.Scanner;

public class Admin implements ICheckUser {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    private final IMenuManager menuManager = new MenuManager();
    private final IMenuViewer menuViewer = (IMenuViewer) menuManager;

    @Override
    public boolean login(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }

    public void showAdminInterface() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n====== Admin Dashboard ======");
            System.out.println("1. Add Menu");
            System.out.println("2. Delete Menu");
            System.out.println("3. Add Menu Items");
            System.out.println("4. Delete Menu Item");
            System.out.println("5. Add Delivery Partner");
            System.out.println("6. Delete Delivery Partner");
            System.out.println("7. View Menus");
            System.out.println("8. View Delivery Partners");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter menu name: ");
                    menuManager.addMenu(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter menu name to delete: ");
                    menuManager.deleteMenu(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter menu name: ");
                    String menuName = scanner.nextLine();
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    menuManager.addMenuItem(menuName, itemName, price);
                    break;
                case 4:
                    System.out.print("Enter menu name: ");
                    menuName = scanner.nextLine();
                    System.out.print("Enter item name to delete: ");
                    itemName = scanner.nextLine();
                    menuManager.deleteMenuItem(menuName, itemName);
                    break;
                case 5:
                    System.out.print("Enter delivery partner name to add: ");
                    String partnerToAdd = scanner.nextLine();
                    new DeliveryService().addPartner(partnerToAdd);
                    break;

                case 6:
                    System.out.print("Enter delivery partner name to remove: ");
                    String partnerToRemove = scanner.nextLine();
                    new DeliveryService().removePartner(partnerToRemove);
                    break;
                case 7:
                    menuViewer.viewMenus();
                    break;
                case 8:
                    new DeliveryService().viewPartners();
                    break;
                case 9:
                    System.out.println("👋 Exiting Admin Interface...");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        } while (choice != 9);
    }
}
