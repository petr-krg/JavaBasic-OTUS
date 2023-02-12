package krg.petr.otusjava.console;

import krg.petr.otusjava.interfaces.OutInterface;
import krg.petr.otusjava.interfaces.Validator;

import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;

public class MoneyAmountValidator implements Validator<String> {
    @Override
    public boolean validate(String value) {
        OutInterface output = new ConsoleOutput();
        if (!isApplicable(value)) {
            output.printError(exceptionMessage(value));
            return false;
        }
        return true;
    }

    @Override
    public String exceptionMessage(String value) {
        return "Ошибка ввода суммы: " + value;
    }

    @Override
    public boolean isApplicable(Object value) {
        Format parser = NumberFormat.getInstance();
        try {
            Object obj = parser.parseObject(value.toString());
            if (obj instanceof Double) {
                return true;
            } else  if (obj instanceof Integer) {
                return true;
            } else return obj instanceof Number;
        } catch (ParseException e) {
            return false;
        }
    }
}
