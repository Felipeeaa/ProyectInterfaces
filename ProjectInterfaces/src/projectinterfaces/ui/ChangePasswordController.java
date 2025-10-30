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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 *
 * @author miguel
 */
public class ChangePasswordController {
   // private String email;
   // private String password;
    @FXML
    private Button btChangePass;
    @FXML
    private Button btExit;
    @FXML
    private PasswordField tfOldPass;
    @FXML
    private PasswordField tfNewPass;
    @FXML
    private PasswordField tfConfirmNewPass;
    @FXML
    private Label lbOldErrorLabel;
    @FXML
    private Label lbNewErrorLabel;
    @FXML
    private Label lbConfirmErrorLabel;
            
    
    private static final Logger LOGGER = Logger.getLogger("ProjectInterfacesApplication.ui");

    public void init(Stage stage, Parent root) {
        //Establecer el titulo de la ventana
        stage.setTitle("Change Password");
        //La ventana no debe ser redimensionable
        stage.setResizable(false);
        //El botón Change Password está deshabilitado hasta que los campos estén completos.
        btChangePass.setDisable(true);
        //El botón Cancel está habilitado.
        btExit.setDisable(false);
        //asociar eventos a manejadores
        btChangePass.setOnAction(this::handleChangePassOnAction);
        btExit.setOnAction(this::handleExitOnAction);
        //Asiciacion de manejadores a properties
        tfOldPass.focusedProperty().addListener(this::handleOldPassChange);
        tfNewPass.focusedProperty().addListener(this::handleNewPassFocusChange);
        tfConfirmNewPass.textProperty().addListener(this::handleConfirmNewPassOnFocusChange);
        
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
                String pass = tfOldPass.getText();
                if(pass.isEmpty()){
                    btChangePass.setDisable(true);
                    throw new Exception ("Old Password is empty");
                }
                if(!pass.equals(customer.getPassword()));
                    throw new Exception("Incorrect password");
            }
        }catch (Exception e){
            tfNewPass.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            lbOldErrorLabel.setText(e.getMessage());
        }
    }
    //New Password
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleNewPassFocusChange(ObservableValue observable,Boolean oldValue,Boolean newValue){
        try{
            if(oldValue){
                String pass = tfNewPass.getText();
                String passValid = "^(?=.*[A-Z])(?=.*\\d).{5,30}$";
                
                if(pass.isEmpty()){
                    btChangePass.setDisable(true);
                    throw new Exception ("The Password field is empty");
                }        
                if(tfOldPass.getText().equals(tfNewPass.getText()))
                    throw new Exception ("The new password is the same as the previous one");
                if(pass.length()<5)
                    throw new Exception ("The password is too short");
                if(!pass.matches(passValid))
                    throw new Exception ("Password Introduced not valid");
                lbNewErrorLabel.setText("");
        }
        }catch (Exception e){
            tfNewPass.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            lbNewErrorLabel.setText(e.getMessage());
        }
    }
    //Conform New Password
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleConfirmNewPassOnFocusChange(ObservableValue observable,Object oldValue,Object newValue){
        try{
            
            boolean oldPassValid = !tfOldPass.getText().trim().isEmpty();
            boolean newPassValid = !tfNewPass.getText().trim().isEmpty();
            boolean confirmNewPassValid = !tfConfirmNewPass.getText().trim().isEmpty();
            // El botón solo se habilita si todos los campos tienen texto
            
            boolean camposCompletos = oldPassValid && newPassValid && confirmNewPassValid;
            btChangePass.setDisable(!camposCompletos);
            if(!tfNewPass.getText().equals(tfConfirmNewPass.getText())){
                throw new Exception ("The password is not the same");  
            }
            
        }catch (Exception e){
            tfOldPass.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            lbConfirmErrorLabel.setText(e.getMessage());
        }
    }
    //Botones
    /**
     * 
     * @param event 
     */
    private void handleChangePassOnAction(ActionEvent event){
       try{
            
            boolean oldPassValid = !tfOldPass.getText().trim().isEmpty();
            boolean newPassValid = !tfNewPass.getText().trim().isEmpty();
            boolean confirmNewPassValid = !tfConfirmNewPass.getText().trim().isEmpty();
            // El botón solo se habilita si todos los campos tienen texto
            boolean camposCompletos = oldPassValid && newPassValid && confirmNewPassValid;
            btChangePass.setDisable(!camposCompletos);
            //customer.setPassword(tfConfirmNewPass.getText());
            //new Alert(AlertType.INFORMATION,"User password succesfully change!!").showAndWait();
            customer.getEmail();
            if(customer.getEmail().equals)
                Customer.setPassword(tfConfirmNewPass.getText());
        }catch (Exception e){
            lbConfirmErrorLabel.setText(e.getMessage());
           // LOGGER.warning(e.getLocalisedMessage());
            //new Alert(AlertType.INFORMATION,e.getLocalizedMessage()).showAndWait();
        }
    }
    /**
     * 
     * @param event 
     */
    private void handleExitOnAction(ActionEvent event){
        try{
            
        }catch(Exception e){
            lbConfirmErrorLabel.setText(e.getMessage());
            //new Alert(AlertType.INFORMATION,e.getLocalizedMessage()).showAndWait();
        }
    
    }
    /*public void setCustomer(String email, String password){
        this.email = email;
        this.password = password;
    }
    /*private void handleBtCrearOnAction(ActionEvent event){
        try{
            //crear objeto customer
            Customer customer=new Customer();
            customer.setLastName("");
            CustomerRESTClient client = new CustomerRESTClient();
            client.close();
            new Alert(AlerType.INFORMATION,"User data succesfully registered!!!").showAndWait();
            
        }catch(Exception e){
            LOGGER.warning(e.getLocalisedMessage());
            new Alert(AlertType.INFORMATION,e.getLocalizedMessage()).showAndWait();
        }
    }*/
}
