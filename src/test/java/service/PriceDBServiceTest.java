package service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.PriceDBRepository;
import controller.CartController;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Testira funkcionalnosti klase PriceDBService.
 */
public class PriceDBServiceTest {
    private PriceDBRepository priceDBRepository;
    private PriceDBService priceDBService;

    /**
     * Priprema potrebnih objekata prije svakog testa.
     */
    @BeforeEach
    public void setUp() {
        priceDBRepository = new PriceDBRepository();
        priceDBService = new PriceDBService(priceDBRepository);
    }

    /**
     * Testira dodavanje podataka u repozitorij.
     */
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
    /**
     * Testira uklanjanje podataka iz repozitorija.
     */
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
    /**
     * Testira dobavljanje svih filmova iz repozitorija.
     */
    @Test
    public void testGetAllMovies() {
        // Arrange
        String movie1 = "monser house";
        String movie2 = "justice legue";
        String movie3 = "southland tales";
        String movie4 = "anete";
        String movie5 = "spiderman";
        String movie6 = "onward";
        String movie7 = "the gray";
        String movie8 = "the legend of zorro";
        priceDBRepository.addData(new CartController.Data(movie1, "10.06.2023 at 13:00h", 2, 10));
        priceDBRepository.addData(new CartController.Data(movie2, "10.06.2023 at 13:00h", 3, 15));
        priceDBRepository.addData(new CartController.Data(movie3, "10.06.2023 at 13:00h", 1, 5));
        priceDBRepository.addData(new CartController.Data(movie4, "10.06.2023 at 13:00h", 1, 5));
        priceDBRepository.addData(new CartController.Data(movie5, "10.06.2023 at 13:00h", 1, 5));
        priceDBRepository.addData(new CartController.Data(movie6, "10.06.2023 at 13:00h", 1, 5));
        priceDBRepository.addData(new CartController.Data(movie7, "10.06.2023 at 13:00h", 1, 5));
        priceDBRepository.addData(new CartController.Data(movie8, "10.06.2023 at 13:00h", 1, 5));

        List<String> expectedMovies = Arrays.asList(movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8);

        // Act
        List<String> movies = priceDBService.getAllMovies();

        // Assert
        assertEquals(expectedMovies, movies, "Returned movies list does not match the expected movies");
    }
}

