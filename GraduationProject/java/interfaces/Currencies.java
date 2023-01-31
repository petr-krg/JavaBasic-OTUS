package krg.petr.otusjava.interfaces;

public interface Currencies {

    String[] thousands = new String[0];
    String[] millions = new String[0];
    String[] billions = new String[0];
    String[][] currencies = new String[0][];


    String getCurrenciesString(Double money);
}
