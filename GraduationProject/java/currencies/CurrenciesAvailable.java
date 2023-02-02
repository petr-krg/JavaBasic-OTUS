package krg.petr.otusjava.currencies;

import krg.petr.otusjava.interfaces.Currencies;


public class CurrenciesAvailable {

    private CorrenciesEnum strToEnum(String symbol) {
        if (symbol != null) {
            for (CorrenciesEnum correnciesEnum : CorrenciesEnum.values()) {
                if (correnciesEnum.getDescription().equalsIgnoreCase(symbol)) {
                    return correnciesEnum;
                }
            }
        }
        return null;
    }

    public Currencies getCurrency(String symbol) {
        CorrenciesEnum symbolCurrencies = strToEnum(symbol);

        switch (symbolCurrencies) {
            case KZT -> {
                return new CurrencyKZ();
            }
            case RUR -> {
                return new CurrencyRU();
            }
            default -> throw new IllegalStateException("Не известный символ: " + symbolCurrencies);
        }
    }

}
