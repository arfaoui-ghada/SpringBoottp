package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation {
@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idReservation;
private LocalDate dateDebut;
private LocalDate dateFin;@Enumerated(value = EnumType.STRING)
private StatutReservation statut;}

