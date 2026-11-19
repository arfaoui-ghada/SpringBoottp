package com.example.demo.web.controller;


import com.example.demo.Agence;
import com.example.demo.Reservation;
import com.example.demo.Services.IAgenceServices;
import com.example.demo.Services.IReservationServices;
import com.example.demo.Vehicule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("reservation")
public class ReservationController {
    private final IReservationServices IReservationServices;
    @PostMapping("add")
    public Reservation createReservation (@RequestBody Reservation reservation){
        return IReservationServices.addReservation(reservation);
    }
}
