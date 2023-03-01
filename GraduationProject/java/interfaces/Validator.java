package krg.petr.otusjava.interfaces;

public interface Validator <T> {
    boolean validate(T value);
    String exceptionMessage(String value);
    boolean isApplicable(Object value);
}
