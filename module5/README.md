# Module 5: Parking Lot System

This module turns OOP, SOLID, and design patterns into a real low-level design problem.

The goal is to design a parking lot that can:
1. Handle different vehicle types.
2. Allocate suitable parking spots.
3. Issue tickets on entry.
4. Calculate charges on exit.
5. Stay flexible when rules change.

---

## 5.1 Problem Understanding

Before coding, identify:
1. Core entities
2. Responsibilities
3. Relationships
4. Extensibility points

### How to think in an interview
When the interviewer says "design a parking lot," do not jump straight into classes. First, ask clarifying questions and frame the problem.

Think in this order:
1. What exactly needs to be supported?
2. What are the vehicle types?
3. How are parking spots organized?
4. How does entry and exit work?
5. How is pricing calculated?
6. What changes should the design handle later?

### Questions to ask the interviewer
Ask short, practical questions like:
1. How many vehicle types should I support?
2. Do different vehicles need different spot types?
3. Do we have multiple floors?
4. Should the system issue tickets on entry?
5. How is the fee calculated: by time, by vehicle type, or both?
6. Do we need to support reservations or only live parking?
7. Should I assume one parking lot or multiple parking lots?
8. Do we need to handle full capacity cases?

### Good interview flow
1. Clarify requirements.
2. Draw a rough object map.
3. Identify core entities.
4. Identify actions and responsibilities.
5. Look for places where patterns help.
6. Implement the minimal working design.
7. Mention future extensions after the core solution is done.

### What to avoid
1. Do not start with code immediately.
2. Do not over-engineer with too many patterns too early.
3. Do not keep all logic inside one giant `ParkingLot` class.
4. Do not forget entry, exit, and pricing responsibilities.

---

## 5.2 Core Concepts

Typical building blocks:
1. Vehicle
2. Parking Spot
3. Parking Floor
4. Parking Lot
5. Ticket
6. Pricing strategy

---

## 5.3 Design Goals

1. Keep classes small and focused.
2. Use abstraction for flexible allocation and pricing.
3. Avoid hard-coded vehicle/spot logic where possible.
4. Make entry and exit flows easy to follow.

---

## 5.4 Practice Flow

1. Model the entities.
2. Create spot allocation logic.
3. Add ticket generation.
4. Add pricing.
5. Review and refactor.
