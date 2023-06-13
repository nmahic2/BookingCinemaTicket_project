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




    public CartController() {

        priceDBRepository = new PriceDBRepository();
        priceDBService = new PriceDBService();

    }

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

       CartController.Data data = new CartController.Data(movie, dateAndTime, numberOfTickets, totalPrice);
       priceDBService.addData(data);

       dataListMovieCart.add(data);
       tableView.setItems(dataListMovieCart);

       this.numberOfTickets.clear();
       calculateSubtotal(); // Update the subtotal after adding the data

   }

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


    //data
    public static class Data {

        private int numberOfTickets;
        private String movie;
        private String dateAndTime;
        private int price;
        private int id;

        // private int retailPrice;
        public Data(String movie, String dateAndTime, int numberOfTickets, int price) {
            this.numberOfTickets = numberOfTickets;
            this.movie = movie;
            this.dateAndTime = dateAndTime;
            this.price = price;
            // this.retailPrice = price;
        }

        public int getNumberOfTickets() {
            return numberOfTickets;
        }

        public void setNumberOfTickets(int numberOfTickets) {
            this.numberOfTickets = numberOfTickets;
        }

        public String getMovie() {
            return movie;
        }

        public void setMovie(String movie) {
            this.movie = movie;
        }

        public String getDateAndTime() {
            return dateAndTime;
        }

        public void setDateAndTime(String dateAndTime) {
            this.dateAndTime = dateAndTime;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        private void updatePrice() {
            this.price = this.price * this.numberOfTickets;
        }


        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }


    }


    @FXML
    void selectMovie(ActionEvent actionEvent) {
        MenuItem selectedItem = (MenuItem) actionEvent.getSource();
        String selectedCategory = selectedItem.getText();
        movie.setText(selectedCategory);
    }


    @FXML
    void selectDateAndTime(ActionEvent actionEvent) {
        MenuItem selectedItem = (MenuItem) actionEvent.getSource();
        String selectedCategory = selectedItem.getText();
        dateAndTime.setText(selectedCategory);
    }

  /*  @FXML
    void calculateSubtotal() {
        int subtotalPrice = 0;
        for (Data data : dataListMovieCart) {
            subtotalPrice += data.getNumberOfTickets() * data.getPrice();
        }

        subtotal.setText(Integer.toString(subtotalPrice));
    }
*/
  @FXML
  void calculateSubtotal() {
      int subtotalPrice = 0;
      for (Data data : dataListMovieCart) {
          subtotalPrice += data.getPrice();
      }

      subtotal.setText(Integer.toString(subtotalPrice));
  }


    @FXML
    public void initialize() {
        List<String> movies = priceDBRepository.getAllMovies();
        populateMovieMenu(movies);
    }

    private void populateMovieMenu(List<String> movies) {
        ObservableList<MenuItem> movieItems = movie.getItems(); // Dohvatite referencu na listu stavki MenuButton-a

        for (String movie : movies) {
            MenuItem menuItem = new MenuItem(movie);
            menuItem.setOnAction(this::selectMovie);
            movieItems.add(menuItem); // Dodajte stavku u listu stavki MenuButton-a
        }
    }



}



