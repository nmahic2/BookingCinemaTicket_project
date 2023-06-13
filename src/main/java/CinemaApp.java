/*import java.util.Scanner;

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
        System.out.println("1. Monster house");
        System.out.println("2. Justice legue");
        System.out.println("3. Southland tales");
        System.out.println("4. Anette");
        System.out.println("5. Spiderman");
        System.out.println("6. Onward");
        System.out.println("7. The Gray");
        System.out.println("8. The legend of Zorro");

        int choice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("Unesite broj filma: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 8) {
                    validChoice = true;
                } else {
                    System.out.println("Nevažeći unos. Molimo odaberite broj između 1 i 8.");
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
                movieName = "Monster house";
                break;
            case 2:
                movieName = "Justice legue";
                break;
            case 3:
                movieName = "Southland tales";
                break;
            case 4:
                movieName = "Anette";
                break;
            case 5:
                movieName = "Spiderman";
                break;
            case 6:
                movieName = "Onward";
                break;
            case 7:
                movieName = "The Gray";
                break;
            case 8:
                movieName = "The legend of Zorro";
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
*/
import java.util.Scanner;

public class CinemaApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TicketBuilder ticketBuilder = new TicketBuilder();

        login();
        String movieName = selectMovie();
        int numberOfTickets = selectNumberOfTickets();
        String date = selectDate();

        Ticket ticket = ticketBuilder
                .setMovieName(movieName)
                .setNumberOfTickets(numberOfTickets)
                .setDate(date)
                .build();

        System.out.println(ticket);
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
        System.out.println("1. Monster house");
        System.out.println("2. Justice legue");
        System.out.println("3. Southland tales");
        System.out.println("4. Anette");
        System.out.println("5. Spiderman");
        System.out.println("6. Onward");
        System.out.println("7. The Gray");
        System.out.println("8. The legend of Zorro");

        int choice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("Unesite broj filma: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 8) {
                    validChoice = true;
                } else {
                    System.out.println("Nevažeći unos. Molimo odaberite broj između 1 i 8.");
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
                movieName = "Monster house";
                break;
            case 2:
                movieName = "Justice legue";
                break;
            case 3:
                movieName = "Southland tales";
                break;
            case 4:
                movieName = "Anette";
                break;
            case 5:
                movieName = "Spiderman";
                break;
            case 6:
                movieName = "Onward";
                break;
            case 7:
                movieName = "The Gray";
                break;
            case 8:
                movieName = "The legend of Zorro";
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
}

class Ticket {
    private String movieName;
    private int numberOfTickets;
    private String date;

    public Ticket(String movieName, int numberOfTickets, String date) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.date = date;
    }

    @Override
    public String toString() {
        double ticketPrice = numberOfTickets * 5.0;
        return "Karta je uspješno rezervirana!\n" +
                "Film: " + movieName + "\n" +
                "Broj karata: " + numberOfTickets + "\n" +
                "Datum: " + date + "\n" +
                "Cijena karata: " + ticketPrice + " BAM\n" +
                "Karte mogu biti preuzete na blagajni.";
    }
}

class TicketBuilder {
    private String movieName;
    private int numberOfTickets;
    private String date;

    public TicketBuilder setMovieName(String movieName) {
        this.movieName = movieName;
        return this;
    }

    public TicketBuilder setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
        return this;
    }

    public TicketBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public Ticket build() {
        return new Ticket(movieName, numberOfTickets, date);
    }
}
