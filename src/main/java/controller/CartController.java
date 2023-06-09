package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import service.PriceDBService;
import repository.PriceDBRepository;

/**
 * Kontroler koji upravlja procesom Korpe gdje biramo datum, vrijeme, film i broj karata.
 */
public class CartController {
    private PriceDBRepository priceDBRepository;
    private PriceDBService priceDBService;
    @FXML
    public TextField pay;
    @FXML
    public TextField subtotal;
    @FXML
    public TextField balanceTextField;
    @FXML
    private Menu Cart;
    @FXML
    private Menu Logout;
    @FXML
    private Menu movies;
    //tabela,i dodavanje elemenata
    @FXML
    private TextField numberOfTickets;
    @FXML
    private TableView<CartController.Data> tableView;
    @FXML
    private TableColumn<CartController.Data, String> Movie;
    @FXML
    private TableColumn<CartController.Data, String> DateAndTime;
    @FXML
    private TableColumn<CartController.Data, Integer> NumberOfTickets;
    @FXML
    private TableColumn<Data, Integer> dataColumnPrice;
    @FXML
    private MenuButton movie;
    @FXML
    private MenuButton dateAndTime;
    private int id = 0;
    private ObservableList<CartController.Data> dataListMovieCart = FXCollections.observableArrayList();


    //dugme za delete u update
    @FXML
    private Button deleteButton;

    @FXML
    private Button addButton;

    /**
     * Konstruktor klase CartController.
     * Inicijalizira instancu klase CartController i povezuje je s potrebnim servisima i repozitorijima.
     */

    public CartController() {

        priceDBRepository = new PriceDBRepository();
        priceDBService = new PriceDBService();

    }

