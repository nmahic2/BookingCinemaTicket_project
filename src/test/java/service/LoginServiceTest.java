package service;

/*import org.junit.Test;

import static org.junit.Assert.*;

public class LoginServiceTest {

    @Test
    public void validateLogin() {
    }
}*/
/*
import org.junit.Before;
import org.junit.Test;
import repository.LoginDBRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginServiceTest {
    private LoginDBRepository loginRepo;
    private LoginService loginService;

    @Before
    public void setup() {
        // Inicijalizujte LoginDBRepository (ili koristite pravi objekat ili napravite dummy implementaciju)
        loginRepo = new LoginDBRepository();
        loginService = new LoginService(loginRepo);
    }

    @Test
    public void testValidateLogin_ValidCredentials_ReturnsTrue() {
        // Arrange
        String username = "nmahic2";
        String password = "123456";

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

        // Act
        boolean isValid = loginService.validateLogin(username, password);

        // Assert
        assertFalse(isValid);
    }

    @Test
    public void testVslidateLogin_BlankSpace(){
        String username = "";
        String password = "";

        boolean isBlank = loginService.validateLogin(username, password);

    }
}

*/
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.LoginDBRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class LoginServiceTest {
    @Mock
    private LoginDBRepository loginRepo;

    private LoginService loginService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
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
    public void testVslidateLogin_BlankSpace(){
        String username = "";
        String password = "";

        boolean isBlank = loginService.validateLogin(username, password);

    }
}
