# Module 3: Design Patterns

Design patterns are reusable solutions to common object-oriented design problems.

The goal is not to memorize pattern names. The goal is to recognize the shape of a problem and choose a clean design.

---

## 3.1 Strategy Pattern

### What is Strategy?
The Strategy Pattern lets you define a family of algorithms, put each one in its own class, and make them interchangeable.

### Why is Strategy important?
When you have multiple ways to do the same task, Strategy avoids giant `if-else` or `switch` blocks.

### When should you use it?
Use Strategy when:
1. You have several ways to perform one behavior.
2. You want to swap the behavior at runtime.
3. You want to keep the main class simple and stable.

### Key Benefits
1.  **Flexibility**: Behavior can be changed without changing the caller.
2.  **Clean code**: Fewer conditional branches.
3.  **Extensibility**: New algorithms can be added without rewriting existing code.

---

## 3.2 Factory Pattern

### What is Factory?
The Factory Pattern centralizes object creation so the caller does not need to know the exact concrete class.

### Why is Factory important?
When object creation depends on input, environment, or configuration, Factory helps keep creation logic out of business logic.

### When should you use it?
Use Factory when:
1. You want to hide object creation details.
2. You have multiple related concrete classes.
3. You want one place to decide which implementation to create.

### Key Benefits
1.  **Decoupling**: Callers depend on a factory or abstraction, not concrete constructors.
2.  **Centralized creation**: Object creation logic stays in one place.
3.  **Easier extension**: Add new product types with minimal changes to caller code.

---

## 3.3 Observer Pattern

### What is Observer?
The Observer Pattern lets an object notify many dependent objects automatically when its state changes.

### Why is Observer important?
When multiple parts of a system need to react to the same event, Observer avoids tight coupling between the event source and the listeners.

### When should you use it?
Use Observer when:
1. One object changes and many others should react.
2. You want to add or remove listeners dynamically.
3. You want loose coupling between the publisher and subscribers.

### Key Benefits
1.  **Loose coupling**: The subject does not need to know concrete listeners.
2.  **Dynamic subscription**: Listeners can join or leave at runtime.
3.  **Event-driven design**: Great for notifications, UI updates, and system events.