    /**
     * Metoda koja se poziva prilikom odjave korisnika.
     * Otvara novu scenu za prijavu nakon odjave.
     *
     * @param event Događaj koji je pokrenuo metodu.
     * @throws IOException U slučaju greške prilikom učitavanja FXML datoteke za prijavu.
     */
    @FXML
    void logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metoda koja postavlja scenu za prikaz glavnog menija.
     *
     * @param event Događaj koji je pokrenuo metodu.
     * @throws IOException U slučaju greške prilikom učitavanja FXML datoteke za glavni meni.
     */
    @FXML
    void setMovies(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/MainMenu.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metoda koja postavlja scenu za prikaz korpe.
     *
     * @param event Događaj koji je pokrenuo metodu.
     * @throws IOException U slučaju greške prilikom učitavanja FXML datoteke za korpu.
     */
    @FXML
    void setCart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Cart.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metoda koja postavlja scenu za prikaz računa.
     *
     * @param event Događaj koji je pokrenuo metodu.
     * @throws IOException U slučaju greške prilikom učitavanja FXML datoteke za račun.
     */
    @FXML
    void setInvoice(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Invoice.fxml"));
        Parent root = loader.load();

        // Otvaranje nove scene s drugim prozorom
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metoda koja dodaje podatke o filmu u korpu.
     * Podaci se prikazuju u tabeli korpe.
     *
     * @param actionEvent Događaj koji je pokrenuo metodu.
     */

    @FXML
    public void addData(ActionEvent actionEvent) {
        Movie.setCellValueFactory(new PropertyValueFactory<>("movie"));
        DateAndTime.setCellValueFactory(new PropertyValueFactory<>("dateAndTime"));
        NumberOfTickets.setCellValueFactory(new PropertyValueFactory<>("numberOfTickets"));
        dataColumnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        String movie = this.movie.getText();
        String dateAndTime = this.dateAndTime.getText();
        int numberOfTickets = Integer.parseInt(this.numberOfTickets.getText());

        int price = priceDBRepository.getPriceForMovie(movie); // Get the price from the PriceDBRepository
        int totalPrice = price * numberOfTickets; // Calculate the total price

        CartController.Data data = new CartController.Data(movie, dateAndTime, numberOfTickets, totalPrice); //novi objekat
        priceDBService.addData(data);

        dataListMovieCart.add(data);
        tableView.setItems(dataListMovieCart);

        this.numberOfTickets.clear();
        calculateSubtotal(); // Update the subtotal after adding the data

    }

    /**
     * Metoda koja uklanja odabrane podatke iz korpe.
     *
     * @param event Događaj koji je pokrenuo metodu.
     */
    @FXML
    void deleteData(ActionEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Data selectedData = tableView.getItems().get(selectedIndex);
            tableView.getItems().remove(selectedIndex);
            priceDBService.removeData(selectedData);
            calculateSubtotal(); // Update the subtotal after deleting the data
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Data Selected");
            alert.setContentText("Please select a data in the table.");
            alert.showAndWait();
        }
    }

    /**
     * Unutarnja klasa koja predstavlja podatke o filmu u korpi.
     */
    //data
    public static class Data {

        private int numberOfTickets;
        private String movie;
        private String dateAndTime;
        private int price;
        private int id;

        // private int retailPrice;

        /**
         * Konstruktor klase Data.
         *
         * @param movie           Naziv filma.
         * @param dateAndTime     Datum i vrijeme projekcije.
         * @param numberOfTickets Broj karata.
         * @param price           Cijena po karti.
         */

        public Data(String movie, String dateAndTime, int numberOfTickets, int price) {
            this.numberOfTickets = numberOfTickets;
            this.movie = movie;
            this.dateAndTime = dateAndTime;
            this.price = price;
            // this.retailPrice = price;
        }

        /**
         * Metoda koja vraća broj karata.
         *
         * @return Broj karata.
         */
        public int getNumberOfTickets() {
            return numberOfTickets;
        }

        /**
         * Metoda koja postavlja broj karata.
         *
         * @param numberOfTickets Broj karata koji se postavlja.
         */
        public void setNumberOfTickets(int numberOfTickets) {
            this.numberOfTickets = numberOfTickets;
        }

        /**
         * Metoda koja vraća naziv filma.
         *
         * @return Naziv filma.
         */
        public String getMovie() {
            return movie;
        }

        /**
         * Metoda koja postavlja naziv filma.
         *
         * @param movie Naziv filma koji se postavlja.
         */
        public void setMovie(String movie) {
            this.movie = movie;
        }

        /**
         * Metoda koja vraća datum i vrijeme projekcije.
         *
         * @return Datum i vrijeme projekcije.
         */
        public String getDateAndTime() {
            return dateAndTime;
        }

        /**
         * Metoda koja postavlja datum i vrijeme projekcije.
         *
         * @param dateAndTime Datum i vrijeme projekcije koji se postavljaju.
         */
        public void setDateAndTime(String dateAndTime) {
            this.dateAndTime = dateAndTime;
        }

        /**
         * Metoda koja vraća cijenu.
         *
         * @return Cijena.
         */
        public int getPrice() {
            return price;
        }

        /**
         * Metoda koja postavlja cijenu.
         *
         * @param price Cijena koja se postavlja.
         */
        public void setPrice(int price) {
            this.price = price;
        }

        /**
         * Metoda koja ažurira cijenu na osnovu broja karata.
         * Ažurirana cijena je umnožak originalne cijene i broja karata.
         */
        private void updatePrice() {
            this.price = this.price * this.numberOfTickets;
        }

        /**
         * Metoda koja postavlja ID.
         *
         * @param id ID koji se postavlja.
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * Metoda koja vraća ID.
         *
         * @return ID.
         */
        public int getId() {
            return id;
        }


    }

    /**
     * Metoda koja se poziva prilikom odabira filma iz menija.
     *
     * @param actionEvent Događaj koji je pokrenuo metodu.
     */
    @FXML
    void selectMovie(ActionEvent actionEvent) {
        MenuItem selectedItem = (MenuItem) actionEvent.getSource();
        String selectedCategory = selectedItem.getText();
        movie.setText(selectedCategory);
    }

    /**
     * Metoda koja se poziva prilikom odabira datuma i vremena iz menija.
     *
     * @param actionEvent Događaj koji je pokrenuo metodu.
     */
    @FXML
    void selectDateAndTime(ActionEvent actionEvent) {
        MenuItem selectedItem = (MenuItem) actionEvent.getSource();
        String selectedCategory = selectedItem.getText();
        dateAndTime.setText(selectedCategory);
    }

    /**
     * Metoda koja izračunava ukupnu cijenu za sve stavke u košarici.
     * Prikazuje izračunatu sumu u polju za subtotal.
     */

    @FXML
    void calculateSubtotal() {
        int subtotalPrice = 0;
        for (Data data : dataListMovieCart) {
            subtotalPrice += data.getPrice();
        }

        subtotal.setText(Integer.toString(subtotalPrice));
    }

    /**
     * Metoda koja se poziva prilikom inicijalizacije kontrolera.
     * Učitava sve filmove iz PriceDBRepository-a i popunjava izbornik za odabir filma.
     */
   @FXML
    public void initialize() {
        List<String> movies = priceDBRepository.getAllMovies();
        populateMovieMenu(movies);
    }

    /**
     * Metoda koja popunjava izbornik za odabir filma s listom filmova.
     *
     * @param movies Lista filmova.
     */
    private void populateMovieMenu(List<String> movies) {
        ObservableList<MenuItem> movieItems = movie.getItems(); // Dohvatite referencu na listu stavki MenuButton-a

        for (String movie : movies) {
            MenuItem menuItem = new MenuItem(movie);
            menuItem.setOnAction(this::selectMovie);
            movieItems.add(menuItem); // Dodajte stavku u listu stavki MenuButton-a
        }
    }


}



