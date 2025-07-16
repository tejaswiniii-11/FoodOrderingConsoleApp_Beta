package com.aurionpro.invoice;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.aurionpro.orders.CartItem;

public class InvoiceGenerator implements IInvoiceGenerator {

	@Override
	public void generateInvoice(List<CartItem> cart, double total, double discountedTotal, String paymentMethod,
			String deliveryPartner) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String currentTime = LocalDateTime.now().format(formatter);
		StringBuilder invoiceBuilder = new StringBuilder();

		invoiceBuilder.append("\n=============== 🧾 INVOICE 🧾 ===============\n");
		invoiceBuilder.append("🕒 Order Time       : ").append(currentTime).append("\n");
		invoiceBuilder.append("🚚 Delivery Partner : ").append(deliveryPartner).append("\n");
		invoiceBuilder.append("💳 Payment Method   : ").append(paymentMethod).append("\n");
		invoiceBuilder.append("--------------------------------------------\n");
		invoiceBuilder.append(String.format("%-20s %-10s %-10s\n", "Item", "Qty", "Price"));

		for (CartItem item : cart) {
			double itemTotal = item.getPrice() * item.getQuantity();
			invoiceBuilder
					.append(String.format("%-20s %-10d ₹%-10.2f\n", item.getItemName(), item.getQuantity(), itemTotal));
		}

		invoiceBuilder.append("--------------------------------------------\n");
		invoiceBuilder.append(String.format("Total Before Discount : ₹%.2f\n", total));
		invoiceBuilder.append(String.format("Discounted Total      : ₹%.2f\n", discountedTotal));
		invoiceBuilder.append("============================================\n");
		invoiceBuilder.append("\nThank you and visit again!\n");

		// Print to console
		System.out.println(invoiceBuilder.toString());

		// ✅ Save to text file
		try {
			String fileName = "Customer_Invoice_" + System.currentTimeMillis() + ".txt";
			File file = new File(
					"D:\\Swabhav_TB\\basic_assignments_app\\FoodOrderingConsoleApp_Miniproject\\src\\com\\aurionpro\\invoices_printed\\"
							+ fileName);
			file.getParentFile().mkdirs(); // create invoices/ if it doesn't exist
			FileWriter writer = new FileWriter(file);
			writer.write(invoiceBuilder.toString());
			writer.close();
			System.out.println("📄 Invoice saved at: " + file.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("❌ Error saving invoice: " + e.getMessage());
		}
	}
}
