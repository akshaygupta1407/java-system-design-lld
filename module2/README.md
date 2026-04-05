# Module 2: The SOLID Principles

The SOLID principles are a set of five design principles that make software designs more understandable, flexible, and maintainable.

---

## 2.1 Single Responsibility Principle (SRP)

### What is SRP?
The Single Responsibility Principle states that a class should have one, and only one, reason to change. In simpler terms, a class should do only one thing.

### Why is SRP important?
In a large system, when a single class (a "God Class") handles multiple responsibilities (e.g., managing user data, sending emails, AND connecting to a database), any change to one responsibility risks breaking others.

A class with multiple responsibilities is:
1.  **Dificult to Understand**: It does too many things.
2.  **Difficult to Test**: You have to test every scenario for every responsibility.
3.  **Fragile**: A change in the database logic might accidentally break the email-sending logic.

### How to identify an SRP violation?
Ask yourself: "What does this class do?" 
- If your answer contains the word "**and**," you probably have a violation.
- *Example*: "This class manages user profiles **and** saves them to the database." (**Violation!**)
- *Solution*: Create one class for `UserProfile` and another for `UserRepository`.

### Key Benefits of SRP
1.  **Maintainability**: Changes are isolated to specific classes.
2.  **Testability**: Small, focused classes are easier to unit test.
3.  **Reusability**: You can reuse the `UserRepository` in other parts of the system without dragging along all the `UserProfile` logic.

---

## 2.2 Open/Closed Principle (OCP)

### What is OCP?
The Open/Closed Principle says software entities should be open for extension, but closed for modification.

### Why is OCP important?
In real systems, requirements change constantly. You want to add new behavior without rewriting stable code.

### How to recognize an OCP violation?
If you keep editing the same class every time a new type is introduced, that class is probably not following OCP.

### Typical OCP solution
Use abstraction and polymorphism:
1. Define an interface or abstract class.
2. Put each variation into its own class.
3. Make the core logic depend on the abstraction, not the concrete type.

### Key Benefits of OCP
1.  **Extensibility**: Add new features with new classes.
2.  **Safety**: Existing tested code stays untouched.
3.  **Cleaner architecture**: You avoid large switch statements and endless `if-else` chains.
