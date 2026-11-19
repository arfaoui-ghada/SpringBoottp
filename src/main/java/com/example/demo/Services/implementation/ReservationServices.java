package com.example.demo.Services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Reservation;
import com.example.demo.Repository.IReservationRepository;
import com.example.demo.Services.IReservationServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServices implements IReservationServices {

    private final IReservationRepository reservationRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found"));
    }

    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {
        reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found"));
        reservation.setIdReservation(id);
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }
}
