import java.util.ArrayList;
import java.util.List;

class BankAgency implements IBankAgency {
    private int agencyNumber;
    private List<BankAccount> accounts;

    public BankAgency(int agencyNumber) {
        this.agencyNumber = agencyNumber;
        this.accounts = new ArrayList<>();
    }

    @Override
    public BankAccount createAccount(String accountName, int accountId, double accountBalance) {
        if (accountName == null || accountName.isEmpty() || accountId <= 0 || accountBalance < 0) {
            System.out.println("Parâmetros inválidos para criar a conta.");
            return null;
        }

        BankAccount newAccount = new BankAccount(accountName, accountId, accountBalance);
        accounts.add(newAccount);
        return newAccount;
    }

    @Override
    public BankAccount searchAccount(int accountId) {
        for (BankAccount account : accounts) {
            if (account.getAccountId() == accountId) {
                return account;
            }
        }
        System.out.println("Conta não encontrada para o ID: " + accountId);
        return null;
    }

    @Override
    public List<BankAccount> listAccounts() {
        return new ArrayList<>(accounts);
    }
}
