package com.aurionpro.invoice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceStorageManager {
    private static final String FILE_PATH = "invoices.dat";

    public static void saveInvoice(Invoice invoice) {
        List<Invoice> invoices = getAllInvoices();
        invoices.add(invoice);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(invoices);
        } catch (IOException e) {
            System.out.println("❌ Failed to save invoice.");
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Invoice> getAllInvoices() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Invoice>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Failed to read invoices.");
            return new ArrayList<>();
        }
    }
}
