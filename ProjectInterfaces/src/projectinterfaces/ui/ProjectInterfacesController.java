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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author felipe
 */
public class ProjectInterfacesController {
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Hyperlink Hiperenlace;
    @FXML
    private Button Login;
    @FXML
    private Button Exit;
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
        stage.setResizable(false);
        //Los botones Login y Exit se deshabilitan.
        Login.setDisable(true);
        Exit.setDisable(true);
        //Los campos Email y Password están habilitados.
        tfEmail.setEditable(true);
        tfPassword.setEditable(true);
        //Establecemos el PrompText
        tfEmail.setPromptText("Email");
        tfPassword.setPromptText("Password");
        //El botón Salir estará habilitado.
        Exit.setOnAction(this::handleExitOnAction);
        //Se enfoca el campo login.
        Login.focusedProperty().addListener(this::handleLoginFocusChanged);
        //Se enfoca el campo Password.
        tfPassword.focusedProperty().addListener(this::handlePasswordFocusChanged);
        //Se enfoca el campo Register.
        Hiperenlace.focusedProperty().addListener(this::handleHiperenlaceFocusChanged);
        //Se enfoca el campo Login.
        Login.focusedProperty().addListener(this::handleLoginFocusChanged);
        //Se enfoca el campo exit.
        Exit.focusedProperty().addListener(this::handleExitFocusChanged);
        //Asociar eventos a manejadores
        Login.setOnAction(this::handleLoginOnAction);
        //Asociación de manejadores a properties
        tfEmail.textProperty().addListener(this::handleEmailTextChange);
        tfPassword.textProperty().addListener(this::handlePasswordTextChange);
        
        //Mostrar la ventana
        
        stage.show();
    }
    private void handleEmailTextChange(ObservableValue observable, 
                                       String oldValue,
                                       String newValue){
         try{
            if(this.tfEmail.getText().trim().equals("")){
                /*Alert alert=new Alert(AlertType.ERROR, 
                        "The Email field is empty"
                        ButtonType.OK);
                alert.getDialogPane().getStylesheets().add(
                      getClass().getResource("projectinterfaces/ui"));
                alert.showAndWait();*/
            }
        }catch (Exception e){
        
        }
    }
    /**
     * 
     * @param observable este metódo sirve para ver que hay en el campo de texto
     * @param oldValue este metódo sirve para
     * @param newValue este metódo sirve para
     */
    private void handlePasswordTextChange(ObservableValue observable, 
                                       String oldValue,
                                       String newValue){
         try{
           if(this.tfPassword.getText().trim().equals("")){
                /*Alert alert=new Alert(AlertType.ERROR, 
                        "The Password field is empty"
                        ButtonType.OK);
                alert.getDialogPane().getStylesheets().add(
                      getClass().getResource("projectinterfaces/ui"));
                alert.showAndWait();*/
           }
        }catch (Exception e){
        
        }
    }
    /**
     * 
     * @param observable este metódo sirve para ver que hay en el campo texto
     * @param oldValue este metódo sirve para
     * @param newValue  este metódo sirve para
     */
    private void handleLoginOnAction(ActionEvent event){
         try{
            /*if(Login.equals(Login.get)){
                
            }*/
        }catch (Exception e){
        
        }
    }
    /**
     * 
     * @param event 
     */
    private void handleExitOnAction(ActionEvent event){
        try{
            /*if(){
                
            }*/
        }catch (Exception e){
        
        }
    }
    /**
     * 
     * @param event 
     */
    
    
    private void handleEmailFocusChanged(ObservableValue observable, 
                                            Boolean oldValue, 
                                            Boolean newValue){
         try{
             if(newValue){
            LOGGER.info("onFocus");
        } else if(tfEmail.getText().isEmpty()){
            tfEmail.requestFocus();
         }
        }catch (Exception e){
            tfEmail.setStyle("-fx-text-inner-color: red;");
            LOGGER.info(e.getMessage());
        }
       
    }
    private void handlePasswordFocusChanged(ObservableValue observable, 
                                            Boolean oldValue, 
                                            Boolean newValue){
         try{
             if(newValue){
            LOGGER.info("onFocus");
        }
        }catch (Exception e){
            tfPassword.setStyle("-fx-text-inner-color: red;");
            LOGGER.info(e.getMessage());
        }
       
    }
    /**
     * 
     * @param observable este metódo sirve para ver que hay en el campo de texto
     * @param oldValue este metódo sirve para ver el antiguo texto que habia
     * @param newValue este metódo sirve para ver el nuevo texto que hay.
     */
     private void handleHiperenlaceFocusChanged(ObservableValue observable,
                                         Boolean oldValue,
                                         Boolean newValue){
         try{
             if(newValue){
            
        }
        }catch (Exception e){
        
        }
       
    }
     /**
     * 
     * @param observable este metódo sirve para ver que hay en el campo de texto
     * @param oldValue este metódo sirve para
     * @param newValue este metódo sirve para
     */
    private void handleLoginFocusChanged(ObservableValue observable,
                                         Boolean oldValue,
                                         Boolean newValue){
         try{
             if(newValue){
            Node button = Login.getClip();
        }
        }catch (Exception e){
        
        }
       
    }
   
    /**
     * 
     * @param observable este metódo sirve para ver que hay en el campo de texto
     * @param oldValue este metódo sirve para
     * @param newValue este metódo sirve para
     */
    private void handleExitFocusChanged(ObservableValue observable,
                                         Boolean oldValue,
                                         Boolean newValue){
         try{
             if(newValue){
            Node button = Exit.getClip();
        }
        }catch (Exception e){
            //Exit.getClip("Are you sure you want to go out?");
        }
       
    }
    /**
     * 
     * @param observable este metódo sirve para ver que hay en el campo de texto
     * @param oldValue este metódo sirve para
     * @param newValue este metódo sirve para
     */
    
}

