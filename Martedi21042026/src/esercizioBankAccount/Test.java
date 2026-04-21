package esercizioBankAccount;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

      ArrayList<BankAccount> bankAccounts = new ArrayList<>();
      bankAccounts.add(new BankAccount("Mario Rossi",20000,"Pippo","Pluto"));
      bankAccounts.add(new BankAccount("Luigi Bianchi",35000,"Inter","agh23"));
      bankAccounts.add(new BankAccount("Claudia verdi",50000,"Rosa","venere"));
      bankAccounts.add(new BankAccount("Luisa Morrone",12000,"Luisa","Riso23"));

       BankAccount account =  BankAccount.getBankAccount(bankAccounts,"Rosa","venere");

       if(account!=null) {
           account.deposit(5000);
           account.displayBalance();
           account.withdraw(200);
           account.displayBalance();

           System.out.println(account.toString());

           if(account.equals(new BankAccount("Claudia Rossi",50000,"Rosa","venere"))){
               System.out.println("Uguali");
           }
           else{
               System.out.println("Diversi ");
           }



       }else{
           System.out.println("Account non trovato");
       }


    }
}
