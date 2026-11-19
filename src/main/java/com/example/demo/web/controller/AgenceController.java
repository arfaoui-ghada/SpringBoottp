package com.example.demo.web.controller;


import com.example.demo.Agence;
import com.example.demo.Services.IAgenceServices;
import com.example.demo.Vehicule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("agence")
public class AgenceController {
    private final IAgenceServices iagenceServices;
    @PostMapping("add")
    Agence createAgence (@RequestBody Agence agence){
        return iagenceServices.addAgence(agence);
    }
}
