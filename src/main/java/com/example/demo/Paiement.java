package com.example.demo;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    private BigDecimal montant;
    private LocalDate datePaiement;
    @Enumerated(value = EnumType.STRING)
    private ModePaiement modePaiement;
}
