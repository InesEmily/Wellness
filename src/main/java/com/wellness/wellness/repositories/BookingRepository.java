package com.wellness.wellness.repositories;

import com.wellness.wellness.model.Booking;
import com.wellness.wellness.model.Client;
import com.wellness.wellness.model.Room;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Book;
import java.util.Optional;

public interface BookingRepository extends CrudRepository<Booking,Integer> {
    Iterable<Booking>findByRoom(Optional<Room> room);
    Iterable<Booking>findByClient(Optional<Client> client);
}
