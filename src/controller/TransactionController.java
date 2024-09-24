package controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.jfoenix.controls.JFXButton;

import dto.TransactionDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import service.ServiceFactory;
import service.custom.TransactionService;

public class TransactionController {
  
    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableView<TransactionDto> tblTransaction;


    @FXML
    private TableColumn<TransactionDto, Date> colBDate;

    @FXML
    private TableColumn<TransactionDto, String> colBID;

    @FXML
    private TableColumn<TransactionDto, Date> colDDate;

    @FXML
    private TableColumn<TransactionDto, BigDecimal> colFine;

    @FXML
    private TableColumn<TransactionDto, String> colMID;

    @FXML
    private TableColumn<TransactionDto, Date> colRDate;

    @FXML
    private TableColumn<TransactionDto, Integer> colTID;

    @FXML
    private Label lblBDate;

    @FXML
    private Label lblBID;

    @FXML
    private Label lblDDate;

    @FXML
    private Label lblFine;

    @FXML
    private Label lblMID;

    @FXML
    private Label lblRDate;

    @FXML
    private Label lblTID;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtBDate;

    @FXML
    private TextField txtBID;

    @FXML
    private TextField txtDDate;

    @FXML
    private TextField txtFine;

    @FXML
    private TextField txtMID;

    @FXML
    private TextField txtRDate;

    @FXML
    private TextField txtTID;


 private static TransactionService transactionService = (TransactionService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.Transaction);

    public TransactionDto getTransaction(Integer transaction_id) throws Exception{

        return transactionService.get(transaction_id);

    }


    
     public void initialize() throws ClassNotFoundException, SQLException {
        colTID.setCellValueFactory(new PropertyValueFactory<>("transaction_id"));
        colBID.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        colMID.setCellValueFactory(new PropertyValueFactory<>("member_id"));
        colBDate.setCellValueFactory(new PropertyValueFactory<>("borrow_date"));
        colDDate.setCellValueFactory(new PropertyValueFactory<>("due_date"));
        colRDate.setCellValueFactory(new PropertyValueFactory<>("return_date"));
        colFine.setCellValueFactory(new PropertyValueFactory<>("fine"));
        
        getAllTransaction();

        tblTransaction.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateTextFields(newSelection);
            }
        });



     }
     public void getAllTransaction(){
        try {
            ArrayList<TransactionDto> transactionList = transactionService.getAll();
            ObservableList<TransactionDto> transactionDtoList = FXCollections.observableArrayList(transactionList);
            tblTransaction.setItems(transactionDtoList);
            System.out.println(transactionDtoList);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error loading Transaction: " + e.getMessage()).show();
        }

     }

     private void populateTextFields(TransactionDto selectedTransaction) {
        txtTID.setText(String.valueOf(selectedTransaction.getTransaction_id()));
        txtBID.setText(selectedTransaction.getBook_id());
        txtMID.setText(selectedTransaction.getMember_id());
        txtBDate.setText(String.valueOf(selectedTransaction.getBorrow_date()));
        txtDDate.setText(String.valueOf(selectedTransaction.getDue_date()));
        txtRDate.setText(String.valueOf(selectedTransaction.getReturn_date()));
        txtFine.setText(String.valueOf(selectedTransaction.getFine()));
       
    }
    
    private void clearTextFields() {
        txtTID.clear();
        txtBID.clear();
        txtMID.clear();
        txtBDate.clear();
        txtDDate.clear();
        txtRDate.clear();
        txtFine.clear();
    }






    @FXML
    void btnDeleteOnAction(ActionEvent event) {
         TransactionDto selectedTransaction = tblTransaction.getSelectionModel().getSelectedItem(); 
        
    
       
        if (selectedTransaction != null) {
           
                    try {
                        
                    
                     String result = transactionService.delete(selectedTransaction.getTransaction_id());
            
                        if ("Success".equals(result)) {
                            new Alert(Alert.AlertType.CONFIRMATION, "Transaction deleted successfully!").show();
                            getAllTransaction(); 
                            clearTextFields();
                         } else{
                            new Alert(Alert.AlertType.ERROR, "Failed to delete the transaction.").show();
                        }
                    } catch (Exception e) {
                        new Alert(Alert.AlertType.ERROR, "Error deleting transaction: " + e.getMessage()).show();
                        System.out.println("Error Deleting transaction: " + e.getMessage());
                
                
                    }
        } else {
            new Alert(Alert.AlertType.WARNING, "No transaction selected!").show();
        }
    }

    

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        
      try {
        Integer transaction_id = Integer.parseInt(txtTID.getText());
        String book_id = txtBID.getText();
        String member_id = txtMID.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date borrow_date = new java.sql.Date(dateFormat.parse(txtBDate.getText()).getTime());
        java.sql.Date due_date = new java.sql.Date(dateFormat.parse(txtDDate.getText()).getTime());
        java.sql.Date return_date = txtRDate.getText().isEmpty() ? null : new java.sql.Date(dateFormat.parse(txtRDate.getText()).getTime());
        BigDecimal fine = new BigDecimal(txtFine.getText());

       
        TransactionDto dto = new TransactionDto(transaction_id, book_id , member_id , borrow_date , due_date , return_date , fine);
        String save = transactionService.save(dto);
        System.out.println("Save response: " + save);
        new Alert(Alert.AlertType.CONFIRMATION,"Transaction save successfuly!!!").show();
        getAllTransaction();
        clearTextFields();
    } catch (NumberFormatException e) {
        System.out.println("Invalid number format: " + e.getMessage());
        new Alert(Alert.AlertType.ERROR,"Invalid number format: " + e.getMessage()).show();
    } catch (Exception e) {
        System.out.println("Error saving Transaction: " + e.getMessage());
        new Alert(Alert.AlertType.ERROR,"Error saving Transaction: " + e.getMessage() ).show();
    }


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        try {
            Integer transaction_id = Integer.parseInt(txtTID.getText());
            String book_id = txtBID.getText();
            String member_id = txtMID.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date borrow_date = new java.sql.Date(dateFormat.parse(txtBDate.getText()).getTime());
            java.sql.Date due_date = new java.sql.Date(dateFormat.parse(txtDDate.getText()).getTime());
            java.sql.Date return_date = txtRDate.getText().isEmpty() ? null : new java.sql.Date(dateFormat.parse(txtRDate.getText()).getTime());
            BigDecimal fine = new BigDecimal(txtFine.getText());

       
        TransactionDto dto = new TransactionDto(transaction_id, book_id , member_id , borrow_date , due_date , return_date , fine);
            String update = transactionService.update(dto);
            if (update != null) {
                new Alert(Alert.AlertType.CONFIRMATION, "Transaction updated successfully!").show();
                getAllTransaction();
                clearTextFields();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to update the transaction.").show();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Invalid number format: " + e.getMessage()).show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error updating transaction: " + e.getMessage()).show();
            System.out.println("Error updating transaction: " + e.getMessage());
        }
    }
  }


