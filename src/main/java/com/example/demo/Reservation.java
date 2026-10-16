package com.example.demo;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {
@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idReservation;
private LocalDate dateDebut;
private LocalDate dateFin;@Enumerated(value = EnumType.STRING)
private StatutReservation statut;
@ManyToOne
Vehicule vehicule;
@OneToOne
Contrat contrat;
@ManyToOne
Client client;
}

