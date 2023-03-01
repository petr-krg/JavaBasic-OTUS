package krg.petr.otusjava.console;

import krg.petr.otusjava.currencies.CurrenciesEnum;
import krg.petr.otusjava.interfaces.OutInterface;
import krg.petr.otusjava.interfaces.Validator;

public class CurrencySymbolValidator implements Validator<String> {
    @Override
    public boolean validate(String value) {
        OutInterface output = new ConsoleOutput();

        if (!isApplicable(value)) {
            output.printError(exceptionMessage(value));
            return false;
        }

        try {
            Enum.valueOf(CurrenciesEnum.class, value.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            output.printError(exceptionMessage(value));
            return false;
        }
    }
    @Override
    public String exceptionMessage(String value) {
        return "Ошибка ввода символа валюты: " + value;
    }
    @Override
    public boolean isApplicable(Object value) {
        return value instanceof String;
    }
}
