package service;


import controller.CartController;
import repository.PriceDBRepository;

import java.util.List;

/**
 * Servis za upravljanje podacima vezanim uz cijene i filmove.
 */
public class PriceDBService {
    private PriceDBRepository priceDBRepository;

    /**
     * Konstruktor koji stvara novu instancu servisa s podrazumijevanim repozitorijem.
     */
    public PriceDBService() {
        priceDBRepository = new PriceDBRepository();
    }

    /**
     * Konstruktor koji stvara novu instancu servisa s određenim repozitorijem.
     *
     * @param priceDBRepository Repozitorij za cijene i filmove
     */
    public PriceDBService(PriceDBRepository priceDBRepository) {
        this.priceDBRepository = priceDBRepository;
    }

    /**
     * Dodaje podatke o kartici u repozitorij.
     *
     * @param data Podaci o kartici
     */
    public void addData(CartController.Data data) {
        priceDBRepository.addData(data);
    }

    /**
     * Dohvaća sve filmove iz repozitorija.
     *
     * @return Lista svih filmova
     */
    public List<String> getAllMovies() {
        return priceDBRepository.getAllMovies();
    }

    /**
     * Uklanja podatke o kartici iz repozitorija.
     *
     * @param data Podaci o kartici za uklanjanje
     */
    public void removeData(CartController.Data data) {
        priceDBRepository.removeData(data);
    }


}

