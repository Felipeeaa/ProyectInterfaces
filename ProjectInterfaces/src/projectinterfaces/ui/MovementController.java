/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectinterfaces.ui;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
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
    private TableColumn tcDate;
    @FXML
    private TableColumn tcAmount;
    @FXML
    private TableColumn tcType;
    @FXML
    private TableColumn tcBalance;
    @FXML
    private SplitMenuButton selectAccount;
    @FXML
    private DatePicker datePick;
    
    private Customer customer;
    private Stage stage;
    
    public void init(Stage stage, Parent root) {
        
        this.stage=stage;
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        //Set the window title
        stage.setTitle("Movements");
        stage.setResizable(false);
        
        //stage.setOnCloseRequest();
        
        btNewMovement.setDisable(false);
        btUndo.setDisable(false);
        btCancel.setDisable(false);
        
     /*   btNewMovement.setOnAction(this::handlebtNewMovementOnAction);
        
        btCancel.setOnAction(this::handlebtCancelOnAction);
        
        btUndo.focusedProperty().addListener(this::handlebtUndoOnFocusChange);
        tfNewPass.focusedProperty().addListener(this::handletfNewPassOnFocusChange);
        tfConfirmNewPass.textProperty().addListener(this::handletfConfirmNewPassOnFocusChange);*/

        stage.show();
        
    }
    
}
