package krg.petr.otusjava;

import krg.petr.otusjava.currencies.CurrencyKZ;
import krg.petr.otusjava.currencies.CurrencyRU;

public class GraduationProject {
    public static void main(String[] args) {

        CurrencyRU ruMoney = new CurrencyRU();
        CurrencyKZ kzMoney = new CurrencyKZ();

        System.out.println(ruMoney.getCurrenciesString(30000.10));
        System.out.println(kzMoney.getCurrenciesString(30000.10));
    }
}