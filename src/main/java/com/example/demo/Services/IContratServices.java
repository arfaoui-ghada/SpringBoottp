package com.example.demo.Services;


import com.example.demo.Contrat;

import java.util.List;

public interface IContratServices {
    Contrat addContrat (Contrat contrat);
    Contrat getContrat(Long id);
    Contrat updateContrat (Long id, Contrat contrat);
    void deleteContrat(Long id);
    List<Contrat> getAll();
}
