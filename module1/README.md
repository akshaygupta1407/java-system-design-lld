# Module 1: Core Object-Oriented Programming (OOP)

In this module, we build a solid foundation in Java OOP. Without mastering these concepts, it's impossible to understand higher-level design patterns or design scalable systems.

---

## 1.1 Encapsulation and Data Hiding

### What is Encapsulation?
Encapsulation is the mechanism of wrapping the data (variables) and code acting on the data (methods) together as a single unit (a Class). Imagine a capsule containing medicine—the medicine (data) is protected by the outer layer (methods).

### What is Data Hiding?
Data hiding specifically refers to the practice of keeping the internal state of an object shielded from the outside world. This is achieved in Java by using the `private` access modifier on your fields/variables.

### Why are they important for System Design?
When designing large systems, you want your individual components to be **robust** and **trustworthy**. If a class exposes its internal fields publicly, any other part of the codebase (and any other developer) can modify that state directly, bypassing any rules you wanted to enforce.

Let's look at an example:
- **The Problem**: If a `BankAccount` class has a `public double balance`, anyone could write `account.balance = -10000;`. Your business logic is broken because the object allowed itself to be put into an invalid state.
- **The Solution**: Make `balance` `private`. Provide a public method like `public void withdraw(double amount)`. Now, the `BankAccount` class controls its own state. When `withdraw()` is called, it can perform validation (e.g., checking if the amount is positive and does not exceed the current bounds) before actually modifying the internal balance.

### Key Benefits
1. **Validation & Control**: The class enforces rules over what can be stored in its fields.
2. **Maintainability**: You can change the internal implementation later (e.g., instead of a single `double balance`, you might decide to calculate it dynamically from a `List<Transaction>`) without breaking any external code that relies on your public getters and setters.
3. **Flexibility**: You can easily make fields strictly read-only (by providing only a getter method) or strictly write-only (by providing only a setter). 

---

## 1.2 Abstraction (Interfaces vs Abstract Classes)

### What is Abstraction?
Abstraction is the process of hiding implementation details and showing only the essential features of an object. In the real world, you know how to drive a car (using the steering wheel and pedals) without needing to know the complex internal workings of the combustion engine.

In Java, abstraction is achieved using either **Abstract Classes** or **Interfaces**.

### Interface vs Abstract Class
- **Interface**: 
  - Represents a *contract* or *capabilities* (What something can do: e.g., `Flyable`, `Runnable`, `PaymentGateway`).
  - Contains method signatures (without bodies) by default. (Java 8+ allows `default` and `static` methods, but the core idea remains a contract).
  - A class can implement multiple interfaces.
- **Abstract Class**: 
  - Represents an *is-a* relationship with shared behavior (What something fundamentally is: e.g., `Vehicle`, `Employee`).
  - Contains a mix of abstract methods (no bodies) and concrete methods (with bodies). It can also have state (fields).
  - A class can inherit only ONE abstract class (or any class).

### Why use Abstraction in System Design?
**"Program to an Interface, not an Implementation"** is a golden rule in System Design.
Imagine you're building an e-commerce checkout. Currently, you support Razorpay.
- **Without Abstraction**: Your checkout logic directly calls `Razorpay.processPayment()`. If next month your boss asks you to add Stripe, you have to rewrite your checkout logic entirely.
- **With Abstraction**: You create an interface `PaymentProcessor` with a method `processPayment()`. Your checkout logic uses this abstract interface. Then you create `RazorpayProcessor` and `StripeProcessor` that implement it. Adding a new provider now doesn't break existing code!

---

## 1.3 Inheritance vs. Composition

### What is Inheritance? (The "Is-A" Relationship)
Inheritance allows a new class (Subclass) to inherit fields and methods from an existing class (Superclass).
- Example: `Dog extends Animal`. A Dog **is an** Animal.
- **Pros:** Promotes code reuse and establishes a clear hierarchy.
- **Cons:** Extremely rigid. Tightly couples the child to the parent. Changes in the parent can break all children (The Fragile Base Class problem).

### What is Composition? (The "Has-A" Relationship)
Composition means building complex objects by combining simpler, smaller objects as fields, encapsulating them instead of inheriting from them.
- Example: `Car has an Engine`. Instead of `class Car extends Engine` (which makes no sense), you do `class Car { private Engine engine; }`.
- **Pros:** Highly flexible. You can swap out the `Engine` at runtime. Components are loosely coupled.

### Why "Favor Composition Over Inheritance" in System Design?
This is another golden rule of LLD. While inheritance seems great at first, deep inheritance trees become a nightmare to maintain.

**The Classic Inheritance Trap:**
You have a `Bird` class with a `fly()` method. You create `Sparrow extends Bird` (works fine). You create `Eagle extends Bird` (works fine). Then, you create `Penguin extends Bird`. Wait! Penguins are birds, but they can't fly. Now you have an inherited `fly()` method on Penguin that you have to override just to throw an exception. This is messy System Design!

**The Composition Solution:**
Extract the flying behavior into an interface: `FlyBehavior`.
Instead of a giant generic `Bird` parent class forcing `fly()` on everyone, you use composition. A `Sparrow` **has a** `FlyBehavior` object injected into it. A `Penguin` simply does not have it. Much cleaner!
