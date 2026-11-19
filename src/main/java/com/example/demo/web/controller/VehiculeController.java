package com.example.demo.web.controller;

import com.example.demo.Services.IVehiculeSercices;
import com.example.demo.Vehicule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name ="VehiculeGhada", description = "Gestion : vehicule")
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
    @ApiResponse( responseCode = "200")
    @Operation(summary = "yjibli les vehicules")
    @GetMapping
    List<Vehicule> afficherVehicule(){
        return iVehiculeServices.getAll();
    }
}
