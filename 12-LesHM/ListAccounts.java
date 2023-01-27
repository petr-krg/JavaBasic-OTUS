package krg.petr.otusjava;

import java.util.*;

public class ListAccounts {
    private List<BankAccount> listAccounts;
    private Map<BankClient, List<BankAccount>> accountsByClient;
   public ListAccounts() {

        this.listAccounts = new ArrayList<>();
        this.accountsByClient = new HashMap<>();
    }

    public BankAccount getAccounts(int elementIndex) {

       return this.listAccounts.get(elementIndex);
    }

    public void add(BankAccount account) {

        this.listAccounts.add(account);
    }

    public void addToAccountMap(BankClient client, List<BankAccount> account) {

       this.accountsByClient.put(client, account);
    }

    public void findAccountByClient(BankClient client) {

       String title = "[HashMap] Для клиента: " + client.getClientName();

       List<BankAccount> foundAccount = accountsByClient.get(client);

       showHashAccounts(title, foundAccount);
    }

    public void showHashAccounts(String title, List<BankAccount> foundAccounts) {

        if (foundAccounts == null) {
            System.out.printf("%n%s%n", title + " не найдено счетов!");
            return;
        }

        String alignFormat = "| %-32s | %-4d | %-8d |%n";

        System.out.printf("%n%s%n", title);
        System.out.format("+----------------------------------+------+----------+%n");
        System.out.format("| Client name                      | Age  | Balance  |%n");
        System.out.format("+----------------------------------+------+----------+%n");

        Iterator<BankAccount> iterator = foundAccounts.iterator();
        while (iterator.hasNext()) {
            BankAccount accounts = iterator.next();
            for (BankAccount account : this.listAccounts) {
                if (account.equals(accounts)) {
                    System.out.format(alignFormat, account.getBankClient().getClientName(),
                                                   account.getBankClient().getClientAge(),
                                                   account.getAccountBalance());
                }
            }
        }

        System.out.format("+----------------------------------+------+----------+%n");
    }

    public void showAllAccounts(String title) {

        String alignFormat = "| %-32s | %-4d | %-8d |%n";

        System.out.printf("%n%s%n", title);

        System.out.format("+----------------------------------+------+----------+%n");
        System.out.format("| Client name                      | Age  | Balance  |%n");
        System.out.format("+----------------------------------+------+----------+%n");

        Iterator<BankAccount> iterator = this.listAccounts.iterator();
        while (iterator.hasNext()) {
            BankAccount account = iterator.next();
            System.out.format(alignFormat, account.getBankClient().getClientName(),
                                           account.getBankClient().getClientAge(),
                                           account.getAccountBalance());
        }

        System.out.format("+----------------------------------+------+----------+%n%n");
    }
}
