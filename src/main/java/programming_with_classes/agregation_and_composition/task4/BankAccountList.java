package programming_with_classes.agregation_and_composition.task4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BankAccountList {

    private List<BankAccount> bankAccounts;

    public BankAccountList(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    // получить общую сумму на всех счетах
    public double getTotalSum() {
        return bankAccounts.stream()
                .mapToDouble(BankAccount::getBalance)
                .sum();
    }

    // получить отсортированный по балансу список всех счетов
    public List<BankAccount> sortByBalance() {
        return bankAccounts.stream()
                .sorted(Comparator.comparingDouble(BankAccount::getBalance))
                .collect(Collectors.toList());
    }

    // получить список не заблокированных счетов
    public List<BankAccount> getUnblockedAccounts() {
        return bankAccounts.stream()
                .filter(bankAccount -> !bankAccount.isBlocked())
                .collect(Collectors.toList());
    }

    // сумма на счетах с положительным балансом при условии, что счет не заблокирован
    public double getSumOfAccountsWithPositiveBalance() {
        return bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getBalance() >= 0)
                .filter(bankAccount -> !bankAccount.isBlocked())
                .mapToDouble(BankAccount::getBalance)
                .sum();
    }

    // общая сумма на заблокированных счетах
    public double getTotalSumOnBlockedAccounts() {
        return bankAccounts.stream()
                .filter(BankAccount::isBlocked)
                .mapToDouble(BankAccount::getBalance)
                .sum();
    }

    // сумма на счетах с отрицательным балансом
    public double getSumOfAccountsWithNegativeBalance() {
        return bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getBalance() <= 0)
                .mapToDouble(BankAccount::getBalance)
                .sum();
    }

    // поиск счёта с максимальной суммой
    public BankAccount getAccountWithMaxBalance() {
        return Collections.max(bankAccounts, Comparator.comparingDouble(BankAccount::getBalance));
    }
}
