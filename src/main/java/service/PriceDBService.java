package service;



import controller.CartController;
import repository.PriceDBRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static java.sql.DriverManager.getConnection;


/*
public class PriceDBService {
    private static PriceDBRepository PriceDBRepository;

    public PriceDBService() {
        PriceDBRepository = new PriceDBRepository();
    }

    public void addData(String movie, String dateAndTime, int numberOfTickets, int price) {
        CartController.Data data = new CartController.Data(movie, dateAndTime, numberOfTickets);
        PriceDBRepository.addData(data);
    }

    public static void removeData(CartController.Data data) {
        PriceDBRepository.removeData(data);
    }

}*/

public class PriceDBService {
    private static PriceDBRepository priceDBRepository;

    public PriceDBService() {
        priceDBRepository = new PriceDBRepository();
    }

    public void addData(String movie, String dateAndTime, int numberOfTickets) {
        int price = priceDBRepository.getPriceForMovie(movie); // Dobijanje cijene filma iz PriceDBRepository
        int totalPrice = price * numberOfTickets; // Množenje cijene sa brojem karata
        CartController.Data data = new CartController.Data(movie, dateAndTime, numberOfTickets, totalPrice);
        priceDBRepository.addData(data);
    }

    public List<String> getAllMovies() {
        return priceDBRepository.getAllMovies();
    }

    public static void removeData(CartController.Data data) {
        priceDBRepository.removeData(data);
    }
    public PriceDBService(PriceDBRepository priceDBRepository) {
        this.priceDBRepository = priceDBRepository;
    }

}


