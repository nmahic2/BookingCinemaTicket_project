package service;



import controller.CartController;
import repository.PriceDBRepository;

import java.util.List;


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

