package com.example.demo.Services;

import com.example.demo.Agence;

import java.util.List;

public interface IAgenceServices {
    Agence addAgence (Agence agence);
    Agence getAgence(Long id);
    Agence updateAgence (Long id, Agence agence);
    void deleteAgence(Long id);
    List<Agence> getAll();
}
