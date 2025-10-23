/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectinterfaces.ui;

import java.util.logging.Logger;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 *
 * @author miguel
 */
public class ChangePasswordController {
    @FXML
    private Button changePass;
    @FXML
    private Button exit;
    @FXML
    private PasswordField oldPass;
    @FXML
    private PasswordField newPass;
    @FXML
    private PasswordField confirmNewPass;
    private static final Logger LOGGER = Logger.getLogger("ProjectInterfacesApplication.ui");

    public void init(Stage stage, Parent root) {
        //Establecer el titulo de la ventana
        stage.setTitle("Change Password");
        //La ventana no debe ser redimensionable
        stage.setResizable(false);
        //El botón Change Password está deshabilitado hasta que los campos estén completos.
        changePass.setDisable(true);
        //El botón Cancel está habilitado.
        exit.setDisable(false);
        //asociar eventos a manejadores
        changePass.setOnAction(this::handleChangePassOnAction);
        exit.setOnAction(this::handleExitOnAction);
        //Asiciacion de manejadores a properties
        oldPass.textProperty().addListener(this::handleOldPasstextChange);
        newPass.textProperty().addListener(this::handleNewPasstextChange);
        confirmNewPass.textProperty().addListener(this::handleConfirmNewPasstextChange);
        
        stage.show();
        
    }
    //Old Password
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleOldPasstextChange(ObservableValue observable,String oldValue,String newValue){
        
          
    }
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleOldPassFocusChange(ObservableValue observable,Boolean oldValue,Boolean newValue){
        if(oldValue){
            
        }
    }
    //New Password
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleNewPasstextChange(ObservableValue observable,String oldValue,String newValue){
        
    }
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleNewPassFocusChange(ObservableValue observable,Boolean oldValue,Boolean newValue){
        if(oldValue){
          
        }
    }
    //Conform New Password
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleConfirmNewPasstextChange(ObservableValue observable,String oldValue,String newValue){
        
    }
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleConfirmNewPassFocusChange(ObservableValue observable,Boolean oldValue,Boolean newValue){
        if(oldValue){
            
        }
    }
    //Botones
    /**
     * 
     * @param event 
     */
    private void handleChangePassOnAction(ActionEvent event){
        
    }
    /**
     * 
     * @param event 
     */
    private void handleExitOnAction(ActionEvent event){
        
    }
      
}
