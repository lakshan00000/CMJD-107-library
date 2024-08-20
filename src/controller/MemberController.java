package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BooksDto;
import dto.MemberDto;
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
import service.custom.MemberService;

public class MemberController {


        @FXML
    private AnchorPane root;

    @FXML
    private Button btnBack;


    
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
         System.out.println("Back button clicked");
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Main.fxml"));
        this.root.getChildren().add(node);


    }

    @FXML
    private TableView<MemberDto> tblMember;


    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnReload;

    @FXML
    private TableColumn<MemberDto, String> colAddress;

    @FXML
    private TableColumn<MemberDto, Integer> colAge;

    @FXML
    private TableColumn<MemberDto, String> colContact;

    @FXML
    private TableColumn<MemberDto, String> colID;

    @FXML
    private TableColumn<MemberDto, String> colName;

   
    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

   







   private static MemberService memberService = (MemberService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.Member);

    public MemberDto getMember(String member_id) throws Exception{

        return memberService.get(member_id);

    }


    
     public void initialize() throws ClassNotFoundException, SQLException {
        colID.setCellValueFactory(new PropertyValueFactory<>("member_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        
        getAllMember();

        tblMember.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateTextFields(newSelection);
            }
        });



     }
     public void getAllMember(){
        try {
            ArrayList<MemberDto> memberList = memberService.getAll();
            ObservableList<MemberDto> memberDtoList = FXCollections.observableArrayList(memberList);
            tblMember.setItems(memberDtoList);
            System.out.println(memberDtoList);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error loading Member: " + e.getMessage()).show();
        }

     }

     private void populateTextFields(MemberDto selectedMember) {
        txtID.setText(selectedMember.getMember_id());
        txtName.setText(selectedMember.getName());
        txtAddress.setText(selectedMember.getAddress());
        txtContact.setText(selectedMember.getContact());
        txtAge.setText(String.valueOf(selectedMember.getAge()));
       
    }
    
    private void clearTextFields() {
        txtID.clear();
        txtName.clear();
        txtAddress.clear();
        txtAge.clear();
        txtContact.clear();
        
    }


    @FXML
    void btnReloadOnAction(ActionEvent event) throws Exception {

      getAllMember();
    }



     @FXML
    void btnSaveOnAction(ActionEvent event) {
       
       
        try {
            String member_id = txtID.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            Integer age = Integer.parseInt(txtAge.getText());
            String contact = txtContact.getText();
           
            MemberDto dto = new MemberDto(member_id, name, address, age, contact );
            String save = memberService.save(dto);
            System.out.println("Save response: " + save);
            new Alert(Alert.AlertType.CONFIRMATION,"Member save successfuly!!!").show();
            getAllMember();
            clearTextFields();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,"Invalid number format: " + e.getMessage()).show();
        } catch (Exception e) {
            System.out.println("Error saving Member: " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,"Error saving Member: " + e.getMessage() ).show();
        }

       
        System.out.println("MemberID : "+txtID.getText());
        System.out.println("Name : "+txtName.getText());
        System.out.println("Address : "+txtAddress.getText());
        System.out.println("Age : "+txtAge.getText());
        System.out.println("Contact : "+txtContact.getText());
       
      

 
    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        MemberDto selectedMember = tblMember.getSelectionModel().getSelectedItem(); 
        
    
       
        if (selectedMember != null) {
           
                    try {
                        
                    
                                 
                      

                        
                        String result = memberService.delete(selectedMember.getMember_id());
            
                        if ("Success".equals(result)) {
                            new Alert(Alert.AlertType.CONFIRMATION, "Member deleted successfully!").show();
                            getAllMember(); 
                            clearTextFields();
                         } else{
                            new Alert(Alert.AlertType.ERROR, "Failed to delete the member.").show();
                        }
                    } catch (Exception e) {
                        new Alert(Alert.AlertType.ERROR, "Error deleting member: " + e.getMessage()).show();
                        System.out.println("Error Deleting member: " + e.getMessage());
                
                
                    }
        } else {
            new Alert(Alert.AlertType.WARNING, "No member selected!").show();
        }
    }
       
      

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        try {
            MemberDto dto = new MemberDto(
                txtID.getText(),
                txtName.getText(),
                txtAddress.getText(),
                Integer.parseInt(txtAge.getText()),
                txtContact.getText()
            );
            String update = memberService.update(dto);
            if (update != null) {
                new Alert(Alert.AlertType.CONFIRMATION, "Member updated successfully!").show();
                getAllMember();
                clearTextFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to update the member.").show();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Invalid number format: " + e.getMessage()).show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error updating member: " + e.getMessage()).show();
            System.out.println("Error updating member: " + e.getMessage());
        }
       
    }



}
