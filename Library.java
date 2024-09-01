import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String , Book> books = new HashMap<>() ;

    public void addBook( Book book ){

        if( book.getIsbn() == null){
            throw new IllegalArgumentException("ISBN can't be null");
        }
        if( books.containsKey(book.getIsbn())){
            throw new IllegalArgumentException("Book with this ISBN already exists.");
        }
        books.put(book.getIsbn(), book);
    }

    public void borrowBook(String isbn){
        Book book = books.get(isbn);

        if( book == null){
            throw new IllegalStateException("Book Not Found.");
        }
        if( book.isBorrowed()){
            throw new IllegalStateException("Book is already Borrowed");
        }
        book.borrowBook();
    }

    public Map<String,Book> viewAvailableBooks(){
        Map<String , Book> availableBook = new HashMap<>() ;

        for ( Map.Entry<String , Book> entry : books.entrySet()){
            if( !entry.getValue().isBorrowed()){
                availableBook.put(entry.getKey() , entry.getValue());
            }
        }
        return availableBook ;
    }

}
