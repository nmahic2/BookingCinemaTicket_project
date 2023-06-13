/*
package service;
import repository.LoginDBRepository;
*/
/*
public class LoginService {
    private LoginDBRepository loginRepo;

    public LoginService() {
        this.loginRepo = new LoginDBRepository();
    }


    public LoginService(LoginDBRepository loginRepo) {
        this.loginRepo = loginRepo;
    }
    public boolean validateLogin(String username, String password) {
        // Ovdje možete dodati dodatnu poslovnu logiku, provjeru i validaciju
        // npr. provjeru duljine korisničkog imena/lozinke, enkripciju itd.

        return loginRepo.validateLogin(username, password);
    }


}
*/


package service;

import repository.LoginDBRepository;

public class LoginService {
    private LoginDBRepository loginRepo;

    public LoginService() {
        this.loginRepo = new LoginDBRepository();
    }


    public LoginService(LoginDBRepository loginRepo) {
        this.loginRepo = loginRepo;
    }
    public boolean validateLogin(String username, String password) {
        // Ovdje možete dodati dodatnu poslovnu logiku, provjeru i validaciju
        // npr. provjeru duljine korisničkog imena/lozinke, enkripciju itd.

        return loginRepo.validateLogin(username, password);
    }


}