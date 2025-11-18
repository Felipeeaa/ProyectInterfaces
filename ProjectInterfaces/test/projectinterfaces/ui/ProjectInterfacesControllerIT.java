/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectinterfaces.ui;

import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import projectinterfaces.ProjectInterfacesApplication;

/**
 *
 * @author felipe
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class ProjectInterfacesControllerIT extends ApplicationTest{

@Override
public void start(Stage stage) throws Exception {
    new ProjectInterfacesApplication().start(stage);
}
//@Test
public void test1_InternalServerError(){
     clickOn("#tfEmail");
    write("jsmith@enterprise.net");
    clickOn("#pfPassword");
    write("abcd*1234");
    verifyThat("#btnLogin", isEnabled());
    clickOn("#btnLogin");
    verifyThat("¡Internal server not found,\n"
                    + "please try again after a few minutes,\n "
                    + "if the problem persists, contact you company!"
            , isVisible());
    clickOn("Aceptar");
}

}
