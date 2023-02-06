package krg.petr.otusjava;

import java.util.List;
import java.util.Objects;

public class BankAccount {
    private BankClient bankClient;
    private final int accountBalance;
    public BankAccount(BankClient client, int balance) {
        this.bankClient = client;
        this.accountBalance = balance;
    }

    public BankClient getBankClient () {

        return this.bankClient;
    }

    public int getAccountBalance() {

        return accountBalance;
    }

    public String getFullAccountData () {
        return this.bankClient.getClientName() + " " +
               this.bankClient.getClientAge() + " " +
               getAccountBalance();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof BankAccount bankAccount))
            return false;

        if (!Objects.equals(this.bankClient.getClientName(), bankAccount.bankClient.getClientName()))
            return false;
        return (this.bankClient.getClientAge() == bankAccount.bankClient.getClientAge());
    }

    @Override
    public int hashCode() {
        int result = this.bankClient.getClientAge();
        result = 31 * result + (this.bankClient.getClientName() != null ?
                this.bankClient.getClientName().hashCode() : 0);
        return result;
    }

}
