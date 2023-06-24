
import java.util.Scanner;

/**
 * Aplikacija za rezervaciju karata za kino.
 */
public class CinemaApp {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Glavna metoda koja pokreće aplikaciju za rezervaciju karata za kino.
     *
     * @param args Argumenti komandne linije
     */
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

    /**
     * Metoda za prijavu korisnika.
     */
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

    /**
     * Metoda za odabir filma.
     *
     * @return Odabrani naziv filma
     */
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

    /**
     * Metoda za odabir broja karata.
     *
     * @return Odabrani broj karata
     */
    private static int selectNumberOfTickets() {
        System.out.print("Unesite broj karata: ");
        int numberOfTickets = scanner.nextInt();
        scanner.nextLine(); // Prazni red nakon unosa broja karata
        System.out.println("Odabrali ste " + numberOfTickets + " karata.");
        return numberOfTickets;
    }

    /**
     * Metoda za odabir datuma.
     *
     * @return Odabrani datum
     */
    private static String selectDate() {
        System.out.println("Odaberite datum:");
        System.out.println("1. 2023-06-15");
        System.out.println("2. 2023-06-16");
        System.out.println("3. 2023-06-17");

        int choice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("Unesite broj datuma: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) {
                    validChoice = true;
                } else {
                    System.out.println("Nevažeći unos. Molimo odaberite broj između 1 i 3.");
                }
            } else {
                System.out.println("Nevažeći unos. Molimo unesite broj datuma.");
                scanner.next(); // Preskoči neispravan unos
            }
        }

        scanner.nextLine(); // Prazni red nakon unosa broja datuma

        String date;
        switch (choice) {
            case 1:
                date = "2023-06-15";
                break;
            case 2:
                date = "2023-06-16";
                break;
            case 3:
                date = "2023-06-17";
                break;
            default:
                date = "Nepoznat datum";
                break;
        }

        System.out.println("Odabrali ste datum: " + date);
        return date;
    }
}

/**
 * Klasa koja predstavlja kartu za film.
 */
class Ticket {
    private String movieName;
    private int numberOfTickets;
    private String date;

    /**
     * Konstruktor za stvaranje karte.
     *
     * @param movieName       Naziv filma
     * @param numberOfTickets Broj karata
     * @param date            Datum
     */
    public Ticket(String movieName, int numberOfTickets, String date) {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.date = date;
    }

    /**
     * Vraća tekstualni prikaz karte za film.
     *
     * @return Tekstualni prikaz karte za film
     */
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

/**
 * Builder klasa za stvaranje karte.
 */
class TicketBuilder {
    private String movieName;
    private int numberOfTickets;
    private String date;

    /**
     * Postavlja naziv filma.
     *
     * @param movieName Naziv filma
     * @return Trenutna instanca TicketBuilder-a
     */
    public TicketBuilder setMovieName(String movieName) {
        this.movieName = movieName;
        return this;
    }

    /**
     * Postavlja broj karata.
     *
     * @param numberOfTickets Broj karata
     * @return Trenutna instanca TicketBuilder-a
     */
    public TicketBuilder setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
        return this;
    }

    /**
     * Postavlja datum.
     *
     * @param date Datum
     * @return Trenutna instanca TicketBuilder-a
     */
    public TicketBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    /**
     * Stvara novu instancu karte koristeći postavljene vrijednosti.
     *
     * @return Nova instanca Ticket-a
     */
    public Ticket build() {
        return new Ticket(movieName, numberOfTickets, date);
    }
}
