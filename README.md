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
- ✅ **Invoice Generation**: Print full bill with items, quantities, price, discount, total, payment method, and delivery partner

---

## 📁 Project Structure (Suggested Packages)

com.aurionpro
├── delivery
|
│   ├── DeliveryPartner.java
|
│   ├── DeliveryService.java
|
│   └── IDeliveryService.java
│
├── discount
|
│   ├── IDiscountStrategy.java
|
│   └── PercentageDiscount.java
│
├── food
|
│   ├── Menu.java
|
│   ├── MenuItem.java
|
│   ├── MenuManager.java
|
│   ├── IMenuManager.java
|
│   ├── IMenuViewer.java
│
├── invoice
|
│   ├── InvoiceGenerator.java
|
│   └── IInvoiceGenerator.java
│
├── orders
|
│   ├── CartItem.java
|
│   ├── OrderManager.java
|
│   └── IOrderManager.java
│
├── payments
|
│   ├── IPaymentService.java
|
│   ├── CashPayment.java
|
│   └── UpiPayment.java
│
├── users
|
│   ├── ICheckUser.java
|
│   ├── Admin.java
|
│   └── Customer.java
│
└── tests
    └── FoodOrderingDriver.java


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


