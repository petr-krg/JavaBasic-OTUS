package krg.petr.otusjava.console;

import krg.petr.otusjava.currencies.CorrenciesEnum;
import krg.petr.otusjava.interfaces.OutInterface;

import java.util.Arrays;

public class ConsoleOutput implements OutInterface {
    @Override
    public void printMessage(String textMessage) {
        System.out.println(textMessage);
    }

    @Override
    public void printMessage(String textMessage, Object... args) {
        System.out.printf(textMessage, args);
    }

    public void printDescription() {
        System.out.println("Необходимо ввести данные в вормате <символ валюты> пробел <сумма>, без скобочек.");
        CorrenciesEnum[] currencies = CorrenciesEnum.values();
        System.out.printf("Доступные символы валют для ввода: %s %n%n", Arrays.toString(currencies));
        System.out.print("Введите данные для конвертации: ");
    }
}
