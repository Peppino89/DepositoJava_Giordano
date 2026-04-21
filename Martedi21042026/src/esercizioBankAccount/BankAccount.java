package esercizioBankAccount;

import java.util.ArrayList;

public class BankAccount {

    private String accountHolderName;// nome del titolare
    private double balance;
    private String username;
    private String password;

    public BankAccount() {}
    private boolean logged;

    public BankAccount(String accountHolderName, double balance,String username,String password ) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.username = username;
        this.password = password;
        this.logged = false;
    }

    public void deposit(double amount) {
        if (!logged) {
            System.out.println("Non sei autenticato");
            return;
        }

        if (amount > 0) {
            System.out.println("Deposito effettuato");
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (!logged) {
            System.out.println("Non sei autenticato");
            return;
        }
        if (amount <= 0) {
            System.out.println("Importo non valido");
            return;
        }
        if (balance >= amount) {
            System.out.println("Prelievo effettuato ");
            balance -= amount;
        } else {
            System.out.println("Saldo insufficiente");
        }
    }

    public void displayBalance() {
        if (logged) {
            System.out.println(balance);
        }else{
            System.out.println("Non sei autenticato");
        }
    }

    @Override
    public String toString() {
        return  "accountHolderName=" + accountHolderName + ", balance=" + balance + " €";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BankAccount bankAccount = (BankAccount) obj;
        return accountHolderName.equals(bankAccount.accountHolderName) && username.equals(bankAccount.username) && password.equals(bankAccount.password);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(accountHolderName, balance);

        int result = accountHolderName.hashCode();
        result = 31 * result * Double.valueOf(balance).hashCode();

        return result;
    }

    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            this.logged = true;
            return true;
        }
        this.logged = false;
        return false;
    }

    public static BankAccount getBankAccount(ArrayList<BankAccount>accounts, String username, String password) {
        for (BankAccount bankAccount : accounts) {
           if(bankAccount.login(username, password)) {
               return bankAccount;
           }
        }
        return null;
    }


}
