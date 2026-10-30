package com.example.demo.Services.implementation;

import com.example.demo.Repository.IVehiculeRepository;
import com.example.demo.Services.IVehiculeSercices;
import com.example.demo.Vehicule;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VehiculeServices implements IVehiculeSercices
{
    private final IVehiculeRepository ivehiculeRepository;

    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        return ivehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule getVehicule(Long id) {
        return ivehiculeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("vehicule not found"));
    }

    @Override
    public Vehicule updateVehicule(Long id,Vehicule vehicule) {
        return ivehiculeRepository.save(vehicule);
    }

    @Override
    public void deleteVehicule(Long id) {
        ivehiculeRepository.deleteById(id);
    }

    @Override
    public List<Vehicule> getAll() {

        return ivehiculeRepository.findAll();
    }
}
