package krg.petr.otusjava;

import java.util.*;

public class ListClients {
    private List<BankClient> listClients;

    private Map<BankAccount, BankClient> clientByAccount;

    public ListClients() {

        this.listClients = new ArrayList<>();
        this.clientByAccount = new HashMap<>();
    }

    public BankClient findClientByAccount(BankAccount account) {

        return null;
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

    public void showHashAccounts(String title, List<BankClient> fClient){

        if ((this.listClients == null) || this.listClients.isEmpty()) {
            return;
        }

        System.out.printf("%n%s%n", title);

        String formatAlign = "| %-32s | %-4d |%n";

        System.out.format("+----------------------------------+------+%n");
        System.out.format("| Client name                      | Age  |%n");
        System.out.format("+----------------------------------+------+%n");
        System.out.format(formatAlign, fClient.get(0).getClientName(),
                                       fClient.get(0).getClientAge());
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
