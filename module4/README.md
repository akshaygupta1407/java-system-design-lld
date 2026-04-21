# Module 4: Advanced Design Patterns

This module covers patterns that show up often in real LLD work when behavior needs to change, objects need to be composed, or requests need to flow through steps.

---

## 4.1 State Pattern

### What is State?
The State Pattern lets an object change its behavior when its internal state changes.

### Why is State important?
It avoids big `if-else` blocks based on status flags.

### Key Benefits
1.  Behavior changes cleanly with state.
2.  State-specific logic stays isolated.
3.  Code becomes easier to extend.

---

## 4.2 Template Method Pattern

### What is Template Method?
The Template Method Pattern defines the skeleton of an algorithm in a base class and lets subclasses fill in the details.

### Why is Template Method important?
It keeps common steps in one place while still allowing variation.

### Key Benefits
1.  Reuse shared flow.
2.  Let subclasses customize specific steps.
3.  Keep algorithm structure stable.

---

## 4.3 Proxy Pattern

### What is Proxy?
The Proxy Pattern provides a stand-in object that controls access to another object.

### Why is Proxy important?
It can help with lazy loading, access control, logging, or caching.

### Key Benefits
1.  Control access to the real object.
2.  Add behavior before or after calls.
3.  Keep the client unaware of the proxy.

---

## 4.4 Composite Pattern

### What is Composite?
The Composite Pattern lets you treat individual objects and groups of objects uniformly.

### Why is Composite important?
It is useful when objects form tree structures, like folders and files.

### Key Benefits
1.  Uniform treatment of leaf and group objects.
2.  Simple tree traversal.
3.  Natural fit for hierarchical structures.

---

## 4.5 Chain of Responsibility Pattern

### What is Chain of Responsibility?
The Chain of Responsibility Pattern passes a request through a chain of handlers until one handles it.

### Why is Chain of Responsibility important?
It removes hard-coded request routing and allows handlers to be added or reordered easily.

### Key Benefits
1.  Decouples sender from receiver.
2.  Supports flexible request processing.
3.  Easy to extend with new handlers.
