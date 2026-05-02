package module7.librarymanagement;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * PRACTICE SOLUTION AREA: Library Management System
 *
 * Read LibraryManagementQuestion.md first.
 *
 * Keep the first version focused:
 * 1. Book
 * 2. BookCopy
 * 3. Member
 * 4. Library
 * 5. Loan
 */

class Book {
    private final String isbn;
    private final String title;
    private final String author;

    Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Book[ISBN=%s, Title=%s, Author=%s]", isbn, title, author);
    }

    public String getIsbn() {
        return isbn;
    }
}

class BookCopy {
    private final String copyId;
    private final Book book;
    private boolean isAvailable;

    BookCopy(String copyId, Book book) {
        this.copyId = copyId;
        this.book = book;
        this.isAvailable = true;
    }

    public Book getBook() {
        return book;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getCopyId() {
        return copyId;
    }

    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            throw new IllegalStateException("Book copy is already borrowed.");
        }
    }

    public void returnCopy() {
        if (!isAvailable) {
            isAvailable = true;
        } else {
            throw new IllegalStateException("Book copy is not currently borrowed.");
        }
    }

    @Override
    public String toString() {
        return String.format("BookCopy[CopyID=%s, Book=%s, Available=%s]", copyId, book, isAvailable);
    }
}

class Member {
    private final String memberId;
    private final String name;
    private int limit;

    Member(String memberId, String name, int limit) {
        this.memberId = memberId;
        this.name = name;
        this.limit = limit;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int newLimit) {
        this.limit = newLimit;
    }

    @Override
    public String toString() {
        return String.format("Member[MemberID=%s, Name=%s, Limit=%d]", memberId, name, limit);
    }
}

class Loan {
    private final Member member;
    private final BookCopy bookCopy;
    private final String loanId;
    private final LocalDate issueDate;
    private LocalDate returnDate;

    Loan(Member member, BookCopy bookCopy) {
        this.member = member;
        this.bookCopy = bookCopy;
        this.loanId = "LOAN-" + System.currentTimeMillis();
        this.issueDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("Loan[Member=%s, BookCopy=%s, LoanID=%s, IssueDate=%s]", member, bookCopy, loanId, issueDate);
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void closeLoan() {
        returnDate = LocalDate.now();
    }

    public Member getMember() {
        return member;
    }
}

class Library {
    private final Map<String, Book> booksByIsbn;
    private final Map<String, BookCopy> copiesById;
    private final Map<String, Member> membersById;
    private final Map<String, Loan> activeLoansByCopyId;

    Library() {
        this.booksByIsbn = new HashMap<>();
        this.copiesById = new HashMap<>();
        this.membersById = new HashMap<>();
        this.activeLoansByCopyId = new HashMap<>();
    }

    public Book searchBookByIsbn(String isbn) {
        return booksByIsbn.get(isbn);
    }

    public BookCopy searchAvailableCopyByIsbn(String isbn) {
        for (BookCopy copy : copiesById.values()) {
            if (copy.getBook().getIsbn().equals(isbn) && copy.isAvailable()) {
                return copy;
            }
        }
        return null; // No available copy found
    }



    public void addBook(Book book) {
        booksByIsbn.put(book.getIsbn(), book);
    }

    public void addBookCopy(BookCopy copy) {
        copiesById.put(copy.getCopyId(), copy);
    }
    
    public void addMember(Member member) {
        membersById.put(member.getMemberId(), member);
    }

    public void borrowBookCopy(String memberId, String copyId) {
        Member member = membersById.get(memberId);
        BookCopy copy = copiesById.get(copyId);
        if (member == null || copy == null) {
            throw new IllegalArgumentException("Invalid member ID or copy ID.");
        }
        if (!copy.isAvailable()) {
            throw new IllegalStateException("Book copy is not available for borrowing.");
        }
        if(member.getLimit() == 0) {
            throw new IllegalStateException("Member has reached the borrowing limit.");
        }
        copy.borrow();
        Loan loan = new Loan(member, copy);
        activeLoansByCopyId.put(copyId, loan);
        member.setLimit(member.getLimit() - 1); // Decrease the member's borrowing limit
    }

    public void returnBookCopy(String copyId) {
        Loan loan = activeLoansByCopyId.get(copyId);
        if (loan == null) {
            throw new IllegalArgumentException("No active loan found for the given copy ID.");
        }
        Member member = loan.getMember();

        loan.getBookCopy().returnCopy();
        loan.closeLoan();
        activeLoansByCopyId.remove(copyId);
        if (member != null) {
            member.setLimit(member.getLimit() + 1); 
        }

    }

}

public class LibraryManagementSolution {
    public static void main(String[] args) {
        System.out.println("--- Library Management Solution ---");

        // TODO:
        // 1. Add books and copies.
        // 2. Add members.
        // 3. Search books.
        // 4. Borrow an available copy.
        // 5. Return a borrowed copy.
        // 6. Try edge cases.

        Library library = new Library();
        Book book1 = new Book("ISBN-001", "The Great Gatsby", "F. Scott Fitzgerald");
        BookCopy copy1 = new BookCopy("COPY-001", book1);
        Member member1 = new Member("MEMBER-001", "Alice", 5); // Limit of 3 books
        library.addBook(book1);
        library.addBookCopy(copy1);
        library.addMember(member1);

        library.borrowBookCopy("MEMBER-001", "COPY-001");
        library.returnBookCopy("COPY-001");

        System.out.println("Build your Library Management solution here.");
    }
}
