
package service;

import repository.LoginDBRepository;
/**
 * Servis za provjeru valjanosti prijave korisnika.
 */
public class LoginService {
    private LoginDBRepository loginRepo;
    /**
     * Konstruktor koji stvara novu instancu servisa s podrazumijevanim repozitorijem.
     */
    public LoginService() {
        this.loginRepo = new LoginDBRepository();
    }
    /**
     * Konstruktor koji stvara novu instancu servisa s određenim repozitorijem.
     *
     * @param loginRepo Repozitorij za prijavu korisnika
     */

    public LoginService(LoginDBRepository loginRepo) {
        this.loginRepo = loginRepo;
    }

    /**
     * Provjerava valjanost korisničkog prijavljivanja.
     *
     * @param username Korisničko ime
     * @param password Lozinka
     * @return {@code true} ako je prijava valjana, inače {@code false}
     */
    public boolean validateLogin(String username, String password) {
        return loginRepo.validateLogin(username, password);
    }


}