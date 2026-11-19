package com.example.demo.Services.promo;

import java.math.BigDecimal;

public abstract class RemisePourcentage implements PromoStrategy {
    private final String code;
    private final BigDecimal taux;

    protected RemisePourcentage(String code, String taux) {
        this.code = code;
        this.taux = new BigDecimal(taux);
    }

    public String code() { return code; }

    public BigDecimal appliquer(BigDecimal montant) {
        return montant.multiply(BigDecimal.ONE.subtract(taux));
    }
}