package hu.nye.progtech.money;

import java.math.BigDecimal;
import java.util.Currency;

public class StaticBank implements Bank {

    @Override
    public BigDecimal convert(Currency target, Currency base) {
        BigDecimal exchangeRate;

        if (target.equals(base)) {
            exchangeRate = BigDecimal.ONE;
        } else if (target.equals(Currency.getInstance("USD")) && base.equals(Currency.getInstance("HUF"))) {
            exchangeRate = BigDecimal.valueOf(0.0034);
        } else if (target.equals(Currency.getInstance("HUF")) && base.equals(Currency.getInstance("USD"))) {
            exchangeRate = BigDecimal.valueOf(249.3);
        } else {
            throw new RuntimeException("Unknown currency");
        }
        return exchangeRate;
    }
}