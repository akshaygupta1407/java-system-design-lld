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
