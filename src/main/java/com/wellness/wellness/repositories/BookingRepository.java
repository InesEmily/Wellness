package com.wellness.wellness.repositories;

import com.wellness.wellness.model.Booking;
import com.wellness.wellness.model.Client;
import com.wellness.wellness.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends CrudRepository<Booking,Integer> {
    Iterable<Booking>findByRoom(Optional<Room> room);
    Iterable<Booking>findByClient(Optional<Client> client);
    List<Booking> findAllByDate(@Param("date")LocalDate date);

    List<Booking>findAllBy();

    @Query("select b from Booking b where (:keyword IS NULL or upper(b.client.name) like upper(concat('%',:keyword,'%'))  or upper(b.client.lastName) like upper(concat('%',:keyword,'%'))) AND"+
            " (:roomName is Null or upper(b.room.name) like upper(concat('%',:roomName,'%') )) and (:date is null or b.date =:date)")
    List<Booking> findByfilter(@Param("keyword") String keyword, @Param("roomName") String roomName, @Param("date")LocalDate date);





}
