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
    private Label errorLabel;
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
            }
        }
        catch (Exception e){
            tfName.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabel.setText(e.getMessage());
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
            }
        }
        catch (Exception e){
            tfSurName.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabel.setText(e.getMessage());
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
            }
            tfMidInit.setStyle("-fx-border-color:green"); 
        }
        catch (Exception e){
            tfMidInit.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabel.setText(e.getMessage());
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
            }
        }
        catch(Exception e){
            tfState.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabel.setText(e.getMessage());
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
            }
        }
        catch(Exception e){
            tfCity.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabel.setText(e.getMessage());
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
            } 
        }
        catch(Exception e){
            tfAdress.setStyle("-fx-border-color: red; -fx-border-width: 2px;");
            errorLabel.setText(e.getMessage());
            LOGGER.info(e.getMessage());
        }
        
        
        
    }
    private void handleZIPFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        if(oldValue){
            
        }
        
    }
    private void handlePhoneFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        if(oldValue){
            
        }
        
    }
    private void handleEmailFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        if(oldValue){
            
        }   
    }
    private void handlePasswFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        if(oldValue){
            
        }  
    }
    private void handleConfirmPasswFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        if(oldValue){
            
        }   
    }   
}
