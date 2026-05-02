# LLD Question 3: Library Management System

## Problem Statement

Design a library management system.

The system should allow:
1. Adding books to the library.
2. Searching books.
3. Issuing books to members.
4. Returning books.
5. Tracking availability of book copies.

---

## Clarifying Questions To Think About

Before coding, think through these:

1. Can a library have multiple copies of the same book?
2. Are books searched by title, author, or ISBN?
3. Can a member borrow multiple books?
4. Is there a borrowing limit per member?
5. Do we need due dates and late fees?
6. Can a book be reserved if all copies are unavailable?
7. Do we need librarian/admin roles?
8. Should we track individual book copies separately?

---

## Required Features

For your first version, support:

1. Book details with ISBN, title, and author.
2. Multiple copies of the same book.
3. Library members.
4. Borrowing an available copy.
5. Returning a borrowed copy.
6. Searching books by title or ISBN.

---

## Suggested Entities

You may use these, or design your own:

1. `Book`
2. `BookCopy`
3. `Member`
4. `Library`
5. `Loan`
6. `BookStatus`

---

## Design Hints

Useful ideas:

1. Keep `Book` as metadata only.
2. Use `BookCopy` for actual borrowable copies.
3. Keep borrowing and returning logic inside `Library` or a dedicated `LoanService`.
4. Avoid reducing a book quantity blindly if you need to track individual copies.

---

## Edge Cases

Think about:

1. Book not found.
2. No available copies.
3. Member not found.
4. Returning a book that was not borrowed.
5. Same member trying to borrow the same copy twice.
6. Borrowing limit exceeded.

---

## Your Task

Create your solution in:

```text
module7/librarymanagement/LibraryManagementSolution.java
```

When you are done, ask me to review it.
