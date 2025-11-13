/*
•	To change this license header, choose License Headers in Project Properties.
•	To change this template file, choose Tools | Templates
•	and open the template in the editor.
*/ package projectinterfaces.ui;
import javafx.stage.Stage; 
import javax.ws.rs.NotAuthorizedException; 
import org.junit.Test; 
import static org.junit.Assert.*; 
import org.testfx.framework.junit.ApplicationTest; 
import static org.testfx.api.FxAssert.verifyThat; 
import org.junit.runners.MethodSorters; 
import org.junit.FixMethodOrder; 
import static org.testfx.matcher.base.NodeMatchers.isDisabled; 
import static org.testfx.matcher.base.NodeMatchers.isEnabled; 
import static org.testfx.matcher.base.NodeMatchers.isFocused; 
import static org.testfx.matcher.base.NodeMatchers.isVisible; 
import static org.testfx.matcher.control.TextInputControlMatchers.hasText; 
import projectinterfaces.ProjectInterfacesApplication; 
import projectinterfaces.model.Customer;

/** *
•	@author felipe
*/ @FixMethodOrder(MethodSorters.NAME_ASCENDING) public class ProjectInterfacesControllerTest extends ApplicationTest{
@Override
public void start(Stage stage) throws Exception {
    new ProjectInterfacesApplication().start(stage);
}
/*@Test
public void testTfEmailFocused(){
    verifyThat("tfEmail",isFocused());
}*/

 @Test
public void test1_InitialState() {
    verifyThat("#tfEmail", hasText(""));
    verifyThat("#pfPassword",hasText(""));
    verifyThat("#btnLogin", isDisabled());
}
@Test
public void test2_LoginisDisabled(){
    clickOn("#tfEmail");
    write("username");
    verifyThat("#btnLogin", isDisabled());
    eraseText(8);
    clickOn("#pfPassword");
    write("password");
    verifyThat("#btnLogin", isDisabled());
    eraseText(8);
    verifyThat("#btnLogin", isDisabled());
}
@Test
public void test3_LoginisEnabled(){
    clickOn("#tfEmail");
    write("username");
    clickOn("#pfPassword");
    write("password");
    verifyThat("#btnLogin", isEnabled());
}
@Test
public void test4_NotAuthorizedException(){
    clickOn("#tfEmail");
    write("felipea@enterprise.net");
    clickOn("#pfPassword");
    write("abcd*1234");
    verifyThat("#btnLogin", isEnabled());
    clickOn("#btnLogin");
    verifyThat("¡The email or password is incorrect!", isVisible());
    clickOn("Aceptar");
}
@Test
public void test5_ChangePassword(){
    clickOn("#tfEmail");
    write("jsmith@enterprise.net");
    clickOn("#pfPassword");
    write("abcd*1234");
    verifyThat("#btnLogin", isEnabled());
    clickOn("#btnLogin");
    verifyThat("Aceptar", isVisible());
    clickOn("Aceptar");
}
@Test
public void test6_RegisterisEnabled(){
    clickOn("#Register");
    verifyThat("#bbutton", isVisible());
}
@Test
public void test7_ExitisEnabled(){
    clickOn("#btnExit");
    verifyThat("Are you sure you want to go out?", isVisible());
    clickOn("Sí");
}
 
}
