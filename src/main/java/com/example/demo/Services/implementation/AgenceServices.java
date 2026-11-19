package com.example.demo.Services.implementation;

import com.example.demo.Repository.IAgenceRepository;
import com.example.demo.Repository.IVehiculeRepository;
import com.example.demo.Agence;
import com.example.demo.Services.IAgenceServices;
import com.example.demo.Services.IVehiculeSercices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServices implements IAgenceServices {
    private final IAgenceRepository iAgenceRepository;
    @Override
    public Agence addAgence(Agence agence) {

        return iAgenceRepository.save(agence);
    }

    @Override
    public Agence getAgence(Long id) {
        return null;
    }

    @Override
    public Agence updateAgence(Long id, Agence agence) {
        return null;
    }

    @Override
    public void deleteAgence(Long id) {

    }

    @Override
    public List<Agence> getAll() {
        return List.of();
    }
}
