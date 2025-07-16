package com.aurionpro.users;

import java.util.Scanner;

import com.aurionpro.food.*;
import com.aurionpro.orders.*;
import com.aurionpro.discount.*;
import com.aurionpro.delivery.*;
import com.aurionpro.payments.*;
import com.aurionpro.invoice.*;

public class Customer implements ICheckUser {

    private static final String CUSTOMER_USERNAME = "tejaswini";
    private static final String CUSTOMER_PASSWORD = "teja123";

    private final IMenuViewer menuViewer = new MenuManager();
    private final IOrderManager orderManager = new OrderManager();
    private final IDiscountStrategy discountStrategy = new PercentageDiscount();
    private final IInvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    private final IDeliveryService deliveryService = new DeliveryService();

    private String paymentMethod = "Not Paid";
    private String assignedPartner = "Not Assigned";

    @Override
    public boolean login(String username, String password) {
        return CUSTOMER_USERNAME.equals(username) && CUSTOMER_PASSWORD.equals(password);
    }

    public void showCustomerInterface() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n====== Customer Menu ======");
            System.out.println("1. View Menus");
            System.out.println("2. Add Order");
            System.out.println("3. Delete Order");
            System.out.println("4. View Cart");
            System.out.println("5. View Total Price");
            System.out.println("6. Make Payment");
            System.out.println("7. Show Delivery Partner");
            System.out.println("8. Print Invoice");
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
                    menuViewer.viewMenus();
                    break;

                case 2:
                    System.out.print("Enter Menu ID: ");
                    int menuId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Item ID: ");
                    int itemId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter Quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    orderManager.addToCart(menuId, itemId, quantity);
                    break;

                case 3:
                    System.out.print("Enter item name to remove: ");
                    String removeItem = scanner.nextLine();
                    orderManager.removeFromCart(removeItem);
                    break;

                case 4:
                    orderManager.showCart();
                    break;

                case 5:
                    double total = orderManager.calculateTotal();
                    System.out.println("🧾 Total before discount: ₹" + total);
                    double finalAmount = discountStrategy.applyDiscount(total);
                    System.out.println("💰 Final Amount Payable: ₹" + finalAmount);
                    break;

                case 6:
                    System.out.println("Select Payment Method:");
                    System.out.println("1. UPI");
                    System.out.println("2. Cash");
                    System.out.print("Enter choice: ");
                    int payChoice = Integer.parseInt(scanner.nextLine());

                    IPaymentService paymentService;

                    double totalAmount = orderManager.calculateTotal();
                    double discountedAmount = discountStrategy.applyDiscount(totalAmount);

                    if (payChoice == 1) {
                        paymentService = new UpiPayment();
                        paymentMethod = "UPI";
                    } else if (payChoice == 2) {
                        paymentService = new CashPayment();
                        paymentMethod = "Cash";
                    } else {
                        System.out.println("❌ Invalid payment choice.");
                        break;
                    }

                    paymentService.processPayment(discountedAmount);
                    assignedPartner = deliveryService.assignPartner();
                    System.out.println("🚚 Your order has been assigned to: " + assignedPartner);
                    break;

                case 7:
                    System.out.println("🚚 Your assigned delivery partner is: " + assignedPartner);
                    break;

                case 8:
                    if (orderManager.getCartItems().isEmpty()) {
                        System.out.println("🛒 Cart is empty. Add items before printing invoice.");
                        break;
                    }

                    double invoiceTotal = orderManager.calculateTotal();
                    double invoiceDiscounted = discountStrategy.applyDiscount(invoiceTotal);

                    invoiceGenerator.generateInvoice(
                        orderManager.getCartItems(),
                        invoiceTotal,
                        invoiceDiscounted,
                        paymentMethod,
                        assignedPartner
                    );
                    break;

                case 9:
                    System.out.println("👋 Exiting Customer Interface...");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        } while (choice != 9);
    }
}
