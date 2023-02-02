package krg.petr.otusjava.interfaces;

import krg.petr.otusjava.console.InputCollection;

public interface InInterface {
    default String userInput() {
        return "";
    }
    default InputCollection userInputCollection() {
        return null;
    }
}
