import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema bancário!");
        System.out.print("Digite o número da agência: ");
        int agencyNumber = scanner.nextInt();
        scanner.nextLine();

        BankAgency agency = new BankAgency(agencyNumber);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Buscar conta");
            System.out.println("3 - Listar contas");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 0) {
                System.out.println("Encerrando o programa.");
                break;
            }

            switch (option) {
                case 1:
                    System.out.print("Digite o nome do titular: ");
                    String accountName = scanner.nextLine();
                    System.out.print("Digite o ID da conta: ");
                    int accountId = scanner.nextInt();
                    System.out.print("Digite o saldo inicial da conta: ");
                    double accountBalance = scanner.nextDouble();
                    scanner.nextLine();

                    BankAccount newAccount = agency.createAccount(accountName, accountId, accountBalance);
                    if (newAccount != null) {
                        System.out.println("Conta criada com sucesso!");
                        System.out.println("Detalhes da conta:");
                        System.out.println("Titular: " + newAccount.getAccountName() + ", ID: " + newAccount.getAccountId() + ", Saldo: " + newAccount.getAccountBalance());
                    }
                    break;

                case 2:
                    System.out.print("Digite o ID da conta a ser buscada: ");
                    int searchAccountId = scanner.nextInt();
                    scanner.nextLine();

                    BankAccount searchedAccount = agency.searchAccount(searchAccountId);
                    if (searchedAccount != null) {
                        System.out.println("Conta encontrada:");
                        System.out.println("Titular: " + searchedAccount.getAccountName() + ", ID: " + searchedAccount.getAccountId() + ", Saldo: " + searchedAccount.getAccountBalance());
                    } else {
                        System.out.println("Conta não encontrada para o ID: " + searchAccountId);
                    }
                    break;

                case 3:
                    List<BankAccount> accounts = agency.listAccounts();
                    if (!accounts.isEmpty()) {
                        System.out.println("Contas na agência:");
                        for (BankAccount account : accounts) {
                            System.out.println("Titular: " + account.getAccountName() + ", ID: " + account.getAccountId() + ", Saldo: " + account.getAccountBalance());
                        }
                    } else {
                        System.out.println("Não há contas na agência.");
                    }
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma das opções listadas.");
            }
        }

        scanner.close();
    }
}