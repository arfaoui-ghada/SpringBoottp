package com.example.demo.Services.promo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

class PromoCalculatorTest {

    private final PromoCalculator calculator = new PromoCalculator(List.of(
            new BienvenuePromo(),
            new Ete10Promo(),
            new RentreePromo()));

    @Test
    void appliesEachPromotionAccordingToItsOwnRule() {
        BigDecimal montant = new BigDecimal("100");

        assertEquals(new BigDecimal("80"), calculator.appliquer(montant, "BIENVENUE"));
        assertEquals(new BigDecimal("90.00"), calculator.appliquer(montant, "ETE10"));
        assertEquals(new BigDecimal("85.00"), calculator.appliquer(montant, "RENTREE"));
    }

    @Test
    void keepsAmountForUnknownOrMissingPromotion() {
        BigDecimal montant = new BigDecimal("100");

        assertEquals(montant, calculator.appliquer(montant, "INCONNU"));
        assertEquals(montant, calculator.appliquer(montant, null));
    }
}
