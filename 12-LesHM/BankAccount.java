package krg.petr.otusjava;

import java.util.List;

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
}
