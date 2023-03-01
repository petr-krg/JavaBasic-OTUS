package krg.petr.otusjava;

import krg.petr.otusjava.console.CollectionInput;
import krg.petr.otusjava.console.ConsoleInput;
import krg.petr.otusjava.console.ConsoleOutput;
import krg.petr.otusjava.currencies.CurrenciesEnum;
import krg.petr.otusjava.interfaces.OutInterface;

import java.util.Arrays;

public class GraduationProject {
    public static void main(String[] args) {

        OutInterface output = new ConsoleOutput();
        ConsoleInput input = new ConsoleInput();
        CollectionInput collectionInput;

        CurrenciesEnum[] currencies = CurrenciesEnum.values() ;
        String nl = System.lineSeparator();
        String textDescription = "Необходимо ввести данные в формате <символ валюты> пробел <сумма>, без скобочек." + nl +
                             String.format("Доступные символы валют для ввода: %s %n%n", Arrays.toString(currencies));


        do {
            output.printDescription(textDescription);
            output.printMessage( "Введите данные для конвертации: ");
            collectionInput = input.userInputCollection();
            if (collectionInput != null) {
                output.printExecutionResult(new MoneyToWord().convert(
                                            collectionInput.get(0).toString(),
                                            (Double) collectionInput.get(1)));
            }
        } while (true);
    }

}