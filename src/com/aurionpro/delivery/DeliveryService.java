package com.aurionpro.delivery;

import java.util.*;

public class DeliveryService implements IDeliveryService {
    private static final List<String> deliveryPartners = new ArrayList<>();

    // Predefined delivery partners
    static {
        deliveryPartners.add("Swiggy");
        deliveryPartners.add("Zomato");
        deliveryPartners.add("Blinkit");
    }

    @Override
    public void addPartner(String name) {
        deliveryPartners.add(name);
        System.out.println("✅ Partner '" + name + "' added.");
    }

    @Override
    public void removePartner(String name) {
        if (deliveryPartners.remove(name)) {
            System.out.println("✅ Partner '" + name + "' removed.");
        } else {
            System.out.println("❌ Partner not found.");
        }
    }

    @Override
    public void viewPartners() {
        System.out.println("🚚 Available Delivery Partners:");
        if (deliveryPartners.isEmpty()) {
            System.out.println("No delivery partners available.");
        } else {
            for (String partner : deliveryPartners) {
                System.out.println("- " + partner);
            }
        }
    }

    @Override
    public String assignPartner() {
        if (deliveryPartners.isEmpty()) return "No delivery partners available";
        Random rand = new Random();
        return deliveryPartners.get(rand.nextInt(deliveryPartners.size()));
    }
}
