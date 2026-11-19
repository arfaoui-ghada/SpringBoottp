package com.example.demo.Services.promo;
import java.math.BigDecimal;

public abstract class RemiseFixe implements PromoStrategy {
    private final String code;
    private final BigDecimal valeur;

    protected RemiseFixe(String code, String valeur) {
        this.code = code;
        this.valeur = new BigDecimal(valeur);
    }

    public String code() { return code; }

    public BigDecimal appliquer(BigDecimal montant) {
        return montant.subtract(valeur);
    }
}