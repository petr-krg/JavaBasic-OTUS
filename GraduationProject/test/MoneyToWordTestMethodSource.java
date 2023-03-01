import krg.petr.otusjava.MoneyToWord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyToWordTestMethodSource {
    private static List<Arguments> testKztCurrencies() {
        return Arrays.asList(
                Arguments.of(30000.10, "тридцать тысяч тенге десять тиынов"),
                Arguments.of(35000.10, "тридцать пять тысяч тенге десять тиынов"),
                Arguments.of(102, "сто два тенге ноль тиынов"),
                Arguments.of(3155450.50, "три миллиона сто пятьдесят пять тысяч четыреста пятьдесят тенге пятьдесят тиынов"),
                Arguments.of(3155450356.50, "три миллиарда сто пятьдесят пять миллионов четыреста пятьдесят тысяч триста пятьдесят шесть тенге пятьдесят тиынов")
        );
    };

    private static List<Arguments> testRurCurrencies() {
        return Arrays.asList(
                Arguments.of(30000.10, "тридцать тысяч рублей десять копеек"),
                Arguments.of(35000.10, "тридцать пять тысяч рублей десять копеек"),
                Arguments.of(102, "сто два рубля ноль копеек"),
                Arguments.of(3155450.50, "три миллиона сто пятьдесят пять тысяч четыреста пятьдесят рублей пятьдесят копеек"),
                Arguments.of(3155450356.50, "три миллиарда сто пятьдесят пять миллионов четыреста пятьдесят тысяч триста пятьдесят шесть рублей пятьдесят копеек")

        );
    };

    @ParameterizedTest
    @MethodSource("testKztCurrencies")
    @DisplayName("Convert money to string KZT currencies")
    void TestKztMoneyToWord(double money, String expectedValue) {
        MoneyToWord testMoneyToWord = new MoneyToWord();
        assertEquals(expectedValue, testMoneyToWord.convert("KZT", money));
    }

    @ParameterizedTest
    @MethodSource("testRurCurrencies")
    @DisplayName("Convert money to string RUR currencies")
    void TestRurMoneyToWord(double money, String expectedValue) {
        MoneyToWord testMoneyToWord = new MoneyToWord();
        assertEquals(expectedValue, testMoneyToWord.convert("RUR", money));
    }
}
