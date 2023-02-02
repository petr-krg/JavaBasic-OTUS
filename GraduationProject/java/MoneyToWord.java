package krg.petr.otusjava;

public class MoneyToWord {
    private StringBuffer sum = new StringBuffer();
    private StringBuffer part = new StringBuffer();
    private Boolean isNull = false;

    private final String[] thousands = {"тысяча ", "тысячи ", "тысяч "};
    private final String[] millions = {"миллион ", "миллиона ", "миллионов "};
    private final String[] billions = {"миллиард ", "миллиарда ", "миллиардов "};
    private final String[][] currency;

    public MoneyToWord(String[][] cur) {
        this.currency = cur;
    }

    private void insertSum() {
        this.sum.insert(0, this.part);
        this.part = new StringBuffer();
    }

    private void clearSum() {
        this.sum = new StringBuffer();
    }

    private StringBuffer getSum() {
        return this.sum;
    }

    private StringBuffer getPart() {
        return this.part;
    }

    private String[] getNames(int triple) {
        return switch (triple) {
            case 2 -> this.millions;
            case 3 -> this.billions;
            default -> this.thousands;
        };
    }

    private void parseUnits(char units, int triple) {
        if (units != '0' )
            isNull = false;

        switch (units) {
            case '1' -> {
                getPart().append((triple == 1) ? "одна " : "один ");
                if (triple != 0) getPart().append(getNames(triple)[0]);
            }
            case '2' -> {
                getPart().append("два");
                if (triple != 0) getPart().append(getNames(triple)[1]);
            }
            case '3' -> {
                getPart().append("три ");
                if (triple != 0) getPart().append(getNames(triple)[1]);
            }
            case '4' -> {
                getPart().append("четыре ");
                if (triple != 0) getPart().append(getNames(triple)[1]);
            }
            case '5' -> {
                getPart().append("пять ");
                if (triple != 0) getPart().append(getNames(triple)[2]);
            }
            case '6' -> {
                getPart().append("шесть ");
                if (triple != 0) getPart().append(getNames(triple)[2]);
            }
            case '7' -> {
                getPart().append("семь ");
                if (triple != 0) getPart().append(getNames(triple)[2]);
            }
            case '8' -> {
                getPart().append("восемь ");
                if (triple != 0) getPart().append(getNames(triple)[2]);
            }
            case '9' -> {
                getPart().append("девять ");
                if (triple != 0) getPart().append(getNames(triple)[2]);
            }
            case '0' -> {
                if (triple != 0)
                    getPart().append(getNames(triple)[2]);
            }
        }

        insertSum();
    }

    private void parseTenner(char units, int triple) {
        switch (units) {
            case '1' -> getPart().append("одиннадцать ");
            case '2' -> getPart().append("двенадцать ");
            case '3' -> getPart().append("тринадцать ");
            case '4' -> getPart().append("четырнадцать ");
            case '5' -> getPart().append("пятнадцать ");
            case '6' -> getPart().append("шестнадцать ");
            case '7' -> getPart().append("семнадцать ");
            case '8' -> getPart().append("восемнадцать ");
            case '9' -> getPart().append("девятнадцать ");
            case '0' -> getPart().append("десять ");
        }

        if (triple == 0) {
            insertSum();
        } else {
            getPart().append(getNames(triple)[2]);
            insertSum();
        }
    }


    private void parseTennerUp(char tenner, char units, int triple) {
        switch (tenner) {
            case '1' -> parseTenner(units, triple);
            case '2' -> {
                getPart().append("двадцать ");
                parseUnits(units, triple);
            }
            case '3' -> {
                getPart().append("тридцать ");
                parseUnits(units, triple);
            }
            case '4' -> {
                getPart().append("сорок ");
                parseUnits(units, triple);
            }
            case '5' -> {
                getPart().append("пятьдесят ");
                parseUnits(units, triple);
            }
            case '6' -> {
                getPart().append("шестьдесят ");
                parseUnits(units, triple);
            }
            case '7' -> {
                getPart().append("семьдесят ");
                parseUnits(units, triple);
            }
            case '8' -> {
                getPart().append("восемьдесят ");
                parseUnits(units, triple);
            }
            case '9' -> {
                getPart().append("девяносто ");
                parseUnits(units, triple);
            }
            case '0' -> {
                isNull = !isNull;
                parseUnits(units, triple);
            }
        }
    }

    private void parseHundreds(char hundreds) {
        switch (hundreds) {
            case '1' -> getPart().append("сто ");
            case '2' -> getPart().append("двести ");
            case '3' -> getPart().append("триста ");
            case '4' -> getPart().append("четыреста ");
            case '5' -> getPart().append("пятьсот ");
            case '6' -> getPart().append("шестьсот ");
            case '7' -> getPart().append("семьсот ");
            case '8' -> getPart().append("восемьсот ");
            case '9' -> getPart().append("девятьсот ");
            case '0' -> isNull = true;
        }

        if (hundreds != '0')
            isNull = !isNull;
    }

    private int getCountDigitsFirstTriple(int length) {
        int i = length % 3;
        return i == 0 ? 3 : i;
    }

    private String getCurrency(int currency, Long money) {
        char[] charArray = money.toString().toCharArray();
        return switch (charArray[charArray.length - 1]) {
            default -> this.currency[currency][2];
            case '1' -> this.currency[currency][0];
            case '4' -> this.currency[currency][1];
        };
    }

    private StringBuffer longToString(Long money) {
        char[] charArray = money.toString().toCharArray();
        int length = charArray.length;

        int triadCount = length % 3 > 0 ? length / 3 + 1 : length / 3;
        int charArrayIndex = length - 1;

        if (money == 0) {
            sum.append("ноль ");
        } else

            for (int i = 0; i < triadCount; i++) {
                if (i == triadCount - 1) {
                    switch (getCountDigitsFirstTriple(length)) {
                        case 1 -> parseUnits(charArray[charArrayIndex], i);
                        case 2 -> parseTennerUp(charArray[charArrayIndex - 1],
                                charArray[charArrayIndex], i);
                        case 3 -> {
                            parseHundreds(charArray[charArrayIndex - 2]);
                            parseTennerUp(charArray[charArrayIndex - 1],
                                    charArray[charArrayIndex], i);
                        }
                    }
                } else {
                    parseHundreds(charArray[charArrayIndex - 2]);
                    parseTennerUp(
                            charArray[charArrayIndex - 1],
                            charArray[charArrayIndex],
                            i);
                }
                charArrayIndex = charArrayIndex - 3;
            }
        return getSum();
    }


    public String convert(Double money) {
        if (money < 0)
            money *= -1;

        StringBuilder result = new StringBuilder();

        Long longPart = money.longValue();
        result.append(longToString(longPart));
        result.append(getCurrency(0, longPart));
        clearSum();
        Long coinsPart = Math.round((money - longPart) * 100);
        result.append(longToString(coinsPart));
        result.append(getCurrency(1, coinsPart));
        return result.toString().trim();
    }

}
