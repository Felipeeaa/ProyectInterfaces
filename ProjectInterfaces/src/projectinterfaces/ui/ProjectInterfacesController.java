/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectinterfaces.ui;


import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Luis Felipe Acosta Osorno
 */
public class ProjectInterfacesController {
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private Hyperlink Register;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnExit;
    private static final Logger LOGGER=Logger.getLogger("projectinterfaces.ui");

    public void init(Stage stage, Parent root) {
        
        //Se crea la escena asociada al grafico de root.
        LOGGER.info("Initializing window");
        //Asociamos la escena a la primera ventana.
        Scene scene = new Scene(root);
        //Se establecen las propiedades de la vetana.
        stage.setScene(scene);
        //Establecer el titulo de la ventana
        stage.setTitle("Sign In");
        //La ventana no es redimensionable
        stage.setResizable(false);
        //El botón Login esta deshabilitado y el botón Exit esta habilitado.
        btnLogin.setDisable(true);
        btnExit.setDisable(false);
        //Asociar eventos a manejadores
        //Register.setOnAction(this::handleRegisterOnAction);
        btnLogin.setOnAction(this::handleLoginOnAction);
        btnExit.setOnAction(this::handleExitOnAction);
        tfEmail.textProperty().addListener((
                observable, oldValue, newValue) -> handleChecks());
        pfPassword.textProperty().addListener((
                observable, oldValue, newValue) -> handleChecks());
        
        

        
        //Mostrar la ventana
        
        stage.show();
    }
    private void handleAlert(String mensaje){
        Alert alert = new Alert(AlertType.INFORMATION, mensaje, ButtonType.OK);
        alert.showAndWait();
    }
    private void handleRegisterOnAction(){
        try{ 
        FXMLLoader loader = new FXMLLoader(
        getClass().getResource("SignUp.fxml"));
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        scene.getRoot();
        
        throw new Exception("Error, al ir al registro");
        
        }catch(Exception e){
           handleAlert(e.getMessage());
        }
    }
    private void handleLoginOnAction(ActionEvent event){
         try{
             //Comprobación de los campos
            if(this.tfEmail.getText().trim().equals("") || 
                    this.pfPassword.getText().trim().equals("")){
            throw new Exception("The email or password is incorrect");
            }
            if(tfEmail.getText().equals("") || pfPassword.getText().equals("")){
                throw new Exception("you need to fill in email or password");
            }
            //Crear un objeto customer
            /*Customer customer = new Customer();
            CustomerRESTClient cliente = new CustomerRESTClient().findCustomerByEmailPassword_XML();
            cliente.close();*/
            
        }catch (Exception e){
         handleAlert(e.getMessage());
         
         }
        }
    
    /**
     * 
     * @param event utilizamos este evento para manejar las excepciones
     * necesarias a la hora de pulsar el boton Login
     */
    private void handleChecks(){
        boolean fEmail = fEmail();
        boolean fPassword = fPassword();
        btnLogin.setDisable(!(fEmail && fPassword));
            }

    private boolean fEmail() {
        boolean isfEmail = tfEmail.getText().isEmpty();
        return !isfEmail;
    }

    private boolean fPassword() {
        boolean isfPassword = pfPassword.getText().isEmpty();
        return !isfPassword;
    }
    
    /**
     * 
     * @param event 
     */
    private void handleExitOnAction(ActionEvent event){
        
     Alert alert = new Alert(AlertType.CONFIRMATION, 
             "Are you sure you want to go out?",
              ButtonType.YES, ButtonType.NO);
     alert.setTitle("Confirm Exit");
     alert.showAndWait();
     
     if(alert.getResult() == ButtonType.YES){
         //Lanzamos la ventana emergente para pedir confirmación de salida
         Stage stage = (Stage) btnExit.getScene().getWindow();
            stage.close();
     }
     
    }
    /**
     * 
     * @param event utilizamos este evento para controlar la salida del usuario
     * antes de salir se le manda un mensaje para que confirme la salida
     */
    
}

