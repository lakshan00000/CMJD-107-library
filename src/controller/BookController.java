package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BookController {
    
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
        System.out.println("BookID : "+txtTitle.getText());
        System.out.println("BookID : "+txtAuthor.getText());
        System.out.println("BookID : "+txtIsbn.getText());
        System.out.println("BookID : "+txtCategoryId.getText());
        System.out.println("BookID : "+txtAvailable.getText());
        System.out.println("BookID : "+txtBookcount.getText());


    }
}
