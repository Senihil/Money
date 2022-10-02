package hu.nye.progtech.money;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;
import java.util.StringJoiner;

public class Money {

    private BigDecimal value;
    private Currency currency;

    //Konstruktor, megadja, hogy epul fel a money osztalyt
    public Money(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    //Getterek
    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Money add(Money moneyToAdd, Bank bank) {
        BigDecimal exchangeRate = bank.convert(currency, moneyToAdd.getCurrency());
        BigDecimal convertedValue = moneyToAdd.getValue().multiply(exchangeRate);
        BigDecimal newValue = this.value.add(convertedValue);

        return new Money(newValue, currency);
    }

    private boolean areInTheDifferentCurrency(Money other) {
        return !currency.equals(other.getCurrency());
    }

    //equals es hashcode, ossze tudjuk hasonlitani mar oket az equals-sal, a hashcode a tarolas miatt
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return value.equals(money.value) && currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Money.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .add("currency=" + currency)
                .toString();
    }

}