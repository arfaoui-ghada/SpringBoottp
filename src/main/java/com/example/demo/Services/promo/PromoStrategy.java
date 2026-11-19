package com.example.demo.Services.promo;

import java.math.BigDecimal;

public interface PromoStrategy {
    String code();
    BigDecimal appliquer(BigDecimal montant);
}


