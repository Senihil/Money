package hu.nye.progtech.money;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MoneyTest {

    //azert mert igy meg tudjuk adni, hogy mi legyen a bankban
    @Mock
    private Bank bank;

    @Test
    public void testAddShouldReturnCorrectValue() {
        //given
        Money baseMoney = new Money(BigDecimal.ZERO, Currency.getInstance("HUF"));
        Money additionalMoney = new Money(BigDecimal.ONE, Currency.getInstance("USD"));
        //megadjuk, hogy mi van a bankban, mi legyen a valtoszam
        given(bank.convert(Currency.getInstance("HUF"), Currency.getInstance("USD"))).willReturn(BigDecimal.ONE);
        //when
        Money result = baseMoney.add(additionalMoney, bank);
        //then
        assertEquals(BigDecimal.ONE, result.getValue());
    }
}