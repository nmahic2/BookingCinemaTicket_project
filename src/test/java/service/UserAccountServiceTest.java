package service;


//tests
import org.junit.Before;
import org.junit.Test;
import repository.UserAccountRepository;
import service.UserAccountService;

import static org.junit.Assert.*;

public class UserAccountServiceTest {
    private UserAccountRepository userRepository;
    private UserAccountService userAccountService;

    @Before
    public void setup() {
        userRepository = new UserAccountRepository();
        userAccountService = new UserAccountService();
    }

    @Test
    public void testCreateUserAccount_ValidData_ReturnsTrue() {
        // Arrange
        String firstName = "nejla";
        String lastName = "mahic";
        String username = "nmahic1";
        String password = "12345";

        UserAccountService userAccountService = new UserAccountService();
        UserAccountRepository userRepository = new UserAccountRepository(); // Promeniti ovu liniju prema stvarnoj implementaciji

        // Act
        boolean isCreated = userAccountService.createUserAccount(firstName, lastName, username, password);



    }


    @Test
    public void testCreateUserAccount_DuplicateUsername_ReturnsFalse() {
        // Arrange
        String firstName1 = "nejra";
        String lastName1 = "mahic";
        String username1 = "nmahic2";
        String password1 = "123456";

        String firstName2 = "nejla";
        String lastName2 = "mahic";
        String username2 = "nmahic2";
        String password2 = "12345";

        // Create first user account
        userAccountService.createUserAccount(firstName1, lastName1, username1, password1);

        // Act
        boolean isCreated = userAccountService.createUserAccount(firstName2, lastName2, username2, password2);

        // Assert
        assertFalse(isCreated);
    }

    @Test
    public void testValidateLogin_ValidCredentials_ReturnsTrue() {
        // Arrange
        String username = "nmahic2";
        String password = "123456";

        // Create user account
        userAccountService.createUserAccount("nejra", "mahic", username, password);

        // Act
        boolean isValid = userAccountService.validateLogin(username, password);

        // Assert
        assertTrue(isValid);
    }

    @Test
    public void testValidateLogin_InvalidCredentials_ReturnsFalse() {
        // Arrange
        String username = "johndoe";
        String password = "wrongpassword";

        // Create user account
        userAccountService.createUserAccount("John", "Doe", username, "password");

        // Act
        boolean isValid = userAccountService.validateLogin(username, password);

        // Assert
        assertFalse(isValid);
    }
}
