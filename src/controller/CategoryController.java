package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class CategoryController {


      @FXML
    private AnchorPane root;

    @FXML
    private Button btnBack;


    
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
         System.out.println("Customer button clicked");
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Main.fxml"));
        this.root.getChildren().add(node);


    }


}
