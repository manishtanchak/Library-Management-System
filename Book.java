public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private Boolean isBorrowed ;

    public Book ( String isbn , String title , String author , int publicationYear  ){
        this.isbn = isbn ;
        this.title = title;
        this.author = author ;
        this.publicationYear = publicationYear;
        this.isBorrowed = false ;
    }

    public String getIsbn(){
        return isbn ;
    }

    public String getTitle(){
        return title ;
    }

    public String getAuthor(){
        return author ;
    }

    public int getPublicationYear (){
        return publicationYear ;
    }

    public boolean isBorrowed(){
        return isBorrowed;
    }

    public void borrowBook(){
        if( !isBorrowed ){
            isBorrowed = true ;
        }else {
            throw new IllegalStateException("Book is already  Borrowed");
        }
    }

    public void returnBook(){
        if(isBorrowed){
            isBorrowed = false ;
        }else{
            throw new IllegalStateException("Book is Not Borrowed.");
        }
    }
}

