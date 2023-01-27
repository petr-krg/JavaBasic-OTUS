package krg.petr.otusjava;

import java.util.*;

public class ListClients {
    private List<BankClient> listClients;

    private Map<BankAccount, BankClient> clientByAccount;

    public ListClients() {

        this.listClients = new ArrayList<>();
        this.clientByAccount = new HashMap<>();
    }

    public void findClientByAccount(BankAccount account) {

        BankClient bankClient = clientByAccount.get(account);

        showFoundClient(account.getFullAccountData(), bankClient);
    }

    public void add(BankClient client) {

        this.listClients.add(client);
    }

    public void addToClientMap(BankAccount account, BankClient client) {
        this.clientByAccount.put(account, client);
    }

    public BankClient getClient(int elementIndex) {

        return this.listClients.get(elementIndex);
    }

    public void showFoundClient(String title, BankClient client){

        if (client == null) {
            System.out.printf("%n%s%n Для счета: ", title + " не найдено клиента!");
            return;
        }

        System.out.printf("%n%s%n", title);

        String formatAlign = "| %-32s | %-4d |%n";

        System.out.format("+----------------------------------+------+%n");
        System.out.format("| Client name                      | Age  |%n");
        System.out.format("+----------------------------------+------+%n");
        System.out.format(formatAlign, client.getClientName(),
                                       client.getClientAge());
        System.out.format("+----------------------------------+------+%n%n");
    }

    public void showAllClients(String title) {
        if ((this.listClients == null) || this.listClients.isEmpty()) {
            return;
        }

        System.out.printf("%n%s%n", title);

        String formatAlign = "| %-32s | %-4d |%n";

        System.out.format("+----------------------------------+------+%n");
        System.out.format("| Client name                      | Age  |%n");
        System.out.format("+----------------------------------+------+%n");

        Iterator<BankClient> iterator = listClients.iterator();
        while (iterator.hasNext()) {
            BankClient item = iterator.next();
            System.out.format(formatAlign, item.getClientName(), item.getClientAge());
        }

        System.out.format("+----------------------------------+------+%n%n");
    }

}
