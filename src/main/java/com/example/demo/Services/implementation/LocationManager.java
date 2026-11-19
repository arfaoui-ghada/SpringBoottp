package com.example.demo.Services.implementation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.math.BigDecimal;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Contrat;
import com.example.demo.ModePaiement;
import com.example.demo.Paiement;
import com.example.demo.Reservation;
import com.example.demo.Repository.IContratRepository;
import com.example.demo.Repository.IReservationRepository;
import com.example.demo.Services.location.legacy.SmsGateway;
import com.example.demo.Services.location.legacy.SmtpClient;
import com.example.demo.Services.promo.PromoCalculator;

/**
 * Confirmation des reservations.
 * Ecrit en urgence par le stagiaire. NE PAS MODIFIER : ca marche.
 *
 * Fichier fourni pour l'Atelier 6. Adaptez uniquement les noms des
 * getters/setters si votre modele (Atelier 2) utilise d'autres noms
 * (ex. getIdReservation() au lieu de getId()).
 */
@Service
public class LocationManager {

    @Autowired private IReservationRepository reservationRepository;
    @Autowired private IContratRepository contratRepository;
    @Autowired private PromoCalculator promoCalculator;

    public Contrat confirmerReservation(Long reservationId, String modePaiement, String codePromo, String canal) {
        Reservation r = reservationRepository.findById(reservationId).orElse(null);
        if (r == null) throw new RuntimeException("Reservation introuvable");

        // ---------- 1. disponibilite ----------
        for (Reservation x : reservationRepository.findAll()) {
            if (x.getVehicule().getIdVehicule().equals(r.getVehicule().getIdVehicule())
                    && !x.getVehicule().equals(r.getVehicule())
                    && !(r.getDateFin().isBefore(x.getDateDebut())
                    || r.getDateDebut().isAfter(x.getDateFin()))) {
                throw new RuntimeException("Vehicule indisponible");
            }
        }

        // ---------- 2. tarif de base ----------
        long j = ChronoUnit.DAYS.between(r.getDateDebut(), r.getDateFin()) + 1;
        BigDecimal m = r.getVehicule().getTarifJournal()
                .multiply(BigDecimal.valueOf(j));

        // ---------- 3. remises ----------
        m = promoCalculator.appliquer(m, codePromo);

        // ---------- 4. paiement ----------
        Paiement p = new Paiement();
        p.setDatePaiement(LocalDate.now());
        if (modePaiement.equals("CARTE")) {
            System.out.println("Debit de la carte bancaire...");
            m = m.multiply(new BigDecimal("1.01")); // 1 % de frais
            p.setModePaiement(ModePaiement.CARTE);
        } else if (modePaiement.equals("VIREMENT")) {
            System.out.println("Attente du virement...");
            p.setModePaiement(ModePaiement.VIREMENT);
        } else if (modePaiement.equals("ESPECES")) {
            System.out.println("Encaissement en especes a l'agence");
            p.setModePaiement(ModePaiement.ESPECES);
        } else {
            throw new RuntimeException("Mode de paiement inconnu : " + modePaiement);
        }
        p.setMontant(m);

        // ---------- 5. contrat ----------
        Contrat c = new Contrat();
        c.setDateSignature(LocalDate.now());
        c.setMontantTotal(m);
        c.setValide(true);
        c.setPaiements(new HashSet<>());
        c.setReservation(r);
        c.getPaiements().add(p);
        p.setContrat(c);
        Contrat res = contratRepository.save(c);

        // ---------- 6. notification ----------
        if (canal.equals("EMAIL")) {
            SmtpClient smtp = new SmtpClient("smtp.autoloc.tn", 25);
            smtp.send(r.getClient().getEmail(), "Contrat " + res.getIdContrat() + " confirme");
        } else if (canal.equals("SMS")) {
            SmsGateway sms = new SmsGateway("https://sms.autoloc.tn");
            sms.send(r.getClient().getTelephone(), "Contrat " + res.getIdContrat() + " confirme");
        }

        return res;
    }
}
