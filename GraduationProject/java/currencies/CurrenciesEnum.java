package krg.petr.otusjava.currencies;

public enum CurrenciesEnum {
    RUR(new String[][] {{"рубль ", "рубля ", "рублей "},{"копейка ", "копейки ", "копеек "}}),
    KZT(new String[][] {{"тенге ", "тенге ", "тенге "},{"тиын ", "тиына ", "тиынов "}});

    private final String[][] partCurrency;

    CurrenciesEnum(String[][] partCurrency) {
        this.partCurrency = partCurrency;
    }

    public String[][] getPartCurrency() {

        return this.partCurrency;
    }

    public String getCurrencyPartString(CurrenciesEnum currenciesEnum, int idxPart, Long money) {
        String[][] nameCurrency = currenciesEnum.getPartCurrency();
        char[] charArray = money.toString().toCharArray();
        return switch (charArray[charArray.length - 1]) {
            default -> nameCurrency[idxPart][2];
            case '1' -> nameCurrency[idxPart][0];
            case '2','3','4'  -> nameCurrency[idxPart][1];
        };
    }

}
