package service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.LoginDBRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
/**
 * Testira funkcionalnosti klase LoginService.
 */
public class LoginServiceTest {
    @Mock
    private LoginDBRepository loginRepo;

    private LoginService loginService;
    /**
     * Priprema potrebnih objekata prije svakog testa.
     */
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        loginService = new LoginService(loginRepo);
    }
    /**
     * Testira validaciju ispravnih podataka za prijavu.
     */
    @Test
    public void testValidateLogin_ValidCredentials_ReturnsTrue() {
        // Arrange
        String username = "nmahic2";
        String password = "123456";
        when(loginRepo.validateLogin(username, password)).thenReturn(true);

        // Act
        boolean isValid = loginService.validateLogin(username, password);

        // Assert
        assertTrue(isValid);
    }
    /**
     * Testira validaciju neispravnih podataka za prijavu.
     */
    @Test
    public void testValidateLogin_InvalidCredentials_ReturnsFalse() {
        // Arrange
        String username = "nmahic";
        String password = "123456";
        when(loginRepo.validateLogin(username, password)).thenReturn(false);

        // Act
        boolean isValid = loginService.validateLogin(username, password);

        // Assert
        assertFalse(isValid);
    }
    /**
     * Testira validaciju praznih polja za prijavu.
     */
    @Test
    public void testValidateLogin_BlankSpace(){
        String username = "";
        String password = "";

        boolean isBlank = loginService.validateLogin(username, password);

    }
}

