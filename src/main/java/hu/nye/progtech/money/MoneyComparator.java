package hu.nye.progtech.money;

import java.math.BigDecimal;
import java.util.Comparator;

public class MoneyComparator implements Comparator<Money> {

    private Bank bank;

    public MoneyComparator(Bank bank) {
        this.bank = bank;
    }

    @Override
    public int compare(Money o1, Money o2) {
        BigDecimal exchangeRate = bank.convert(o1.getCurrency(), o2.getCurrency());
        BigDecimal convertedValue = o2.getValue().multiply(exchangeRate);

        return o1.getValue().compareTo(convertedValue);
    }
}