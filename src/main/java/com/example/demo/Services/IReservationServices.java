package com.example.demo.Services;


import com.example.demo.Reservation;

import java.util.List;

public interface IReservationServices {
    Reservation addReservation (Reservation reservation);
    Reservation getReservation(Long id);
    Reservation updateReservation (Long id, Reservation reservation);
    void deleteReservation(Long id);
    List<Reservation> getAll();
}
