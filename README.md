Java OOP E-commerce Application

A Java 17 console application built using Object-Oriented Programming, feature-based layered architecture, and design patterns to simulate a shopping, checkout, and shipping workflow.

✨ Features

- Java 17

- Java 8 features(Lambda, Stream API,..)
  
- Object-Oriented Design (OOP)
  
- Feature-based layered architecture
  
- Strategy Pattern (cart items validators)
  
- Command Pattern (add items to cart workflow)
  
- Global exception handling
  
- Console-based cash receipt generation
  
- Clean, maintainable, and extensible codebase

📁 Project Structure

        org.example
        
        │
        
        ├── cart        → Cart logic and cart-related operations
        
        ├── checkout    → Checkout flow and payment processing
        
        ├── common      → Shared models, constants, and base classes
        
        ├── customer    → Customer-related entities and logic
        
        ├── product     → Product models and inventory handling
        
        ├── shipping    → Shipping logic and weight calculation
        
        ├── signin      → User authentication / login handling
        
        ├── utils       → Utility and helper classes
        
        │
        
        └── Main        → Application entry point



Each package represents a single business feature, ensuring low coupling and high cohesion.

🧾 Sample Output

The application generates a formatted cash receipt including:

Shipping details and total weight

Itemized checkout information

Subtotal, shipping fees, and final total


        ********  CASH RECEIPT  ********

                Shipping Info
        -----------------------------
        Item        Qty     Weight
        tv          1       20.0
        mobile      1       1.0
        cheese      3       0.25

        Total Weight: 21.75Kg
        ----------------------------
                Check-out Info
        ----------------------------
        Item        Qty     Price
        tv          1       1300.0
        mobile      1       4000.0
        cheese      3       25.0

        Subtotal:       5325.0
        Shipping fees:  440.0
        Total:          5765.0


🛠 Technologies

Java 17

IntelliJ IDEA

Console I/O


📌 Concepts Applied

Encapsulation, Inheritance, Polymorphism, Abstraction

Strategy & Command design patterns

Centralized exception handling


