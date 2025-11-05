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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import projectinterfaces.model.Customer;

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
    private Customer customer;
    
    
    private static final Logger LOGGER = Logger.getLogger("ProjectInterfacesApplication.ui");
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    
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
        btChangePass.setOnAction(this::handlebtChangePassOnAction);
        btExit.setOnAction(this::handlebtExitOnAction);
        //Asiciacion de manejadores a properties
        tfOldPass.focusedProperty().addListener(this::handletfOldPassChange);
        tfNewPass.focusedProperty().addListener(this::handletfNewPassFocusChange);
        tfConfirmNewPass.textProperty().addListener(this::handletfConfirmNewPassOnFocusChange);
        
        stage.show();
        
    }
    //Old Password
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handletfOldPassChange(ObservableValue observable,Object oldValue,Object newValue){
        try{
                String pass = tfOldPass.getText();
                if(pass.isEmpty()){
                    btChangePass.setDisable(true);
                    throw new Exception ("Old Password is empty");
                }
                //if(!pass.equals(customer.getPassword()))
                  //  throw new Exception("Incorrect password");
                tfOldPass.setStyle("-fx-border-color: green; -fx-border-width: 1px;");
                lbOldErrorLabel.setText("");
        }catch (Exception e){
            tfOldPass.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
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
    private void handletfNewPassFocusChange(ObservableValue observable,Object oldValue,Object newValue){
        try{
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
                
                tfNewPass.setStyle("-fx-border-color: green; -fx-border-width: 1px;");
                lbNewErrorLabel.setText("");
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
    private void handletfConfirmNewPassOnFocusChange(ObservableValue observable,Object oldValue,Object newValue){
        try{
            if(!tfNewPass.getText().equals(tfConfirmNewPass.getText())){
                throw new Exception ("The password is not the same");  
            }
            
            boolean oldPassValid = !tfOldPass.getText().trim().isEmpty();
            boolean newPassValid = !tfNewPass.getText().trim().isEmpty();
            boolean confirmNewPassValid = !tfConfirmNewPass.getText().trim().isEmpty();
            boolean camposCompletos = oldPassValid && newPassValid && confirmNewPassValid;
            // El botón solo se habilita si todos los campos tienen texto
            btChangePass.setDisable(!camposCompletos);
            tfConfirmNewPass.setStyle("-fx-border-color: green; -fx-border-width: 1px;");
            lbConfirmErrorLabel.setText("");
            
        }catch (Exception e){
            tfConfirmNewPass.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            lbConfirmErrorLabel.setText(e.getMessage());
        }
    }
    //Botones
    /**
     * 
     * @param event 
     */
    private void handlebtChangePassOnAction(ActionEvent event){
        try{
            
            boolean oldPassValid = !tfOldPass.getText().trim().isEmpty();
            boolean newPassValid = !tfNewPass.getText().trim().isEmpty();
            boolean confirmNewPassValid = !tfConfirmNewPass.getText().trim().isEmpty();
            //El botón solo se habilita si todos los campos tienen texto
            boolean camposCompletos = oldPassValid && newPassValid && confirmNewPassValid;
            btChangePass.setDisable(!camposCompletos);
            //customer.setPassword(tfConfirmNewPass.getText());
            new Alert(AlertType.INFORMATION,"User password succesfully change!!").showAndWait();
            //Customer.setPassword(tfConfirmNewPass.getText());
            /*FXMLLoader loader = new FXMLLoader(getClass().getResource("ui/ProjectInterfacesController.fxml"));
            Parent root = (Parent)loader.load();
            ProjectInterfacesController controller = loader.getController();
            controller.init(stage, root);*/
            
        }catch (Exception e){
            //lbConfirmErrorLabel.setText(e.getMessage());
            new Alert(AlertType.INFORMATION,e.getLocalizedMessage()).showAndWait();
            LOGGER.warning("Error");
        }
    }
    /**
     * 
     * @param event 
     */
    private void handlebtExitOnAction(ActionEvent event){
        try{
            /*FXMLLoader loader = new FXMLLoader(getClass().getResource("ui/ProjectInterfacesController.fxml"));
            Parent root = (Parent)loader.load();
            ProjectInterfacesController controller = loader.getController();
            controller.init(stage, root);*/
        }catch(Exception e){
            new Alert(AlertType.INFORMATION,e.getLocalizedMessage()).showAndWait();
            LOGGER.warning("Error c");
        }
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
