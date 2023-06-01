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


public class CartController {
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
    private MenuButton movie;
    @FXML
    private MenuButton dateAndTime;

    private int id = 0;

    private ObservableList<CartController.Data>dataListMovieCart = FXCollections.observableArrayList();

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
    @FXML
    public void addData(ActionEvent actionEvent) {

        NumberOfTickets.setCellValueFactory(new PropertyValueFactory<>("numberOfTickets"));
        Movie.setCellValueFactory(new PropertyValueFactory<>("movie"));
        DateAndTime.setCellValueFactory(new PropertyValueFactory<>("dateAndTime"));

        String dataB = movie.getText();
        String dataC = dateAndTime.getText();
        int dataD = Integer.parseInt(numberOfTickets.getText());


        dataListMovieCart.add(new Data(dataB, dataC, dataD));
        tableView.setItems(dataListMovieCart);

      numberOfTickets.clear();

    }
//data
   public static class Data {
       private int numberOfTickets;
       private String movie;
       private String dateAndTime;

       public Data( String movie, String dateAndTime, int numberOfTickets) {
           this.numberOfTickets = numberOfTickets;
           this.movie = movie;
           this.dateAndTime = dateAndTime;
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
   }

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


}
