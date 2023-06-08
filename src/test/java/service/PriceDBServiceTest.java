package service;
/*
import org.junit.Test;

import static org.junit.Assert.*;
import controller.CartController;
import service.PriceDBService;
import repository.PriceDBRepository;
public class PriceDBServiceTest {

  @Test
public void testAddData() {

}

    @Test
    public void getAllMovies() {
    }

    @Test
    public void removeData() {
    }
}

*/import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.PriceDBRepository;
import controller.CartController;

import static org.junit.jupiter.api.Assertions.*;

public class PriceDBServiceTest {
    private PriceDBRepository priceDBRepository;
    private PriceDBService priceDBService;

    @BeforeEach
    public void setUp() {
        priceDBRepository = new PriceDBRepository();
        priceDBService = new PriceDBService(priceDBRepository);
    }


    @Test
    public void testAddData() {
        // Arrange
        String movie = "monster house";
        String dateAndTime = "10.06.2023 at 13:00h";
        int numberOfTickets = 2;
        int price = 5;
        int totalPrice = price * numberOfTickets;
        CartController.Data expectedData = new CartController.Data(movie, dateAndTime, numberOfTickets, totalPrice);

        // Act
        priceDBService.addData(expectedData);

        // Assert
        assertTrue(priceDBRepository.getDataList().contains(expectedData), "Expected data not found in the repository");
    }

    @Test
    public void testRemoveData() {
        // Arrange
        String movie = "monster house";
        String dateAndTime = "10.06.2023 at 13:00h";
        int numberOfTickets = 2;
        int price = 5;
        int totalPrice = price * numberOfTickets;
        CartController.Data data = new CartController.Data(movie, dateAndTime, numberOfTickets, totalPrice);
        priceDBRepository.addData(data);

        // Act
        priceDBService.removeData(data);

        // Assert
        assertFalse(priceDBRepository.getDataList().contains(data), "Removed data still found in the repository");
    }
}
