/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectinterfaces.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.ws.rs.InternalServerErrorException;
import projectinterfaces.logic.CustomerRESTClient;
import projectinterfaces.model.Customer;

/**
 *
 * @author miguel
 */
public class MovementController {
    @FXML
    private Button btNewMovement;
    @FXML
    private Button btUndo;
    @FXML
    private Button btCancel;
    @FXML
    private TableView tbMovement;
    @FXML
    private TableColumn tbColDate;
    @FXML
    private TableColumn tbColAmount;
    @FXML
    private TableColumn tbColType;
    @FXML
    private TableColumn tbColBalance;
    @FXML
    private SplitMenuButton selectAccount;
    @FXML
    private DatePicker datePickDesde;
    @FXML
    private DatePicker datePickHasta;
    
    private Customer customer;
    private Stage stage;
    CustomerRESTClient restClient = new CustomerRESTClient();
    
    public void init(Stage stage, Parent root) {
        
        this.stage=stage;
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.setTitle("Movements");
        stage.setResizable(false);
        
        //stage.setOnCloseRequest();
        
        btNewMovement.setDisable(false);
        btUndo.setDisable(false);
        btCancel.setDisable(false);

        btNewMovement.setOnAction(this::handlebtNewMovementOnAction);
        btUndo.setOnAction(this::handlebtUndoOnAction);
        btCancel.setOnAction(this::handlebtCancelOnAction);
        
        tbColDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tbColAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        tbColType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        tbColBalance.setCellValueFactory(new PropertyValueFactory<>("Balance"));
        tbMovement.getSelectionModel().selectedItemProperty().addListener(this::handleMovementTableSelectionChanged);
        
        try{
            List<Customer> userData = new ArrayList<>();
            userData = FXCollections.observableArrayList(restClient.findAll_XML(userData.getClass()));
            
            tbMovement.setItems((ObservableList) userData);
            
        }catch(Exception e){
            
        }
        
        stage.show();
        
        
    }
    
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    private void handleMovementTableSelectionChanged(ObservableValue observable, Object odlValue, Object newValue){
        
    }
    
    //BOTONES
    /**
     * 
     * @param event 
     */
    private void handlebtCancelOnAction(ActionEvent event){
        try{
            
            new Alert(AlertType.INFORMATION,"Are you sure you want to leave?").showAndWait();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProyectoSignIn.fxml"));
            Parent root = (Parent)loader.load();
            //AccountController controller = loader.getController();
            //controller.init(this.stage, root);
            
        }
        catch(InternalServerErrorException e){
            new Alert(AlertType.INFORMATION,"Internal server error, please wait or contact your service provider").showAndWait();
            
        }catch(IOException e){
            new Alert(AlertType.INFORMATION,e.getLocalizedMessage()).showAndWait();
            
        }
    }
    
    private void handlebtUndoOnAction(ActionEvent event){
        
    }
    
    private void handlebtNewMovementOnAction(ActionEvent event){
        
    }
    
    
}
