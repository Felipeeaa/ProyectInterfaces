/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectinterfaces.ui;



import java.util.concurrent.TimeoutException;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isFocused;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import projectinterfaces.ChangePasswordAplication;
import projectinterfaces.ProjectInterfacesApplication;
/**
 *
 * @author miguel
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChangePasswordControllerTest extends ApplicationTest{
    /*@Override
    public void start(Stage stage) throws Exception {
       new ProjectInterfacesApplication().start(stage);
       
    }*/
    @BeforeClass
    public static void setUpClass() throws TimeoutException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(ProjectInterfacesApplication.class);
    }
    //@Before
    @Test
    public void test1_LogIn() {
        clickOn("#tfEmail");
        write("jsmith@enterprise.net");
        clickOn("#pfPassword");
        write("sd4Asd");
        clickOn("#btnLogin");
        clickOn("Aceptar");
    }   
    
    @Test
    public void test2_InitialTest() {
        verifyThat("#btChangePass",isDisabled());
        verifyThat("#btExit",isFocused());
    }
    
    @Test
    public void test3_ChangePassword(){
        clickOn("#tfOldPass");
        write("sd4Asd");
        clickOn("#tfNewPass");
        write("Asd4Asd");
        clickOn("#tfConfirmNewPass");
        write("Asd4Asd");
        clickOn("#btChangePass");
        
        verifyThat("User password succesfully change!!",isVisible());
        clickOn("Aceptar");  
    }
}
