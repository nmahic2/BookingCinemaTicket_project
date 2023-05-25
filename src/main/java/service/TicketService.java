package service;
/*
import repository.MovieRepository;
import model.CartItem;
import model.Movie;
import repository.MovieRepository;

public class CartService {
    private MovieRepository movieRepository;

    public CartService() {
        movieRepository = new MovieRepository();
    }

    public void addCartItem(CartItem cartItem) {
        // Dodaj stavku u košaricu
        // Pozovi metode za validaciju i obradu podataka

        // Primjer: Dohvati cijenu filma iz baze podataka na temelju naziva filma
        Movie movie = movieRepository.getMovieByTitle(cartItem.getMovieTitle());
        if (movie != null) {
            double totalPrice = movie.getPrice() * cartItem.getNumberOfTickets();
            cartItem.setTotalPrice(totalPrice);
        }
    }

    public void removeCartItem(CartItem cartItem) {
        // Ukloni stavku iz košarice
        // Pozovi metode za obradu podataka
    }
}
*/