package com.example.demo.Services;

import com.example.demo.Vehicule;

import java.util.List;

public interface IVehiculeSercices
{
    Vehicule addVehicule (Vehicule vehicule);
    Vehicule getVehicule(Long id);
    Vehicule updateVehicule (Long id, Vehicule vehicule);
    void deleteVehicule(Long id);
    List<Vehicule> getAll();
}
