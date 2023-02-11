import krg.petr.otusjava.MoneyToWord;
import org.junit.jupiter.api.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyToWordTest {

    @DisplayName("Test public convert method - ru")
    @Test
    public void testMoneyToWordConvertRU() {
        MoneyToWord moneyToWord = new MoneyToWord();

        assertEquals("тридцать тысяч рублей десять копеек", moneyToWord.convert("RUR", 30000.10));
    }

    @DisplayName("Test public convert method - kz")
    @Test
    public void testMoneyToWordConvertKZ() {
        MoneyToWord moneyToWord = new MoneyToWord();

        assertEquals("тридцать тысяч тенге десять тиынов", moneyToWord.convert("KZT", 30000.10));
    }

    @DisplayName("Test private int getCountDigitsFirstTriple(int length)")
    @Test
    public void testGetCountDigitsFirstTriple() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MoneyToWord moneyToWord = new MoneyToWord();

        Class[] parameters = new Class[1];
        parameters[0] = int.class;
        Method privateMethod = moneyToWord.getClass().getDeclaredMethod("getCountDigitsFirstTriple", parameters);
        privateMethod.setAccessible(true);

        Object[] methodArgument = new Object[1];
        methodArgument[0] = 5;

        int actualValue = (int) privateMethod.invoke(moneyToWord, methodArgument);
        int expectValue = 2;

        assertEquals(expectValue, actualValue);
    }

    @DisplayName("Test private StringBuffer longToString(Long money)")
    @Test
    public void testLongToString() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MoneyToWord moneyToWord = new MoneyToWord();

        Class[] parameters = new Class[1];
        parameters[0] = Long.class;
        Method privateMethod = moneyToWord.getClass().getDeclaredMethod("longToString", parameters);
        privateMethod.setAccessible(true);

        Object[] methodArgument = new Object[1];
        methodArgument[0] = 30000L;

        StringBuffer expectValue = new StringBuffer();
        StringBuffer actualValue = new StringBuffer();

        actualValue.append((StringBuffer) privateMethod.invoke(moneyToWord, methodArgument));
        expectValue.append("тридцать тысяч ");

        assertEquals(expectValue.toString(), actualValue.toString());
    }
}


