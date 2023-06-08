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

/*public class PriceDBService {
    private static PriceDBRepository priceDBRepository;*/

   /* public PriceDBService() {
        priceDBRepository = new PriceDBRepository();
    }*/
/*
    public void addData( CartController.Data data) {

        priceDBRepository.addData(data);

    }*/
/*
    public List<String> getAllMovies() {
        return priceDBRepository.getAllMovies();
    }*/
/*
    public static void removeData(CartController.Data data) {
        priceDBRepository.removeData(data);
    }
*/
    /*
    public PriceDBService(PriceDBRepository priceDBRepository) {
        this.priceDBRepository = priceDBRepository;
    }

}*/

public class PriceDBService {
    private PriceDBRepository priceDBRepository;

    public PriceDBService() {
        priceDBRepository = new PriceDBRepository();
    }

    public PriceDBService(PriceDBRepository priceDBRepository) {
        this.priceDBRepository = priceDBRepository;
    }

    public void addData(CartController.Data data) {
        priceDBRepository.addData(data);
    }

    public List<String> getAllMovies() {
        return priceDBRepository.getAllMovies();
    }

    public void removeData(CartController.Data data) {
        priceDBRepository.removeData(data);
    }



}

