/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author laksh
 */
public class BooksDto {
    private String book_id;
    private String title;
    private String author;
    private String isbn;
    private String category_id;
    private Boolean available;
    private Integer book_count;

   
   



    public BooksDto(String book_id, String title, String author, String isbn, String category_id, Boolean available,
            Integer book_count) {
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







    public void setAvailable(Boolean available) {
        this.available = available;
    }







    public Integer getBook_count() {
        return book_count;
    }







    public void setBook_count(Integer book_count) {
        this.book_count = book_count;
    }







    /**
     * @return the book_id
     */
    public String getBook_id() {
        return book_id;
    }

    /**
     * @param book_id the book_id to set
     */
    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the catagory_id
     */
    public String getCategory_id() {
        return category_id;
    }

    /**
     * @param category_id the catagory_id to set
     */
    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }
    
   
    @Override
    public String toString() {
        return "BooksDto{" +
                "bookId='" + book_id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", categoryId='" + category_id + '\'' +
                ", available=" + available +
                ", bookCount=" + book_count +
                '}';
    }
}
