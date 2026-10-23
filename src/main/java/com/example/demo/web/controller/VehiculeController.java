package com.example.demo.web.controller;

import com.example.demo.Services.IVehiculeSercices;
import com.example.demo.Vehicule;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("vehicule")
public class VehiculeController {
    private final IVehiculeSercices iVehiculeServices;
    @PostMapping("add")
    Vehicule createVehicule (@RequestBody Vehicule vehicule){
        return iVehiculeServices.addVehicule(vehicule);
    }
    @GetMapping("{id}")
    Vehicule getVehicule(@PathVariable Long id){
        return iVehiculeServices.getVehicule(id);
    }
}
