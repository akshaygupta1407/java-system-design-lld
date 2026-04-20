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

---

## 2.3 Liskov Substitution Principle (LSP)

### What is LSP?
The Liskov Substitution Principle says that objects of a superclass should be replaceable with objects of its subclasses without breaking the program.

### Why is LSP important?
If a subclass cannot behave like its parent, inheritance becomes misleading and unsafe.

### How to recognize an LSP violation?
If a subclass throws unsupported exceptions, ignores inherited behavior, or forces callers to treat it specially, LSP is probably broken.

### Typical LSP solution
1. Model real behavior honestly.
2. Split interfaces when some subclasses cannot support the full contract.
3. Prefer composition or smaller abstractions instead of forcing bad inheritance.

### Key Benefits of LSP
1.  **Safer inheritance**: Subclasses can truly stand in for their parents.
2.  **Less special-case logic**: Callers do not need `instanceof` checks.
3.  **Cleaner contracts**: Each class promises only what it can actually do.

---

## 2.4 Interface Segregation Principle (ISP)

### What is ISP?
The Interface Segregation Principle says that no client should be forced to depend on methods it does not use.

### Why is ISP important?
If an interface becomes too large, some classes will be forced to implement useless methods, which leads to bad design and dummy code.

### How to recognize an ISP violation?
If a class implements methods with empty bodies, throws unsupported exceptions, or clearly does not need half the interface, ISP is being violated.

### Typical ISP solution
1. Split one large interface into smaller, focused interfaces.
2. Let classes implement only the capabilities they actually need.
3. Combine multiple small interfaces when a class needs more than one capability.

### Key Benefits of ISP
1.  **Cleaner code**: Classes only depend on what they use.
2.  **Easier maintenance**: Changes stay localized.
3.  **Better reuse**: Smaller interfaces are easier to combine in different ways.

---

## 2.5 Dependency Inversion Principle (DIP)

### What is DIP?
The Dependency Inversion Principle says high-level modules should not depend on low-level modules. Both should depend on abstractions.

### Why is DIP important?
If your business logic directly creates and controls low-level classes, your system becomes hard to test, hard to change, and tightly coupled.

### How to recognize a DIP violation?
If a class uses `new` to create all of its dependencies internally, especially infrastructure classes like email senders, database clients, or payment gateways, DIP may be violated.

### Typical DIP solution
1. Define an abstraction for the dependency.
2. Let high-level code depend on that abstraction.
3. Inject the concrete implementation from outside.

### Key Benefits of DIP
1.  **Loose coupling**: Components can change independently.
2.  **Testability**: You can replace real dependencies with mocks or stubs.
3.  **Flexibility**: You can swap implementations without changing business logic.
