import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Testing {

    @Test
    void bookConditionTest() {
        Book book = new Book("221", "title", "author");
        assertTrue(book.isAvailable());
    }

    @Test
    void memberLimitTest() {
        Member member = new Member("name");

        assertThrows(IllegalStateException.class, () -> {
            member.borrowBook();
            member.borrowBook();
            member.borrowBook();
            member.borrowBook();
        });
    }

    @Test
    void addBookTest() {
        LibraryService libraryService = new LibraryService();
        Book book = new Book("221", "title", "author");

        libraryService.addBook(book);

        Book foundBook = libraryService.findBookByIsbn(book.getIsbn());

        assertEquals(book, foundBook);
        assertNotNull(foundBook);
    }

    @Test
    void borrowBookTest() {
        LibraryService libraryService = new LibraryService();
        Book book = new Book("221", "title", "author");
        Member member = new Member("name");
        libraryService.addBook(book);
        libraryService.borrowBook(member, book.getIsbn());

        assertAll(() -> assertEquals(1, member.getBorrowedBooksCount()),
                () -> assertFalse(book.isAvailable()));
    }

    @Test
    void borrowBusyBookTest() {
        Book book = new Book("221", "title", "author");
        LibraryService libraryService = new LibraryService();
        Member member = new Member("name");

        libraryService.addBook(book);
        libraryService.borrowBook(member, book.getIsbn());

        Member member2 = new Member("name");

        assertThrows(IllegalStateException.class, () -> {
            libraryService.borrowBook(member2, book.getIsbn());
        });
    }

    @Test
    void isbndoesnotexistTest() {
        LibraryService libraryService = new LibraryService();
        Book book = new Book("221", "title", "author");
        Member member = new Member("name");

        libraryService.addBook(book);

        assertThrows(IllegalArgumentException.class, () -> {
            libraryService.borrowBook(member, "3213");
        });
    }

    @Test
    void lifeCycleOfBookTest() {
        LibraryService libraryService = new LibraryService();
        Book book = new Book("221", "title", "author");
        Member member = new Member("name");
        libraryService.addBook(book);
        libraryService.borrowBook(member, book.getIsbn());

        assertEquals(1, member.getBorrowedBooksCount());

        libraryService.returnBook(member, book.getIsbn());

        assertEquals(0, member.getBorrowedBooksCount());
    }
}
