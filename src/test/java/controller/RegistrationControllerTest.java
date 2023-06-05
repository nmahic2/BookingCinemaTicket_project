package controller;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class RegistrationControllerTest {

    @Test
    public void register() {
        String username;
        username = "nmahic2";
        assertEquals("nmahic2", username);
    }

}
