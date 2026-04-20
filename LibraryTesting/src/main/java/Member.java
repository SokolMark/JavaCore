public class Member {
    private String name;
    private int borrowedBooksCount = 0;
    private static final int MAX_BOOKS_LIMIT = 3; // Limit 3 books per person

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBorrowedBooksCount() {
        return borrowedBooksCount;
    }

    public void borrowBook() {
        if (borrowedBooksCount >= MAX_BOOKS_LIMIT) {
            throw new IllegalStateException("Limit exhausted. Maximum 3 books.");
        }
        borrowedBooksCount++;
    }

    public void returnBook() {
        if (borrowedBooksCount > 0) {
            borrowedBooksCount--;
        }
    }
}