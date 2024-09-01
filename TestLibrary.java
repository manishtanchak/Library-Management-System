import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestLibrary {
    private Library library = new Library();

    
    @Test 
    public void testAddBook(){
        // new Book
        Book book = new Book("101" , "Clean Code: A Handbook of Agile Software Craftsmanship" , "Robert C. Martin" , 2008);

        // Act
        library.addBook(book);

        // Assert
        assertEquals(1, library.viewAvailableBooks().size());
        assertTrue(library.viewAvailableBooks().containsValue(book));
    }

    @Test 
    public void testAddDuplicateBook(){
        // Two dublicateBook
        Book book1 = new Book("101", "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", 2014);
        Book book2 = new Book("101", "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", 2015);

        // Act 
        library.addBook(book1);
        Exception exception = assertThrows(IllegalArgumentException.class , () ->{
            library.addBook(book2);
        });
        String expectedMessage = "Book with this ISBN already exists." ;
        String actualMessage = exception.getMessage() ;

        // Assert 
        assertEquals( actualMessage, expectedMessage);
    }

    @Test 
    public void testAddBookWithNullIsbn(){
        // Book with Null ISBN
        Book book = new Book( null , "Test Driven Development: By Example" , "Kent Beck" , 2002);

        // Act 
        Exception exception = assertThrows( IllegalArgumentException.class, () -> {
            library.addBook(book);
        });
        String expectedMessage = "ISBN can't be null" ;
        String acturalMessage = exception.getMessage();

        // Assert
        assertEquals(expectedMessage, acturalMessage);
    }

    @Test 
    public void testBorrowBookSuccessfully(){
        // A Book 
        Book book = new Book("101", "Software Craftsman", "Sundro Mancuso",2014);
        library.addBook(book);

        // Act 
        library.borrowBook("101");

        // Assert 
        assertEquals(0, library.viewAvailableBooks().size());
        assertTrue(book.isBorrowed());
    }

    @Test 
    public void testBorrowBookNotFound(){
        // Act 
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            library.borrowBook("101");
        });

        String expectedMessage = "Book Not Found.";
        String actualMessage = exception.getMessage();

        // Assert
        assertEquals(expectedMessage, actualMessage);
    }


    @Test 
    public void testBorrowAlreadyBorrowed(){
        // Book Already Borrowed ..
        Book book = new Book("101", "The Pragmatic Programmer", "David Thomas & Andrew Hunt", 2019);
        library.addBook(book);
        library.borrowBook("101");

        // Act 
        Exception exception = assertThrows(IllegalStateException.class, ()->{
            library.borrowBook("101");
        });
        String expectedMessage = "Book is already Borrowed" ;
        String actualMessage = exception.getMessage();

        // Assert 
        assertEquals(expectedMessage, actualMessage);
    }

    
    @Test
    public void testReturnSuccessfully(){
        // Book 
        Book book = new Book("101", "How Google Tests Software", "James Whittaker & Jason Arbon & Jeff Carollo", 2012);
        library.addBook(book);
        library.borrowBook("101");

        // Act
        library.returnBook("101");

        // Assert 
        assertEquals(1, library.viewAvailableBooks().size());
        assertFalse(book.isBorrowed());
    } 

    @Test
    public void testReturnBookNotFound(){
        // Act
        Exception exception = assertThrows(IllegalStateException.class , ()->{
            library.returnBook("101");     
        });
        String expectedMessage = "Book Not Found." ;
        String actualMessage = exception.getMessage();
        
        // Assert 
        assertEquals(expectedMessage, actualMessage);
    }

    @Test 
    public void testReturnBookNotBorrowed(){
        // Book 
        Book book = new Book("101", "Clean Agile: Back to Basics", "Robert Martin", 2019);
        library.addBook(book);

        // Act
        Exception exception = assertThrows(IllegalStateException.class , () -> {
            library.returnBook("101");
        });
        String expectedMessage = "Book is not borrowed." ;
        String actualMessage = exception.getMessage();

        // Assert
        assertEquals(expectedMessage, actualMessage);
    }
}
