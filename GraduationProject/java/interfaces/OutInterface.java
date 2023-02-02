package krg.petr.otusjava.interfaces;

public interface OutInterface {
    void printMessage(String textMessage);
    void printMessage(String textMessage, Object ... args);

    void printDescription();
}
