package krg.petr.otusjava;

import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof BankClient bankClient))
            return false;

        if (!Objects.equals(this.clientName, bankClient.clientName))
            return false;
        return (this.clientAge == bankClient.clientAge);
    }

    @Override
    public int hashCode() {
        int result = this.clientAge;
        result = 31 * result + (this.clientName != null ? this.clientName.hashCode() : 0);
        return result;
    }

}

