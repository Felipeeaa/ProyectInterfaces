/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectinterfaces.ui;

import java.util.logging.Logger;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    private Label errorLabel;
    
    private static final Logger LOGGER = Logger.getLogger("ProjectInterfacesApplication.ui");

    public void init(Stage stage, Parent root) {
        //Establecer el titulo de la ventana
        stage.setTitle("Change Password");
        //La ventana no debe ser redimensionable
        stage.setResizable(false);
        //El botón Change Password está deshabilitado hasta que los campos estén completos.
        /*changePass.setDisable(true);
        //El botón Cancel está habilitado.
        exit.setDisable(false);*/
        //asociar eventos a manejadores
        changePass.setOnAction(this::handleChangePassOnAction);
        exit.setOnAction(this::handleExitOnAction);
        //Asiciacion de manejadores a properties
        oldPass.focusedProperty().addListener(this::handleOldPassChange);
        newPass.focusedProperty().addListener(this::handleNewPasstextChange);
        confirmNewPass.focusedProperty().addListener(this::handleConfirmNewPasstextChange);
        
        stage.show();
        
    }
    //Old Password
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleOldPassChange(ObservableValue observable,Boolean oldValue,Boolean newValue){
        try{
            if(oldValue){
            String text = oldPass.getText();
        }
        }catch (Exception e){
            
        }
    }
    //New Password
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleNewPasstextChange(ObservableValue observable,Boolean oldValue,Boolean newValue){
       try{
            if(oldValue){
            String text = oldPass.getText();
        }
        }catch (Exception e){
            
        }
    }
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleNewPassFocusChange(ObservableValue observable,Boolean oldValue,Boolean newValue){
        try{
            if(oldValue){
                String pass = newPass.getText();
                boolean valid = pass.matches("!-~");
                if(oldPass.getText().equals(newPass.getText()))
                    throw new Exception ("The password is the same as the previous one");  
                if(pass.isEmpty())
                    throw new Exception ("Old Password is empty");
                if(pass.length()<5)
                    throw new Exception ("The password is too short");
                if(!valid)
                    throw new Exception ("The password format is not valid");
        }
        }catch (Exception e){
            oldPass.setStyle("-fx-border-color: red -fx-border-width: 2px;");
            errorLabel.setText(e.getMessage());
        }
    }
    //Conform New Password
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleConfirmNewPasstextChange(ObservableValue observable,Boolean oldValue,Boolean newValue){
       try{
            if(oldValue){
                if(!newPass.getText().equals(confirmNewPass.getText())){
                    throw new Exception ("The password is not the same");  
                }
            }
        }catch (Exception e){
            oldPass.setStyle("-fx-border-color: red -fx-border-width: 2px;");
            errorLabel.setText(e.getMessage());
        }
    }
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleConfirmNewPassFocusChange(ObservableValue observable,Boolean oldValue,Boolean newValue){
        try{
            if(oldValue){
                boolean oldPassValid = !oldPass.getText().trim().isEmpty();
                boolean newPassValid = !newPass.getText().trim().isEmpty();
                boolean confirmNewPassValid = !confirmNewPass.getText().trim().isEmpty();

                // El botón solo se habilita si todos los campos tienen texto
                boolean camposCompletos = oldPassValid && newPassValid && confirmNewPassValid;
                changePass.setDisable(!camposCompletos);
            }
        }catch (Exception e){
            errorLabel.setText(e.getMessage());
        }
    }
    //Botones
    /**
     * 
     * @param event 
     */
    private void handleChangePassOnAction(ActionEvent event){
       try{
            boolean oldPassValid = !oldPass.getText().trim().isEmpty();
            boolean newPassValid = !newPass.getText().trim().isEmpty();
            boolean confirmNewPassValid = !confirmNewPass.getText().trim().isEmpty();

            // El botón solo se habilita si todos los campos tienen texto
            boolean camposCompletos = oldPassValid && newPassValid && confirmNewPassValid;
            changePass.setDisable(!camposCompletos);
            
        }catch (Exception e){
            errorLabel.setText(e.getMessage());
        }
    }
    /**
     * 
     * @param event 
     */
    private void handleExitOnAction(ActionEvent event){
        
    }     
}
