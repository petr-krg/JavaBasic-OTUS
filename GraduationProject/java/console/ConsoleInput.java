package krg.petr.otusjava.console;

import krg.petr.otusjava.interfaces.InInterface;

import java.util.Scanner;


public class ConsoleInput implements InInterface {


    public InputCollection userInputCollection() {
        String symbolMoney;
        String inputString;
        String[] arrayString;

        Scanner input = new Scanner(System.in);
        inputString = input.nextLine().trim();

        if (inputString.length() == 1) {
            if (inputString.equalsIgnoreCase("n")) {
                System.exit(0);
            }
            return null;
        }

        arrayString = inputString.split("\\s");
        symbolMoney = arrayString[0];
        Double amountMoney = Double.parseDouble(arrayString[1]);
        return new InputCollection(symbolMoney, amountMoney);
    }

}
