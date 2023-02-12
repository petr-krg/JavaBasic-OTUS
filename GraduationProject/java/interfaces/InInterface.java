package krg.petr.otusjava.interfaces;

import krg.petr.otusjava.console.CollectionInput;

public interface InInterface {
    default String userInput() {
        return "";
    }
    default CollectionInput userInputCollection() {
        return null;
    }
}
