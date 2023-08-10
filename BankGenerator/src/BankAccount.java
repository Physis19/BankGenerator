public class BankAccount implements IBankAccount{
    private String accountName;
    private int accountId;
    private double accountBalance;

    public BankAccount(String accountName, int accountId, double accountBalance) {
        this.accountName = accountName;
        this.accountId = accountId;
        this.accountBalance = accountBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getAccountId(){
        return accountId;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Depósito de $" + amount + " realizado. Novo saldo: $" + accountBalance);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Saque de $" + amount + " realizado. Novo saldo: $" + accountBalance);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
        }
    }
}
