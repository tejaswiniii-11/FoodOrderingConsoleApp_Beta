# 🍽️ Mini Food Ordering Console App (Beta)

### A console-based food ordering system for Admins and Customers built with Java 🧑‍💻

This **Beta version** of the Mini Food Ordering App allows an **Admin** to manage menus, discounts, and delivery partners, while **Customers** can browse menus, place orders, and receive printed invoices — all through a console interface.

---

✅ Key Features

👩‍💼 Admin Functionalities

➕ Add/Delete Menus and Menu Items (with IDs)

🏷️ Set Discount Percentage

📃 View Menu List

🚚 Manage Delivery Partners

📃 View Customer Invoices


👩‍🍳 Customer Functionalities

📖 View Menus

➕➖ Add/Delete Items to Cart (via Menu ID & Item ID)

🛒 View Cart

💰 View Total Price (with applied discounts)

🧾 Make Payment (UPI / Cash)

🧍 Assigned Delivery Partner

🧾 Generate Invoice



---

## 📌 Functional Scope

- ✅ **Menu Display**: Dynamic list of food items by menu
- ✅ **Order Placement**: Customer selects items and quantities
- ✅ **Discount System**: Flat discount applied if total > ₹500 🤑
- ✅ **Payment Options**: Choose between **Cash 💵** or **UPI 📱**
- ✅ **Delivery Assignment**: Random assignment to available delivery agents
- ✅ **Invoice Generation**: Print full bill with items, quantities, price, discount, total, payment method, and delivery partner and also store it using serialization concept

---

## 📁 Project Structure (Suggested Packages)

<img width="338" height="389" alt="image" src="https://github.com/user-attachments/assets/7068eafd-1849-4287-b561-b3fd7657b4b2" />



<img width="338" height="389" alt="image" src="https://github.com/user-attachments/assets/0a09f264-0f3f-450a-9e4e-2c554df2a967" />

<img width="191" height="173" alt="image" src="https://github.com/user-attachments/assets/5df63ade-2cff-40c8-9385-ad715ec1d248" />






🔍 SOLID Design Principles Used


🧱 Principle	  ✅ Implementation

S -             Single Responsibility	Each class does one job only — e.g., MenuManager manages menus, OrderManager handles cart logic, InvoiceGenerator generates invoices.

O -             Open/Closed	System is open for extension, closed for modification — e.g., new payments/discounts can be added without changing existing classes using                         interfaces.

L -             Liskov Substitution	Subtypes like CashPayment, UpiPayment are interchangeable via IPaymentService abstraction.

I -             Interface Segregation	Interfaces are granular and focused — e.g., IMenuViewer, IMenuManager, IDeliveryService.

D -             Dependency Inversion	High-level modules (Customer, etc.) depend on interfaces, not concrete classes — promoting flexibility and testability.



🛠️ Technologies Used

☕ Java 17
🧭 Object-Oriented Programming
🖥️ Console-based User Interaction
🧱 SOLID Design Principles


🚀 How to Run
git clone https://github.com/yourusername/food-ordering-console-app.git
cd food-ordering-console-app


➡️ Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse).
➡️ Run FoodOrderingDriver.java from the com.aurionpro.tests package to start the application.


