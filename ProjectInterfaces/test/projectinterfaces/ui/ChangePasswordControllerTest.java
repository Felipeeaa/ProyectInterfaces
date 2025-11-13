/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectinterfaces.ui;


import javafx.stage.Stage;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isFocused;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import projectinterfaces.ChangePasswordAplication;



/**
 *
 * @author miguel
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChangePasswordControllerTest extends ApplicationTest{
    @Override
    public void start(Stage stage) throws Exception {
       new ChangePasswordAplication().start(stage);
    }
    @Test
    public void test1_InitialTest() {
        verifyThat("#btChangePass",isDisabled());
        verifyThat("#btExit",isFocused());
    }
    @Test
    public void test2_ChangePassword(){
        clickOn("#tfOldPass");
        write("asdasd");
        clickOn("#tfNewPass");
        write("asd4Asd");
        clickOn("#tfConfirmNewPass");
        write("asd4Asd");
        verifyThat("#btChangePass",isEnabled());
        clickOn("#btChangePass");
        
        verifyThat("User password succesfully change!!",isVisible());
        clickOn("Aceptar");      
    }
}
