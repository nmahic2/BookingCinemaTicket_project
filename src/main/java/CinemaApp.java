import java.util.Scanner;

public class CinemaApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        login();
        String movieName = selectMovie();
        int numberOfTickets = selectNumberOfTickets();
        String date = selectDate();
        printTicket(movieName, numberOfTickets, date);
    }

    private static void login() {
        System.out.println("Dobrodošli! Molimo prijavite se.");
        System.out.print("Korisničko ime: ");
        String username = scanner.nextLine();
        System.out.print("Lozinka: ");
        String password = scanner.nextLine();
        // Provjera korisničkog imena i lozinke
        // Implementirajte logiku provjere korisničkih podataka ovdje
        System.out.println("Prijavili ste se kao " + username);
    }

    private static String selectMovie() {
        System.out.println("Odaberite film:");
        System.out.println("1. Film 1");
        System.out.println("2. Film 2");
        System.out.println("3. Film 3");

        int choice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("Unesite broj filma: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) {
                    validChoice = true;
                } else {
                    System.out.println("Nevažeći unos. Molimo odaberite broj između 1 i 3.");
                }
            } else {
                System.out.println("Nevažeći unos. Molimo unesite broj filma.");
                scanner.next(); // Preskoči neispravan unos
            }
        }

        scanner.nextLine(); // Prazni red nakon unosa broja filma

        String movieName;
        switch (choice) {
            case 1:
                movieName = "Film 1";
                break;
            case 2:
                movieName = "Film 2";
                break;
            case 3:
                movieName = "Film 3";
                break;
            default:
                movieName = "Nepoznat film";
                break;
        }

        System.out.println("Odabrali ste film: " + movieName);
        return movieName;
    }


    private static int selectNumberOfTickets() {
        System.out.print("Unesite broj karata: ");
        int numberOfTickets = scanner.nextInt();
        scanner.nextLine(); // Prazni red nakon unosa broja karata
        System.out.println("Odabrali ste " + numberOfTickets + " karata.");
        return numberOfTickets;
    }

    private static String selectDate() {
        System.out.print("Unesite datum: ");
        String date = scanner.nextLine();
        System.out.println("Odabrali ste datum: " + date);
        return date;
    }

    private static void printTicket(String movieName, int numberOfTickets, String date) {
        double ticketPrice = numberOfTickets * 5.0; // Izračun cijene karata
        System.out.println("Karta je uspješno rezervirana!");
        System.out.println("Film: " + movieName);
        System.out.println("Broj karata: " + numberOfTickets);
        System.out.println("Datum: " + date);
        System.out.println("Cijena karata: " + ticketPrice + " BAM");
        System.out.println("Karte mogu biti preuzete na blagajni.");
    }
}
