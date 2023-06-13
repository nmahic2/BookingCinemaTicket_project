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

public class LoginServiceTest {
    @Mock
    private LoginDBRepository loginRepo;

    private LoginService loginService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        loginService = new LoginService(loginRepo);
    }

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

    @Test
    public void testValidateLogin_BlankSpace(){
        String username = "";
        String password = "";

        boolean isBlank = loginService.validateLogin(username, password);

    }
}

