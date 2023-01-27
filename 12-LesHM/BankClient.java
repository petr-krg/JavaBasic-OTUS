package krg.petr.otusjava;

public class BankClient {
    private final String clientName;
    private final int clientAge;

    public BankClient(String cName, int cAge) {
        this.clientName = cName;
        this.clientAge = cAge;
    }

    public String getClientName() {

        return this.clientName;
    }
    public int getClientAge() {

        return clientAge;
    }

}

