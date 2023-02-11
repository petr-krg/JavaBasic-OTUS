package krg.petr.otusjava.console;

import krg.petr.otusjava.currencies.CurrenciesEnum;
import krg.petr.otusjava.interfaces.InInterface;
import krg.petr.otusjava.interfaces.OutInterface;

import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;

public class ConsoleInput implements InInterface {

    private boolean tryParseDouble(String inputString) {
        Format parser = NumberFormat.getInstance();
        try {
            Object obj = parser.parseObject(inputString);
            if (obj instanceof Double) {
                return true;
            } else  if (obj instanceof Integer) {
                return true;
            } else return obj instanceof Number;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean tryParseSymbolMoney(String inputString) {
        try {
            Enum.valueOf(CurrenciesEnum.class, inputString.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public CollectionInput userInputCollection() {
        String symbolMoney;
        String inputString;
        String[] arrayString;
        OutInterface output = new ConsoleOutput();

        final double MAX_MONEY = 999999999.99;

        Scanner input = new Scanner(System.in);
        inputString = input.nextLine().trim();

        if (inputString.length() == 1) {
            if (inputString.equalsIgnoreCase("n")) {
                System.exit(0);
            }
            return null;
        }

        arrayString = inputString.split("\\s");

        if (!tryParseSymbolMoney(arrayString[0])) {
            output.printError("Ошибка ввода символа валюты: " + arrayString[0]);
            return null;
        }

        if (!tryParseDouble(arrayString[1])) {
            output.printError("Ошибка ввода суммы: " + arrayString[1]);
            return null;
        }

        symbolMoney = arrayString[0];
        symbolMoney = symbolMoney.toUpperCase();
        double amountMoney = Double.parseDouble(arrayString[1]);

        if ((amountMoney < 0) || (amountMoney > MAX_MONEY)) {
            if (amountMoney > MAX_MONEY) {
                output.printError("Вы ввели слишком большую сумму: " + amountMoney);
                return null;
            } else {
                output.printWarning("Вы ввели отрицательную сумму, будет произведена автоматическая конвертация в положительную сумму: " + amountMoney);
                amountMoney *= -1;
                output.printExecutionResult("Ваша сумма после конвертации: " + amountMoney);
            }
        }

        return new CollectionInput(symbolMoney, amountMoney);
    }

}
