package service;

import repository.TicketPriceRepository;

public class TicketServiceImpl implements TicketService {
    private final TicketPriceRepository ticketPriceRepository;

    public TicketServiceImpl(TicketPriceRepository ticketPriceRepository) {
        this.ticketPriceRepository = ticketPriceRepository;
    }

    @Override
    public double getTicketPrice(String movieName) {
        return ticketPriceRepository.getTicketPrice(movieName);
    }
}
