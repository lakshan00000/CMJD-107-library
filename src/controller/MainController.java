package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
          System.out.println("Books button clicked");
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Books.fxml"));
        this.root.getChildren().add(node);

    }

    @FXML
    void btnCategoryOnAction(ActionEvent event) throws IOException {
        System.out.println("Category button clicked");
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Category.fxml"));
        this.root.getChildren().add(node);


    }

    @FXML
    void btnMemberOnAction(ActionEvent event) throws IOException {
        System.out.println("Member button clicked");
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Member.fxml"));
        this.root.getChildren().add(node);


    }

    @FXML
    void btnTransactionOnAction(ActionEvent event) throws IOException {
         
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Transaction.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setTitle("Transaction Form");

    }


}
