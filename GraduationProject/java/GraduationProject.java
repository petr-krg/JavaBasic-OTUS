package krg.petr.otusjava;

import krg.petr.otusjava.console.ConsoleInput;
import krg.petr.otusjava.console.ConsoleOutput;
import krg.petr.otusjava.console.InputCollection;
import krg.petr.otusjava.currencies.CurrenciesAvailable;
import krg.petr.otusjava.interfaces.Currencies;
import krg.petr.otusjava.interfaces.OutInterface;

public class GraduationProject {
    public static void main(String[] args) {

        OutInterface viewText = new ConsoleOutput();
        CurrenciesAvailable currenciesAvailable = new CurrenciesAvailable();
        ConsoleInput input = new ConsoleInput();
        InputCollection inputCollection;

        do {
            viewText.printDescription();
            inputCollection = input.userInputCollection();

            Currencies currency = currenciesAvailable.getCurrency(inputCollection.get(0).toString());
            viewText.printMessage(currency.getCurrenciesString((Double) inputCollection.get(1)));
        } while (true);
    }

}