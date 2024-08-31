import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestLibrary {
    private Library library = new Library();

    @Test 
    public void testAddBook(){
        Book book = new Book("101" , "Clean Code: A Handbook of Agile Software Craftsmanship" , "Robert C. Martin" , 2008)

        library.addBook(book);
    }
}
