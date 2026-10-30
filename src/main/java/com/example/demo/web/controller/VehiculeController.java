package com.example.demo.web.controller;

import com.example.demo.Services.IVehiculeSercices;
import com.example.demo.Vehicule;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping("{id}")
    Vehicule modifierVehicule(@PathVariable Long id ,@RequestBody Vehicule vehicule)
    {
        return iVehiculeServices.updateVehicule(id,vehicule);
    }
    @DeleteMapping("{id}")
    void deleteVehicule(@PathVariable Long id){
        iVehiculeServices.deleteVehicule(id);

    }
    @GetMapping
    List<Vehicule> afficherVehicule(){
        return iVehiculeServices.getAll();
    }
}
