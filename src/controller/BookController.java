package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BooksDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class BookController  {

     @FXML
    private AnchorPane root;

    @FXML
    private Button btnBack;


    @FXML
    private TableView<BooksDto> tblBooks;

    
    @FXML
    private TableColumn<BooksDto, String> colAuthor;

    @FXML
    private TableColumn<BooksDto, Boolean> colAvailable;

    @FXML
    private TableColumn<BooksDto, String> colCId;

    @FXML
    private TableColumn<BooksDto, Integer> colCount;

    @FXML
    private TableColumn<BooksDto, String> colId;

    @FXML
    private TableColumn<BooksDto, String> colIsbn;

    @FXML
    private TableColumn<BooksDto, String> colTitle;

       @FXML
    private Button btnReload;

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


     public void initialize() throws ClassNotFoundException, SQLException {
        colId.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colCId.setCellValueFactory(new PropertyValueFactory<>("category_id"));
        colAvailable.setCellValueFactory(new PropertyValueFactory<>("available"));
        colCount.setCellValueFactory(new PropertyValueFactory<>("book_count"));

        getAllBooks();



     }
     public void getAllBooks(){
        try {
            ArrayList<BooksDto> booksList = BooksController.getAll();
            ObservableList<BooksDto> booksDtoList = FXCollections.observableArrayList(booksList);
            tblBooks.setItems(booksDtoList);
            System.out.println(booksDtoList);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error loading books: " + e.getMessage()).show();
        }

     }


    @FXML
    void btnReloadOnAction(ActionEvent event) throws Exception {

      getAllBooks();
    }

    

    

    @FXML
    void btnSaveOnAction(ActionEvent event) {
       
       
        try {
            String book_id = txtBookId.getText();
            String title = txtTitle.getText();
            String author = txtAuthor.getText();
            String isbn = txtIsbn.getText();
            String category_id = txtCategoryId.getText();
            Boolean available = Boolean.parseBoolean(txtAvailable.getText());
            Integer book_count = Integer.parseInt(txtBookcount.getText());
    
            BooksDto dto = new BooksDto(book_id, title, author, isbn, category_id, available, book_count);
            String save = BooksController.save(dto);
            System.out.println("Save response: " + save);
            new Alert(Alert.AlertType.CONFIRMATION,"Customer save successfuly!!!").show();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,"Invalid number format: " + e.getMessage()).show();
        } catch (Exception e) {
            System.out.println("Error saving book: " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,"Error saving book: " + e.getMessage() ).show();
        }

       
        System.out.println("BookID : "+txtBookId.getText());
        System.out.println("Title : "+txtTitle.getText());
        System.out.println("Author : "+txtAuthor.getText());
        System.out.println("Isbn : "+txtIsbn.getText());
        System.out.println("CategoryID : "+txtCategoryId.getText());
        System.out.println("Available : "+txtAvailable.getText());
        System.out.println("Bookcount : "+txtBookcount.getText());

        getAllBooks();

 
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
         System.out.println("Customer button clicked");
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Main.fxml"));
        this.root.getChildren().add(node);


    }
}
