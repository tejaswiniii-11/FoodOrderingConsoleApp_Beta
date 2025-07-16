package com.aurionpro.invoice;

import java.io.*;
import java.nio.file.*;

public class InvoiceViewer {

    private static final String INVOICE_DIR = "D:\\Swabhav_TB\\basic_assignments_app\\FoodOrderingConsoleApp_Miniproject\\src\\com\\aurionpro\\invoices_printed\\";

    public static void displayAllInvoices() {
        File folder = new File(INVOICE_DIR);
        if (!folder.exists() || folder.listFiles() == null || folder.listFiles().length == 0) {
            System.out.println("📭 No orders found.");
            return;
        }

        System.out.println("\n======= 📂 All Stored Invoices =======");
        for (File file : folder.listFiles()) {
            System.out.println("\n🧾 File: " + file.getName());
            System.out.println("----------------------------------");
            try {
                Files.lines(file.toPath()).forEach(System.out::println);
            } catch (IOException e) {
                System.out.println("❌ Error reading invoice: " + e.getMessage());
            }
            System.out.println("----------------------------------");
        }
    }
}
