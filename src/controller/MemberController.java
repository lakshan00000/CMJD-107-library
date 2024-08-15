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
         System.out.println("Customer button clicked");
        this.root.getChildren().clear();
        Parent node = FXMLLoader.load(this.getClass().getResource("/view/Main.fxml"));
        this.root.getChildren().add(node);


    }

    @FXML
    private TableView<?> tblMember;


    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colAge;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

   
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





    private MemberService memberService = (MemberService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.Member);

    public MemberDto getMember(String member_id) throws Exception{

        return memberService.get(member_id);

    }


    
     public void initialize() throws ClassNotFoundException, SQLException {
        colID.setCellValueFactory(new PropertyValueFactory<>("member_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("addres"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        
        getAllMember();



     }
     public void getAllMember(){
        try {
            ArrayList<MemberDto> memberList = MemberController.getAll();
            ObservableList<MemberDto> memberDtoList = FXCollections.observableArrayList(memberList);
            tblMember.setItems(memberDtoList);
            System.out.println(memberDtoList);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error loading books: " + e.getMessage()).show();
        }

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
            String save = MemberController.save(dto);
            System.out.println("Save response: " + save);
            new Alert(Alert.AlertType.CONFIRMATION,"Customer save successfuly!!!").show();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,"Invalid number format: " + e.getMessage()).show();
        } catch (Exception e) {
            System.out.println("Error saving book: " + e.getMessage());
            new Alert(Alert.AlertType.ERROR,"Error saving book: " + e.getMessage() ).show();
        }

       
        System.out.println("MemberID : "+txtID.getText());
        System.out.println("Name : "+txtName.getText());
        System.out.println("Address : "+txtAddress.getText());
        System.out.println("Age : "+txtAge.getText());
        System.out.println("Contact : "+txtContact.getText());
       
        getAllMember();

 
    }



    private static String save(MemberDto dto) throws Exception {
        return MemberService.save(memberDto);

}

public static ArrayList<MemberDto>getAll() throws Exception{
    return MemberService.getAll() ;
}
  
    public MemberDto get(String member_id) throws Exception{
        return MemberService.get(member_id);
    }
}
