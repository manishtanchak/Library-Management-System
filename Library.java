import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String , Book> books = new HashMap<>() ;

    public void addBook( Book book ){
        books.put(book.getIsbn(), book);
    }
    
}
