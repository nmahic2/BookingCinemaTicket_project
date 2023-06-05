package service;
/*
import repository.UserAccountRepository;

public class UserAccountService {
    private static UserAccountRepository userRepository;

    public UserAccountService() {
        this.userRepository = new UserAccountRepository();
    }

    public static boolean createUserAccount(String firstName, String lastName, String username, String password) {
        // Provjera je li korisničko ime već zauzeto
        if (userRepository.findByUsername(username)) {
            return false;
        }

        userRepository.save(firstName, lastName, username, password);
        return true;
    }

    public boolean validateLogin(String username, String password) {
        return userRepository.validateLogin(username, password);
    }
}
*/


import repository.UserAccountRepository;

public class UserAccountService {
    private UserAccountRepository userRepository;

    public UserAccountService() {
        this.userRepository = new UserAccountRepository();
    }

    public boolean createUserAccount(String firstName, String lastName, String username, String password) {
        // Provjera je li korisničko ime već zauzeto
        if (userRepository.findByUsername(username)) {
            return false;
        }

        userRepository.save(firstName, lastName, username, password);
        return true;
    }

    public boolean validateLogin(String username, String password) {
        return userRepository.validateLogin(username, password);
    }
}
