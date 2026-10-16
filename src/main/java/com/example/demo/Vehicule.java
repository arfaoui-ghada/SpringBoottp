package com.example.demo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVehicule;
    private String immatriculation ;
    private String marque ;
    private String modele;
    @Enumerated(value = EnumType.STRING)
    private CategorieVehicule categorie ;
    @Enumerated(value = EnumType.STRING)
    private StatutVehicule statut;
    private BigDecimal tarifJournal;
    @ManyToOne
    Agence agence;
    @ManyToMany
    Set<Equipement> equipements;
    @OneToMany(mappedBy = "vehicule")
    Set<Reservation> reservations;


}
