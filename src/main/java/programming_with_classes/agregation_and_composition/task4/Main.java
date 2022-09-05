package programming_with_classes.agregation_and_composition.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("120", 54120.13, false);
        BankAccount acc2 = new BankAccount("121", 0.120, false);
        BankAccount acc3 = new BankAccount("122", 255475.52, true);
        BankAccount acc4 = new BankAccount("123", -12575.12, false);
        BankAccount acc5 = new BankAccount("124", 2340, true);
        BankAccount acc6 = new BankAccount("125", -2120, false);

        List<BankAccount> bankAccountsList = new ArrayList<>();
        Collections.addAll(bankAccountsList, acc1, acc2, acc3, acc4, acc5, acc6);

        BankAccountList bankAccount = new BankAccountList(bankAccountsList);

        System.out.println("Получаем общую сумму по всем счетам:");
        double sum = bankAccount.getTotalSum();
        System.out.println(sum + "\n");

        System.out.println("Получаем отсортированный по балансу список счетов:");
        bankAccount.sortByBalance().forEach(System.out::println);

        System.out.println("\n" + "Получаем список не заблокированных счетов:");
        bankAccount.getUnblockedAccounts().forEach(System.out::println);

        System.out.println("\n" + "Получаем сумму на счетах только с положительным балансом при условии," +
                            "что счёт не заблокирован:");
        System.out.println(bankAccount.getSumOfAccountsWithPositiveBalance());

        System.out.println("\n" + "Сумма на всех счетах с отрицательным балансом:");
        System.out.println(bankAccount.getSumOfAccountsWithNegativeBalance());

        System.out.println("\n" + "Получаем счёт с максимальным балансом");
        System.out.println(bankAccount.getAccountWithMaxBalance());

        System.out.println("\n" + "Получаем баланс на заблокированных счетах:");
        System.out.println(bankAccount.getTotalSumOnBlockedAccounts());
    }
}
