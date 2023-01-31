package krg.petr.otusjava.currencies;

import krg.petr.otusjava.MoneyToWord;
import krg.petr.otusjava.interfaces.Currencies;

public class CurrencyRU implements Currencies {

    MoneyToWord moneyToWord;

    @Override
    public String getCurrenciesString(Double money) {
        return this.moneyToWord.convert(money);
    }
    public CurrencyRU() {
        String[][] currencyRU = {{"рубль ", "рубля ", "рублей "},
                {"копейка ", "копейки ", "копеек "}};
        this.moneyToWord = new MoneyToWord(currencyRU);
    }

}
