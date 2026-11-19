package com.example.demo.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Contrat;
import com.example.demo.Services.implementation.LocationManager;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationManager locationManager;

    public LocationController(LocationManager locationManager) {
        this.locationManager = locationManager;
    }

    @PostMapping("/{reservationId}/confirmer")
    public Contrat confirmer(
            @PathVariable Long reservationId,
            @RequestParam String modePaiement,
            @RequestParam(required = false) String codePromo,
            @RequestParam String canal) {
        return locationManager.confirmerReservation(reservationId, modePaiement, codePromo, canal);
    }
}
