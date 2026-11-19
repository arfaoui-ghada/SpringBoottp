package com.example.demo.Services.promo;

import org.springframework.stereotype.Component;

@Component
public final class RentreePromo extends RemisePourcentage {

    public RentreePromo() {
        super("RENTREE", "0.15");
    }
}
