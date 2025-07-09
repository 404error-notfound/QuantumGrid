# ⚡ Quantum Grid

<img src="https://plus.unsplash.com/premium_photo-1716999684556-f2f310f27e3a?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D">

Quantum Grid is a Java-based electricity service platform designed to modernize Kenya’s token-based billing system. Built using Object-Oriented Programming (OOP) and SOLID design principles, it addresses challenges such as delayed token delivery, frequent outages, and inefficient service access.

## 🚀 Features

### ✅ Functional Requirements
- User account creation and login
- Purchase of electricity tokens via M-Pesa, banking, or in-branch
- Real-time token generation and delivery
- Viewing usage and payment history
- Admin system monitoring
- Real-time syncing with electricity meters

### 🔐 Non-Functional Requirements
- Fast response for token generation
- Encrypted and secure user data storage
- High availability and uptime
- Scalable and user-friendly platform

## 🧠 Key Concepts & Architecture

### 👤 User and Admin Roles
- **Customer**: Can purchase tokens, view usage, and check payment history.
- **Admin**: Monitors all users, views all transactions, and oversees system performance.

### 🧱 Object-Oriented Principles Used
- **Inheritance**: `Customer` extends `User`
- **Abstraction**: Complex operations like DB connections are hidden from the user
- **Polymorphism**: Multiple payment methods and DB interactions supported
- **Encapsulation**: User details are private with public accessors

### 🧩 Core Classes
- `DatabaseConnection` – Establishes database connections via the `Connectable` interface.
- `PaymentService` – Handles transactions, implements `Connectable`.
- `User` – Base class for all users (attributes: name, email, password).
- `Customer` – Extends `User`, adds token purchase and balance checking.
- `Admin` – Manages system-wide data and performs monitoring tasks.

### 🧪 Interfaces
- `Connectable` – For classes requiring DB access.
- `VerifyPayments` – Verifies valid payment input (uses lambda expression).
- `TokenConversion` – Converts currency to token value (also lambda-based).

## 💳 Token Purchase Workflow
1. User submits a purchase request.
2. Payment is validated.
3. Tokens are generated and saved to the database.
4. Notification is sent to the user with token details.

**Token Price as of June 13, 2025**: 1 token ≈ 20.57 Ksh  
*Minimum purchase must exceed this amount.*

## 📊 Usage & History
- Customers can view personal usage and transaction history.
- Admins can query all users' data and monitor overall system health.

## 🔄 Meter Syncing
- All payments are instantly reflected in the system.
- Users and admins get real-time updates for transparency and reliability.

## 🧪 Simulator & Testing
- Includes a **database simulator** that uses Java's `Random` library to:
    - Generate test names, emails, and house numbers.
    - Simulate real-world data for development.

## 👥 Team Members and Authors
- <a href="https://github.com/JoyJudy">`JoyJudy Wangui`</a> - Database Design and Connectivity
- <a href="https://github.com/404error-notfound">`Angela Achieng`</a> - System Functionality
- <a href="https://github.com/stil-e">`Brian Mathara`</a> - Use case Diagram and System Architecture
- <a href="https://github.com/benir-o">`Benir Odeny`</a> - Database and Programming Logic
- <a href="https://github.com/gabu67">`Gabriel Osugo`</a> - User payment and functionality
- <a href="https://github.com/Suraj-231">`Suraj Kumar`</a> - System design, programming and Documentation

## 📚 Conclusion

Quantum Grid demonstrates how a well-designed, modular software system can solve real-world problems in power distribution. With emphasis on security, scalability, and user experience, it serves as both a functional prototype and an academic showcase of OOP and SOLID principles.

---

> For further exploration, review the codebase and documentation included in this repository. Contributions and feedback are welcome!


