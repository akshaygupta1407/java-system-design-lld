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

---

## 3.4 Decorator Pattern

### What is Decorator?
The Decorator Pattern lets you add behavior to an object dynamically by wrapping it in another object.

### Why is Decorator important?
When you want many optional features, inheritance can explode into too many subclasses. Decorator adds features step by step instead.

### When should you use it?
Use Decorator when:
1. You want to add responsibilities dynamically.
2. You want to avoid subclass combinations.
3. You want to keep the original object unchanged.

### Key Benefits
1.  **Flexible feature addition**: Wrap objects with extra behavior as needed.
2.  **Avoids subclass explosion**: No need for one class per combination.
3.  **Composable behavior**: Multiple decorators can be stacked together.

---

## 3.5 Builder Pattern

### What is Builder?
The Builder Pattern separates the construction of a complex object from its final representation.

### Why is Builder important?
When a class has many optional fields, constructor overloads become messy and hard to read. Builder makes object creation clearer.

### When should you use it?
Use Builder when:
1. A class has many optional parameters.
2. You want readable object creation.
3. You want to build immutable objects step by step.

### Key Benefits
1.  **Readable code**: Construction code is easy to understand.
2.  **Flexible object creation**: Set only the fields you need.
3.  **Good for immutability**: The final object can be made immutable.

---

## 3.6 Singleton Pattern

### What is Singleton?
The Singleton Pattern ensures that a class has only one instance and provides a global access point to it.

### Why is Singleton important?
Sometimes a system needs one shared object, like a configuration manager or logger. Singleton gives controlled shared access.

### When should you use it?
Use Singleton when:
1. Only one instance should exist.
2. You need shared state or shared access.
3. Creating multiple instances would be wasteful or harmful.

### Key Benefits
1.  **Single shared instance**: One object coordinates the behavior.
2.  **Controlled access**: The instance is created and accessed in one place.
3.  **Useful for shared services**: Configuration, logging, caches, etc.

---

## 3.7 Adapter Pattern

### What is Adapter?
The Adapter Pattern lets two incompatible interfaces work together by adding a wrapper between them.

### Why is Adapter important?
In real systems, you often need to use an old class or third-party library that does not match your expected interface.

### When should you use it?
Use Adapter when:
1. You have an existing class with the wrong interface.
2. You want to reuse a legacy or external component.
3. You want compatibility without changing the original class.

### Key Benefits
1.  **Compatibility**: Makes mismatched interfaces work together.
2.  **Reuse**: Helps you reuse existing code without rewriting it.
3.  **Decoupling**: The client only knows the expected interface.
