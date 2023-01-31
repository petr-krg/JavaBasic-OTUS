package krg.petr.otusjava.currencies;

import krg.petr.otusjava.MoneyToWord;
import krg.petr.otusjava.interfaces.Currencies;

public class CurrencyKZ implements Currencies {
    MoneyToWord moneyToWord;
    @Override
    public String getCurrenciesString(Double money) {
        return this.moneyToWord.convert(money);
    }

    public CurrencyKZ() {
            String[][] currencyKZ = {{"тенге ", "тенге ", "тенге "},
                    {"тиын ", "тиына ", "тиынов "}};
            this.moneyToWord = new MoneyToWord(currencyKZ);
    }
}
