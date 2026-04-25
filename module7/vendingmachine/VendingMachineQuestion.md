# LLD Question 1: Vending Machine

## Problem Statement

Design a vending machine system.

The vending machine should allow a user to:
1. View available products.
2. Select a product.
3. Insert money.
4. Dispense the product.
5. Return change when needed.

---

## Clarifying Questions To Think About

Before coding, think through these:

1. What product information do we need?
2. Can a product go out of stock?
3. Can the user insert money before selecting a product?
4. What should happen if inserted money is insufficient?
5. What should happen if the product is unavailable?
6. Should the machine return change?
7. Should the machine support canceling a transaction?
8. What payment types are supported?

---

## Required Features

For your first version, support:

1. Products with name, price, and quantity.
2. Product selection.
3. Cash insertion.
4. Product dispensing.
5. Change return.
6. Transaction cancellation.

---

## Suggested Entities

You may use these, or design your own:

1. `Product`
2. `Inventory`
3. `VendingMachine`
4. `Payment`
5. `Transaction`
6. `MachineState`

---

## Design Hints

Useful patterns may include:

1. State Pattern for machine states.
2. Strategy Pattern for payment calculation or payment method.
3. Factory Pattern if you create product types.

Do not force patterns. Use them only if they make your design cleaner.

---

## Edge Cases

Think about:

1. Product not found.
2. Product out of stock.
3. Insufficient money.
4. Extra money and change.
5. Cancel after inserting money.
6. Multiple users trying transactions one after another.

---

## Your Task

Create your solution in:

```text
module7/vendingmachine/VendingMachineSolution.java
```

Try to solve it without looking up a solution.

When you are done, ask me to review it.
