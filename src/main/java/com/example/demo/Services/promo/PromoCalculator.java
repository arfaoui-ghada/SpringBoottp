package com.example.demo.Services.promo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public final class PromoCalculator {
    private final Map<String, PromoStrategy> strategies;

    public PromoCalculator(Collection<? extends PromoStrategy> strategies) {
        this.strategies = strategies.stream()
                .collect(Collectors.toUnmodifiableMap(PromoStrategy::code, Function.identity()));
    }

    public BigDecimal appliquer(BigDecimal montant, String codePromo) {
        if (codePromo == null || codePromo.isBlank()) {
            return montant;
        }
        PromoStrategy strategy = strategies.get(codePromo);
        return strategy == null ? montant : strategy.appliquer(montant);
    }
}
