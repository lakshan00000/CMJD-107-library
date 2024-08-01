package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class MainController {
     @FXML
    private JFXButton btnBooks;

    @FXML
    private JFXButton btnCategory;

    @FXML
    private JFXButton btnMember;

    @FXML
    private JFXButton btnTransaction;

    @FXML
    private AnchorPane root;

    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
          System.out.println("Customer button clicked");
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Books.fxml"));
        this.root.getChildren().add(node);

    }

    @FXML
    void btnCategoryOnAction(ActionEvent event) {

    }

    @FXML
    void btnMemberOnAction(ActionEvent event) throws IOException {
        System.out.println("Customer button clicked");
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Member.fxml"));
        this.root.getChildren().add(node);


    }

    @FXML
    void btnTransactionOnAction(ActionEvent event) {

    }


}
