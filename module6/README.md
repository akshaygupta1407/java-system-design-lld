# Module 6: Elevator System

This module focuses on designing an elevator system with requests, movement, and scheduling.

---

## 6.1 Problem Understanding

Before coding, understand:
1. How many elevators exist?
2. How are requests placed?
3. How does an elevator choose which request to serve?
4. How does direction affect movement?
5. What states can an elevator have?

---

## 6.2 Core Concepts

Typical entities:
1. Elevator
2. Elevator Controller
3. Floor Request
4. Direction
5. Elevator State

---

## 6.3 Design Goals

1. Keep request handling separate from movement logic.
2. Model state explicitly.
3. Make scheduling flexible.
4. Avoid a huge `if-else` block for elevator behavior.

---

## 6.4 Practice Flow

1. Model elevator and request entities.
2. Add direction and state handling.
3. Create controller logic.
4. Improve scheduling.
