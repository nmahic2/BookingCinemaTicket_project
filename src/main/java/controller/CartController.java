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
import java.util.Date;

public class CartController {
    @FXML
    private Menu Cart;
    @FXML
    private Menu Logout;
    @FXML
    private Menu Movies;
    //tabela,i dodavanje elemenata
    @FXML
    private TextField numberOfTickets;

    @FXML
    private TableView<Data> tableView;

    @FXML
    private TableColumn<Data, String> Movie;

    @FXML
    private TableColumn<Data, String> DateAndTime;

    @FXML
    private TableColumn<Data, Integer> NumberOfTickets;

    private int id = 0;

    private ObservableList<Data> dataListMovieCart = FXCollections.observableArrayList();

    //dugme za delete u update
    @FXML
    private Button deleteButton;

    @FXML
    private Button addButton;
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

  /*  @FXML
    private ListView<String> cartListView;
    @FXML
    private void initialize() {
        // Postavite CellFactory ako želite prilagoditi izgled svake stavke
        cartListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item);
                }
            }
        });
    }*/

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

    //************************


    //tabela i dodavanje elemenata
    public void addData(ActionEvent actionEvent) {

        NumberOfTickets.setCellValueFactory(new PropertyValueFactory<>("Number of tickets"));
        Movie.setCellValueFactory(new PropertyValueFactory<>("Movie"));
        DateAndTime.setCellValueFactory(new PropertyValueFactory<>("Date and time"));

        String dataB = Movie.getText();
        String dataC = DateAndTime.getText();
        int dataD = Integer.parseInt(NumberOfTickets.getText());

        dataListMovieCart.add(new Data(dataD, dataB, dataC));
        tableView.setItems(dataListMovieCart);

       /* NumberOfTickets.clear();
        Movie.clear();
        DateAndTime.clear();
        */
    }


    public class Data {
        private int NumberOfTickets;
        private String Movie;
        private String DateAndTime;

        public Data(int NumberOfTickets, String Movie, String DateAndTime) {
            this.Movie = Movie;
            this.NumberOfTickets = NumberOfTickets;
            this.DateAndTime = DateAndTime;
        }

        public int getNumberOfTickets() {
            return NumberOfTickets;
        }

        public void setNumberOfTickets(int numberOfTickets) {
            this.NumberOfTickets = numberOfTickets;
        }

        public String getMovie() {
            return Movie;
        }

        public void setMovie(String movie) {
            this.Movie = movie;
        }

        public String getDateAndTime() {
            return DateAndTime;
        }

        public void setDateAndTime(String dateAndTime) {
            this.DateAndTime = dateAndTime;
        }
    }

    //delete i update dugme u product and brand
    @FXML
    void deleteData(javafx.event.ActionEvent event) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tableView.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            //prozor za ispisivanje poruke
            alert.setTitle("No Selection");
            alert.setHeaderText("No Data Selected");
            alert.setContentText("Please select a data in the table.");
            alert.showAndWait();
        }
    }


}
