/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectinterfaces.ui;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import java.lang.Exception;
import javafx.scene.control.Label;
/**
 *
 * @author david
 */
public class SignUpController {
    int f;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfSurName;
    @FXML
    private TextField tfMidInit;
    @FXML
    private TextField tfState;
    @FXML
    private TextField tfCity;
    @FXML
    private TextField tfAdress;
    @FXML
    private TextField tfZip;
    @FXML
    private TextField tfPhone;
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField pfPassw;
    @FXML
    private PasswordField pfConfPassw;
    @FXML
    private Button bbutton;
    @FXML
    private Hyperlink hlhyperlink;
    @FXML
    private Label errorLabelName;
    @FXML
    private Label errorLabelSurName;
    @FXML
    private Label errorLabelState;
    @FXML
    private Label errorLabelStreet;
    @FXML
    private Label errorLabelCity;
    @FXML
    private Label errorLabelEmail;
    @FXML
    private Label errorLabelPhone;
    @FXML
    private Label errorLabelPassw;
    private static final Logger LOGGER=Logger.getLogger("projectinterfaces.ui");

    public void init(Stage stage, Parent root) {
        
        LOGGER.info("Initializing window");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Sign Up");
        stage.setResizable(false);
        bbutton.setDisable(true);
        
        
        
        bbutton.setOnAction(this::handleBtRegistrarOnAction);
        
        
        tfName.focusedProperty().addListener(this::handleNameFocusChange);
        tfSurName.focusedProperty().addListener(this::handleSurNameFocusChange);
        tfMidInit.focusedProperty().addListener(this::handleMIFocusChange);
        tfState.focusedProperty().addListener(this::handleStateFocusChange);
        tfCity.focusedProperty().addListener(this::handleCityFocusChange);
        tfAdress.focusedProperty().addListener(this::handleAdressFocusChange);
        tfZip.focusedProperty().addListener(this::handleZIPFocusChange);
        tfPhone.focusedProperty().addListener(this::handlePhoneFocusChange);
        tfEmail.focusedProperty().addListener(this::handleEmailFocusChange);
        pfPassw.focusedProperty().addListener(this::handleNameFocusChange);
        pfConfPassw.focusedProperty().addListener(this::handleNameFocusChange);
        
                
        stage.show();
        
    }
    
    private void handleBtRegistrarOnAction(ActionEvent event){
        
    }
    
