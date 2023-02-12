package krg.petr.otusjava.console;

import krg.petr.otusjava.interfaces.OutInterface;

public class ConsoleOutput implements OutInterface {

    private final String COLOR_RESET = "\u001B[0m";
    private final String COLOR_RED = "\u001B[31m";
    private final String COLOR_YELLOW = "\u001B[33m";
    private final String COLOR_BLUE = "\u001B[34m";
    private final String COLOR_GREEN = "\u001B[32m";


    @Override
    public void printMessage(String textMessage) {
        System.out.print(textMessage);
    }

    @Override
    public void printMessage(String textMessage, Object... args) {
        System.out.printf(textMessage, args);
    }

    @Override
    public void printDescription(String textMessage) {
        System.out.print(COLOR_BLUE + textMessage + COLOR_RESET);
    }
    @Override
    public void printError(String textMessage) {
        System.out.println(COLOR_RED + textMessage + COLOR_RESET);
    }
    @Override
    public void printWarning(String textMessage) {
        System.out.println(COLOR_YELLOW + textMessage + COLOR_RESET);
    }

    @Override
    public void printExecutionResult(String textMessage) {
        System.out.println(COLOR_GREEN + textMessage + COLOR_RESET);
    }
}
