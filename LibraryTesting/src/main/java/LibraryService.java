import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> catalog = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("The book cannot be null");
        }
        catalog.add(book);
    }

    public void borrowBook(Member member, String isbn) {
        Book bookToBorrow = findBookByIsbn(isbn);

        if (bookToBorrow == null) {
            throw new IllegalArgumentException("No book with such ISBN found");
        }
        if (!bookToBorrow.isAvailable()) {
            throw new IllegalStateException("This book is currently being read by someone");
        }

        member.borrowBook();
        bookToBorrow.setAvailable(false);
    }

    public void returnBook(Member member, String isbn) {
        Book bookToReturn = findBookByIsbn(isbn);

        if (bookToReturn != null && !bookToReturn.isAvailable()) {
            member.returnBook();
            bookToReturn.setAvailable(true);
        }
    }

    // Auxiliary search method
    public Book findBookByIsbn(String isbn) {
        for (Book book : catalog) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}