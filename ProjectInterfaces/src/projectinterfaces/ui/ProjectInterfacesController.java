/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectinterfaces.ui;

import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private TextField Email;
    @FXML
    private PasswordField Password;
    @FXML
    private Hyperlink Hiperenlace;
    @FXML
    private Button Boton;
    private static final Logger LOGGER=Logger.getLogger("projectinterfaces.ui");

    public void init(Stage stage) {
        LOGGER.info("Initializing window");
        //Establecer el titulo de la ventana
        stage.setTitle("Sign In");
        //• La tabla de usuarios mostrará la información de todos los usuarios existentes.
        stage.setResizable(false);
        //• Los botones Crear, Modificar y Eliminar se deshabilitan.
        Boton.setDisable(true);
        
        //• Los campos Login y Nombre están habilitados.
        //• La combo Perfil se carga con las descripciones de los diferentes perfiles de usuario.
        //• La combo Departamento se carga con los nombres de los diferentes departamentos.
        //• El botón Salir estará habilitado.
        //• Se enfoca el campo login.*/
    }
}

