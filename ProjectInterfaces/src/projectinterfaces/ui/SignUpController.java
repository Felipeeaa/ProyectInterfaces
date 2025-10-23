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
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
/**
 *
 * @author david
 */
public class SignUpController {
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
    private static final Logger LOGGER=Logger.getLogger("projectinterfaces.ui");

    public void init(Stage stage, Parent root) {
        LOGGER.info("Initializing window");
        stage.setTitle("Sign Up");
        stage.setResizable(false);
        bbutton.setDisable(true);
        
        bbutton.setOnAction(this::handleBtRegistrarOnAction);
        
        tfName.textProperty().addListener(this::handleNameTextChange);
        
        tfName.focusedProperty().addListener(this::handleNameFocusChange);
                
        stage.show();
        
    }
    
    private void handleBtRegistrarOnAction(ActionEvent event){
        
    }
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void handleNameTextChange(ObservableValue observable, String oldValue, String newValue){
        
    }
    
    private void handleNameFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        if(oldValue){
            
        }
    }
    private void handleSurNameFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        if(oldValue){
            
        }
    }
    private void handleMIFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        if(oldValue){
            
        }
    }
    private void handleStateFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        if(oldValue){
            
        }
    }
    private void handleCityFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        if(oldValue){
            
        }
    }
    private void handleAddressFocusChange(ObservableValue observable, Boolean oldValue, Boolean newValue){
        if(oldValue){
            
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
