package controller;

import dto.BooksDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BookController  {
    
       @FXML
    private Button btnSave;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtAvailable;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBookcount;

    @FXML
    private TextField txtCategoryId;

    @FXML
    private TextField txtIsbn;

    @FXML
    private TextField txtTitle;

    

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        System.out.println("BookID : "+txtBookId.getText());
        System.out.println("Title : "+txtTitle.getText());
        System.out.println("Author : "+txtAuthor.getText());
        System.out.println("Isbn : "+txtIsbn.getText());
        System.out.println("CategoryID : "+txtCategoryId.getText());
        System.out.println("Available : "+txtAvailable.getText());
        System.out.println("Bookcount : "+txtBookcount.getText());

       
        try {
            String book_id = txtBookId.getText();
            String title = txtTitle.getText();
            String author= txtAuthor.getText();
            String isbn=txtIsbn.getText();
            String category_id=txtCategoryId.getText();
            Boolean available=Boolean.parseBoolean(txtAvailable.getText());
            Integer book_count=Integer.parseInt(txtBookcount.getText());
    
            BooksDto dto = new BooksDto( book_id,title,author,isbn,category_id,available,book_count);
             String save = BooksController.save(dto);
            
           
        } catch (Exception e) {
           System.out.println( "404 Error");
        }
       
        
 
    }
}
