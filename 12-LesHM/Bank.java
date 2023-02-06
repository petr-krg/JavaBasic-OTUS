package krg.petr.otusjava;

import krg.petr.otusjava.helpers.HelperUtils;

import java.util.ArrayList;

import java.util.List;

public class Bank {
    public static void main(String[] args) {

        final int MAX_CLIENTS = 10;
        final int MIN_AGE = 10;
        final int MAX_AGE = 85;

        HelperUtils helper = new HelperUtils();

        ListClients listClients = new ListClients();
        ListAccounts listAccounts = new ListAccounts();

        BankAccount bankAccount;
        for (int i = 0; i < MAX_CLIENTS; i++) {
            int balance = helper.generateBalance();
            BankClient bankClient = new BankClient(helper.generateRandomFIO(),
                    helper.generateClientAge(MIN_AGE, MAX_AGE));
            listClients.add(bankClient);

            bankAccount = new BankAccount(bankClient, balance);
            listAccounts.add(bankAccount);

            listAccounts.addToAccountMap(bankClient, new ArrayList<>(List.of(bankAccount)));
            listClients.addToClientMap(bankAccount, bankClient);
        }

        listClients.showAllClients("Bank clients list");
        listAccounts.showAllAccounts("Bank account list");


        BankClient bankClientFind = new BankClient(listClients.getClient(0).getClientName(),
                listClients.getClient(0).getClientAge());
        BankAccount bankAccountFind = new BankAccount(bankClientFind,
                listAccounts.getAccounts(0).getAccountBalance());

        listAccounts.findAccountByClient(bankClientFind);
        listClients.findClientByAccount(bankAccountFind);

/*        for (int i = 0; i < MAX_CLIENTS; i++) {
            // тестируем поиск по всем акаунтам и клиентам с выводом в консоль
            listAccounts.findAccountByClient(listClients.getClient(i));
            listClients.findClientByAccount(listAccounts.getAccounts(i));
        }*/

    }
}