package hu.nye.progtech.money;

import java.math.BigDecimal;
import java.util.Currency;

public interface Bank {
    public BigDecimal convert(Currency target, Currency base);
}