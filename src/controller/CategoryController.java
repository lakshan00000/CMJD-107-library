package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import dto.CategoryDto;
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
import service.ServiceFactory;
import service.custom.CategoryService;

public class CategoryController {


      @FXML
    private AnchorPane root;

    @FXML
    private Button btnBack;

      @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;


     @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

   
    @FXML
    private TableView<CategoryDto> tblCategory;



     private static CategoryService categoryService = (CategoryService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.Category);

    public CategoryDto getCategory(String category_id) throws Exception{

        return categoryService.get(category_id);

    }


    
     public void initialize() throws ClassNotFoundException, SQLException {
        colID.setCellValueFactory(new PropertyValueFactory<>("category_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
       
        
        getAllCategory();

        tblCategory.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateTextFields(newSelection);
            }
        });



     }
     public void getAllCategory(){
        try {
            ArrayList<CategoryDto> categoryList = categoryService.getAll();
            ObservableList<CategoryDto> categoryDtoList = FXCollections.observableArrayList(categoryList);
            tblCategory.setItems(categoryDtoList);
            System.out.println(categoryDtoList);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error loading Category: " + e.getMessage()).show();
        }

     }

     private void populateTextFields(CategoryDto selectedCategory) {
        txtID.setText(selectedCategory.getCategory_id());
        txtName.setText(selectedCategory.getName());
        txtDescription.setText(selectedCategory.getDescription());
       
       
    }
    
    private void clearTextFields() {
        txtID.clear();
        txtName.clear();
        txtDescription.clear();
       
        
    }

   

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

      CategoryDto selectedCategory = tblCategory.getSelectionModel().getSelectedItem(); 
        
    
       
      if (selectedCategory != null) {
         
                  try {
                      
                  
                               
                    

                      
                      String result = categoryService.delete(selectedCategory.getCategory_id());
          
                      if ("Success".equals(result)) {
                          new Alert(Alert.AlertType.CONFIRMATION, "Category deleted successfully!").show();
                          getAllCategory(); 
                          clearTextFields();
                       } else{
                          new Alert(Alert.AlertType.ERROR, "Failed to delete the category.").show();
                      }
                  } catch (Exception e) {
                      new Alert(Alert.AlertType.ERROR, "Error deleting category: " + e.getMessage()).show();
                      System.out.println("Error Deleting category: " + e.getMessage());
              
              
                  }
      } else {
          new Alert(Alert.AlertType.WARNING, "No category selected!").show();
      }

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        try {
            String category_id = txtID.getText();
            String name = txtName.getText();
            String description = txtDescription.getText();
           
           
            CategoryDto dto = new CategoryDto(category_id, name, description );
            String save = categoryService.save(dto);
            System.out.println("Save response: " + save);
            new Alert(Alert.AlertType.CONFIRMATION,"Category save successfuly!!!").show();
            getAllCategory();
            clearTextFields();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,"Invalid number format: " + e.getMessage()).show();
        } catch (Exception e) {
            System.out.println("Error saving Category: " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,"Error saving Category: " + e.getMessage() ).show();
        }

       
        System.out.println("CategoryID : "+txtID.getText());
        System.out.println("Name : "+txtName.getText());
        System.out.println("Description : "+txtDescription.getText());
       

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

      try {
        CategoryDto dto = new CategoryDto(
            txtID.getText(),
            txtName.getText(),
            txtDescription.getText()
        );
        String update = categoryService.update(dto);
        if (update != null) {
            new Alert(Alert.AlertType.CONFIRMATION, "Category updated successfully!").show();
            getAllCategory();
            clearTextFields();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to update the category.").show();
        }
    } catch (NumberFormatException e) {
        new Alert(Alert.AlertType.ERROR, "Invalid number format: " + e.getMessage()).show();
    } catch (Exception e) {
        new Alert(Alert.AlertType.ERROR, "Error updating category: " + e.getMessage()).show();
        System.out.println("Error updating category: " + e.getMessage());
    }
   
}

    


    
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
         System.out.println("Back button clicked");
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Main.fxml"));
        this.root.getChildren().add(node);


    }


}
