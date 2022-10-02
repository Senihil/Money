package hu.nye.progtech.money;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StaticBankTest {

    private StaticBank staticBank;

    @BeforeEach
    public void setUp() {
        staticBank = new StaticBank();
    }

    @Test
    public void testConvertShouldReturnOneWhenCurrenciesAreTheSame() {
        //given
        Currency huf = Currency.getInstance("HUF");
        //when
        BigDecimal result = staticBank.convert(huf, huf);
        //then
        assertEquals(BigDecimal.ONE, result);
    }

    @Test
    public void testConvertShouldThrowRuntimeExceptionWhenCurrencyIsUnknown() {
        //given in setup
        //when - then
        assertThrows(RuntimeException.class, () -> staticBank.convert(Currency.getInstance("HUF"), Currency.getInstance("EUR")));
    }

    @Test
    public void testConvertShouldGiveTheCorrectExchangeRateUSDToHUF() {
        //given
        Currency usd = Currency.getInstance("USD");
        Currency huf = Currency.getInstance("HUF");
        BigDecimal exchangeRate = BigDecimal.valueOf(0.0034);
        //when
        BigDecimal result = staticBank.convert(usd, huf);
        //then
        assertEquals(exchangeRate, result);
    }

    @Test
    public void testConvertShouldGiveTheCorrectExchangeRateHUFToUSD() {
        //given
        Currency huf = Currency.getInstance("HUF");
        Currency usd = Currency.getInstance("USD");
        BigDecimal exchangeRate = BigDecimal.valueOf(249.3);
        //when
        BigDecimal result = staticBank.convert(huf, usd);
        //then
        assertEquals(exchangeRate, result);
    }
}