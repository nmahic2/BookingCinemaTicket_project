package service;


//tests
import org.junit.Before;
import org.junit.Test;
import repository.UserAccountRepository;
import service.UserAccountService;

import static org.junit.Assert.*;
/**
 * Testira funkcionalnosti klase UserAccountService.
 */
public class UserAccountServiceTest {
    private UserAccountRepository userRepository;
    private UserAccountService userAccountService;

    /**
     * Priprema potrebnih objekata prije svakog testa.
     */
    @Before
    public void setup() {
        userRepository = new UserAccountRepository();
        userAccountService = new UserAccountService();
    }

    /**
     * Testira kreiranje korisničkog računa sa dupliranim korisničkim imenom.
     */
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
    /**
     * Testira provjeru validnosti prijave sa validnim vjerodajnicama.
     */
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
    /**
     * Testira provjeru validnosti prijave sa nevalidnim vjerodajnicama.
     */
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

    @Test
    public void testCreateUserAccount_EmptyField_ReturnsFalse() {
        // Priprema testnih podataka
        String firstName1 = "";
        String lastName1 = "mahic";
        String username1 = "nmahic2";
        String password1 = "123456";

        // Pokretanje metode koju želimo testirati
        boolean result = userAccountService.createUserAccount(firstName1, lastName1, username1, password1);

        // Provera da li je rezultat očekivan
        assertFalse("Kreiranje korisničkog naloga treba da vrati 'false' ako je jedno od polja prazno", result);
    }
}