package service;

import controller.CartController;
import repository.PriceDBRepository;


public class PriceDBService {
    private PriceDBRepository PriceDBRepository;

    public PriceDBService() {
        PriceDBRepository = new PriceDBRepository();
    }

    public void addData(String movie, String dateAndTime, int numberOfTickets, int price) {
        CartController.Data data = new CartController.Data(movie, dateAndTime, numberOfTickets);
        PriceDBRepository.addData(data);
    }

    public void removeData(CartController.Data data) {
        PriceDBRepository.removeData(data);
    }







}