
import java.util.List;

public interface IBankAgency {
    BankAccount createAccount(String accountName, int accountId, double accountBalance);
    BankAccount searchAccount(int accountId);
    List<BankAccount> listAccounts();
}