    private void handleNameFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        try{
        if(oldValue){
            
                String text = tfName.getText();
                boolean valid = text.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
                if(text.isEmpty()){
                    throw new Exception ("Name field empty");
                }
                if(text.length()>30){
                    throw new Exception("Name text too long");
                }
                if (!valid){
                    throw new Exception("Name format not valid");
                }
                tfName.setStyle("-fx-border-color:green");
                errorLabelName.setText("");
            }
        }
        catch (Exception e){
            tfName.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabelName.setText(e.getMessage());
            errorLabelName.setStyle("-fx-text-fill: red");
            LOGGER.info(e.getMessage());
        }
    }
    
    
    private void handleSurNameFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        try{
            if(oldValue){
                String text = tfSurName.getText();
                boolean valid = text.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
                if(text.isEmpty()){
                    throw new Exception ("Surname field empty");
                }
                if(text.length()>30){
                    throw new Exception("Surname text too long");
                }
                if (!valid){
                    throw new Exception("Surname format not valid");
                }
                tfSurName.setStyle("-fx-border-color:green"); 
                errorLabelSurName.setText("");
            }
        }
        catch (Exception e){
            tfSurName.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabelSurName.setText(e.getMessage());
            errorLabelSurName.setStyle("-fx-text-fill: red");
            LOGGER.info(e.getMessage());
        }
    }
    private void handleMIFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        try{
           if(oldValue){
            String text= tfMidInit.getText();
            boolean valid = text.matches("[A-Z]+");
            if(text.length()>1){
                throw new Exception("Input just one initial");
                }
            if(text.isEmpty()){
                throw new Exception("Middle initial field is empty");
                }
            if(!valid){
                throw new Exception("Middle initial format invalid");
                }
            tfMidInit.setStyle("-fx-border-color:green");
            errorLabelName.setText("");
            }
             
        }
        catch (Exception e){
            tfMidInit.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabelName.setText(e.getMessage());
            errorLabelName.setStyle("-fx-text-fill: red");
            LOGGER.info(e.getMessage());
        }
        
        
        
    }
    private void handleStateFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        try{
            if(oldValue){
                String text = tfState.getText();
                boolean valid = text.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
                if(text.isEmpty()){
                    throw new Exception ("State field empty");
                }
                if(text.length()>30){
                    throw new Exception("State text too long");
                }
                if (!valid){
                    throw new Exception("State format not valid");
                }
                tfState.setStyle("-fx-border-color:green");
                errorLabelState.setText("");
            }
        }
        catch(Exception e){
            tfState.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabelState.setText(e.getMessage());
            errorLabelState.setStyle("-fx-text-fill: red");
            LOGGER.info(e.getMessage());
        }
        
        
    }
    private void handleCityFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        try{
            if(oldValue){
                String text = tfCity.getText();
                boolean valid = text.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
                if(text.isEmpty()){
                    throw new Exception ("City field empty");
                }
                if(text.length()>30){
                    throw new Exception("City text too long");
                }
                if (!valid){
                    throw new Exception("City format not valid");
                }
                tfCity.setStyle("-fx-border-color:green");
                errorLabelCity.setText("");
            }
        }
        catch(Exception e){
            tfCity.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabelCity.setText(e.getMessage());
            errorLabelCity.setStyle("-fx-text-fill: red");
            LOGGER.info(e.getMessage());
        }
        
        
    }
    private void handleAdressFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        try{
        if(oldValue){
            String text = tfAdress.getText();
            boolean valid = text.matches("[0-9a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
            if(text.isEmpty()){
                    throw new Exception ("Adress field empty");
                }
                if(text.length()>30){
                    throw new Exception("Adress text too long");
                }
                if (!valid){
                    throw new Exception("Adress format not valid");
                }
                tfAdress.setStyle("-fx-border-color:green");
                errorLabelStreet.setText("");
            } 
        }
        catch(Exception e){
            tfAdress.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabelStreet.setText(e.getMessage());
            errorLabelStreet.setStyle("-fx-text-fill: red");
            LOGGER.info(e.getMessage());
        }
        
        
        
    }
    private void handleZIPFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        try{
           if(oldValue){
           String text = tfZip.getText();
           boolean valid = text.matches("[0-9]+");
           if(text.isEmpty()){
               throw new Exception("ZIP field is empty");
           }
           if(text.length()>5 || text.length()<5){
               throw new Exception("ZIP length not valid (5 numbers)");
           }
           if(!valid){
               throw new Exception("ZIP format not valid");
           }
           tfZip.setStyle("-fx-border-color:green");
           errorLabelState.setText("");
        } 
        }
        catch(Exception e){
            tfZip.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabelState.setText(e.getMessage());
            errorLabelState.setStyle("-fx-text-fill: red");
            LOGGER.info(e.getMessage());
        }
        
        
    }
    private void handlePhoneFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        try{
            if(oldValue){
                String text = tfPhone.getText();
                boolean valid = text.matches("[0-9 +]+");
                if(!text.contains("+1")){
                    throw new Exception("Phone number must be +1");
                }
                if(!valid){
                    throw new Exception("Phone format invalid");
                }
                if(text.length()>15){
                    throw new Exception("Phone number too long");
                }
                if(text.isEmpty()){
                    throw new Exception("Phone number is empty");
                }
                tfPhone.setStyle("-fx-border-color:green");
                errorLabelPhone.setText("");
            }
        }
        catch(Exception e){
            tfPhone.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabelPhone.setText(e.getMessage());
            errorLabelPhone.setStyle("-fx-text-fill: red");
            LOGGER.info(e.getMessage());
        }
        
        
    }
    private void handleEmailFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        try{
            if(oldValue){
                String text = tfEmail.getText();
                String patronEmail = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
                if(text.isEmpty()){
                    throw new Exception("Email is empty");
                }
                if(text.length()>100){
                    throw new Exception("Email too long");
                }
                if(!text.matches(patronEmail)){
                    throw new Exception("Email format not valid");
                }
                tfEmail.setStyle("-fx-border-color:green");
                errorLabelEmail.setText("");
        }
        }
        catch(Exception e){
            tfEmail.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabelEmail.setText(e.getMessage());
            errorLabelEmail.setStyle("-fx-text-fill: red");
            LOGGER.info(e.getMessage());
        }
           
    }
    private void handlePasswFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        try{
            if(oldValue){
                String text = pfPassw.getText();
                if(text.isEmpty()){
                    throw new Exception("Password is empty");
                }
                if(text.length()<5){
                    throw new Exception("Password too short");
                }
                if(text.length()>30){
                    throw new Exception("Password too long");
                }
                if(text.contains("[A-Z]+")){
                    throw new Exception("Password must contain Upper Case");
                }
                if(text.contains("[0-9]+")){
                    throw new Exception("Password must contain numbers");
                }
                pfPassw.setStyle("-fx-border-color:green");
                errorLabelPassw.setText("");
        } 
        }
        catch(Exception e){
            pfPassw.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabelPassw.setText(e.getMessage());
            errorLabelPassw.setStyle("-fx-text-fill: red");
            LOGGER.info(e.getMessage());
        }
         
    }
    private void handleConfirmPasswFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        if(oldValue){
            
        }   
    }   
}
