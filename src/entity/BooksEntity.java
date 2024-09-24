package entity;

public class BooksEntity {
    private String book_id;
    private String title;
    private String author;
    private String isbn;
    private String category_id;
    private Boolean available;
    private Integer book_count;

    

    public BooksEntity(String book_id, String title, String author, String isbn, String category_id, Boolean available, Integer book_count) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category_id = category_id;
        this.available = available;
        this.book_count = book_count;
   }

   

    public Boolean getAvailable() {
        return available;
    }

    public void setAvilable(Boolean available) {
        this.available = available;
    }

    public Integer getBook_count() {
        return book_count;
    }

    public void setBook_count(Integer book_count) {
        this.book_count = book_count;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "BooksEntity [book_id=" + book_id + ", title=" + title + ", author=" + author + ", isbn=" + isbn
                + ", category_id=" + category_id + ", avilable=" + available + ", book_count=" + book_count + "]";
    }


  

   
}
