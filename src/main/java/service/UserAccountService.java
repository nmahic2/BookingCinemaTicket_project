
package service;
import repository.UserAccountRepository;
/**
 * Servis za upravljanje korisničkim računima i autentikacijom.
 */
public class UserAccountService {
   private UserAccountRepository userRepository;
    /**
     * Konstruktor koji stvara novu instancu servisa s podrazumijevanim repozitorijem.
     */
   public UserAccountService() {
        this.userRepository = new UserAccountRepository();
    }
    /**
     * Kreira korisnički račun s navedenim podacima.
     *
     * @param firstName Ime korisnika
     * @param lastName Prezime korisnika
     * @param username Korisničko ime
     * @param password Lozinka
     * @return true ako je korisnički račun uspješno kreiran, false ako je korisničko ime već zauzeto
     */

    public boolean createUserAccount(String firstName, String lastName, String username, String password) {
        // Provjera je li korisničko ime već zauzeto
        if (userRepository.findByUsername(username)) {
            return false;
        }

        userRepository.save(firstName, lastName, username, password);
        return true;
    }
    /**
     * Provjerava valjanost korisničkog prijavljivanja.
     *
     * @param username Korisničko ime
     * @param password Lozinka
     * @return true ako je prijava uspješna, false ako prijava nije valjana
     */
    public boolean validateLogin(String username, String password) {
        return userRepository.validateLogin(username, password);
    }
}