package programming_with_classes.agregation_and_composition.task4;
/*
Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки счета.
Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по всем счетам,
имеющим положительный и отрицательный балансы отдельно.
* */
public class BankAccount {
    private String numOfAccount;
    private double balance;
    private boolean isBlocked;

    public BankAccount(String numOfAccount, double balance, boolean isBlocked) {
        if (!numOfAccount.isEmpty()) {
            this.numOfAccount = numOfAccount;
            this.balance = balance;
            this.isBlocked = isBlocked;
        }
    }
    public String getNumOfAccount() {
        return numOfAccount;
    }

    public void setNumOfAccount(String numOfAccount) {
        if (!numOfAccount.isEmpty()) {
            this.numOfAccount = numOfAccount;
        }
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "numOfAccount='" + numOfAccount + '\'' +
                ", balance=" + balance +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
