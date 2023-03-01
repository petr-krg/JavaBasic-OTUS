package krg.petr.otusjava.console;

import krg.petr.otusjava.interfaces.InInterface;
import krg.petr.otusjava.interfaces.OutInterface;
import krg.petr.otusjava.interfaces.Validator;

import java.util.Scanner;

public class ConsoleInput implements InInterface {

    public CollectionInput userInputCollection() {
        String symbolMoney;
        String inputString;
        String[] arrayString;
        OutInterface output = new ConsoleOutput();
        Validator<String> validateMoney = new MoneyAmountValidator();
        Validator<String> validateSymbol = new CurrencySymbolValidator();

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

        if (!validateSymbol.validate(arrayString[0])) {
            return null;
        }

        if (!validateMoney.validate(arrayString[1])) {
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
