/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectinterfaces.ui;

import java.util.concurrent.TimeoutException;
import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isFocused;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import projectinterfaces.ProjectInterfacesApplication;

/**
 *
 * @author david
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignUpControllerTest extends ApplicationTest{
    
    /*@BeforeClass
    public static void setUpClass() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(SignUpApplication.class);
   }*/
    
    @Override
    public void start(Stage stage) throws Exception{
        new ProjectInterfacesApplication().start(stage);
    }

    @Before
    public void test1_InitialTests() {
        clickOn("#Register");
        //verifyThat("#bbutton", isDisabled());
        //verifyThat("#tfName", isFocused());
    }
    
    @Test
    public void test2_SignUp(){
        clickOn("#tfName");
        write("Nisa");
        clickOn("#tfMidInit");
        write("A");
        clickOn("#tfSurName");
        write("Abyss");
        clickOn("#tfState");
        write("idkXD");
        clickOn("#tfZip");
        write("67676");
        clickOn("#tfAdress");
        write("67 streen number 67");
        clickOn("#tfCity");
        write("Turkey");
        clickOn("#tfEmail");
        write("6767676754@gmail.com");
        clickOn("#tfPhone");
        write("676767670");
        clickOn("#pfPassw");
        write("Abcd1234");
        clickOn("#pfConfPassw");
        write("Abcd1234");
        verifyThat("#bbutton", isEnabled());
        clickOn("#bbutton");
        verifyThat("Succesfully registered!", isVisible()); 
        clickOn("Aceptar");
    }
    
    @Test
    public void test3_ClientAlreadyExists(){
       clickOn("#tfName");
        write("Nisa");
        clickOn("#tfMidInit");
        write("A");
        clickOn("#tfSurName");
        write("Abyss");
        clickOn("#tfState");
        write("idkXD");
        clickOn("#tfZip");
        write("67676");
        clickOn("#tfAdress");
        write("67 streen number 67");
        clickOn("#tfCity");
        write("Turkey");
        clickOn("#tfEmail");
        write("67676767@gmail.com");
        clickOn("#tfPhone");
        write("676767670");
        clickOn("#pfPassw");
        write("Abcd1234");
        clickOn("#pfConfPassw");
        write("Abcd1234");
        verifyThat("#bbutton", isEnabled());
        clickOn("#bbutton");
        verifyThat("Introduced Email already exist, use another", isVisible()); 
        clickOn("Aceptar");
    }
    
}
