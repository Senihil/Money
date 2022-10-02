package hu.nye.progtech.money;

import java.math.BigDecimal;
import java.util.Currency;

public class Main {

    public static void main(String[] args) {
        Money usd = new Money(BigDecimal.valueOf(10), Currency.getInstance("USD"));
        //usd.value = -200;
        //usd.currency = null;
        Money huf = new Money(BigDecimal.ZERO, Currency.getInstance("HUF"));
        Bank bank = new StaticBank();

        Money newhuf = huf.add(usd, bank);
        System.out.println(newhuf);

        MoneyComparator comparator = new MoneyComparator(bank);
        int compare = comparator.compare(huf, usd);
        System.out.println(compare);
    }
}