package bank;

import java.util.ArrayList;
import java.util.Scanner;

class Account{
    private String accountHolder;
    private int accountNumber;
    private double balance;

    Account (String accountHolder, int accountNumber, double balance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }

    public String getAccountHolder(){
        return this.accountHolder;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

}

public class Bank {
    ArrayList<Account> accounts;

    Bank(){
        accounts = new ArrayList<>();
        Account ac1 = new Account("Virendra", 101, 500);
        Account ac2 = new Account("Ankit", 102, 300);
        Account ac3 = new Account("Deepak", 103, 600);
        Account ac4 = new Account("Gautam", 104, 100);
        Account ac5 = new Account("Kapil", 105, 900);

        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);
        accounts.add(ac4);
        accounts.add(ac5);

    }

    public void addAccounts(Account account){
        accounts.add(account);
        System.out.println("Account added...");
    }

    public void removeAccounts(int accountNum){
        for (Account ac : accounts){
            if (ac.getAccountNumber() == accountNum){
                accounts.remove(ac);
                System.out.println("Account removed...");
            }
        }
        System.out.println("Account Number does not exist.");
    }

    public void accountDetails(int accountNo){
        for (Account ac : accounts){
            if (ac.getAccountNumber() == accountNo){
                System.out.println("Hello "+ ac.getAccountHolder() + " Your Welcome.");
            }
        }

   }

    public void deposit(int accountNum, double depositBalance){

        for (Account a : accounts){
            if (a.getAccountNumber() == accountNum){
                double newBal = a.getBalance() + depositBalance;
                a.setBalance(newBal);
                System.out.println("Your New Balance : " + newBal);
            }
        }
        System.out.println("Account Number does not exist.");
    }

    public void withdraw(int accountNum, double withdrawBalance){

        for (Account a : accounts){
            if (a.getAccountNumber() == accountNum){
                double newBal = a.getBalance() - withdrawBalance;
                a.setBalance(newBal);
                System.out.println("Your New Balance : " + newBal);
            }
        }
        System.out.println("Account Number does not exist.");
    }

    public void allUser(){
        System.out.printf(" ------------------------------------------------%n");
        System.out.printf(" | %-12s | %-20s | %-4s %n", "Name", "Account Number","Balance");
        System.out.printf(" ------------------------------------------------%n");
        for (Account a : accounts){
            System.out.printf(" | %-12s | %-20s | %-4s %n", a.getAccountHolder(),a.getAccountNumber(),a.getBalance());

        }
        System.out.printf(" ------------------------------------------------%n");
    }
}

class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Bank bank = new Bank();

        while (true){
            System.out.println("Enter 1 to 6 ");
            System.out.println("1. Add Account.");
            System.out.println("2. Remove Account.");
            System.out.println("3. Deposit Balance.");
            System.out.println("4. Withdraw Balance.");
            System.out.println("5. Display All User Accounts.");
            System.out.println("6. For Exit.");
            int num = sc.nextInt();

            if (num == 6){
                    System.out.println("Thank You!");
                    break;
            }
            switch (num) {
                case 1 :
                    System.out.print("Enter Account Holder Name : ");
                    String name = sc.next();

                    System.out.print("Enter Account Number : ");
                    int ac = sc.nextInt();

                    System.out.print("Enter Amount : ");
                    int amount = sc.nextInt();

                    Account account = new Account(name, ac , amount);
                    bank.addAccounts(account);

                    break;

                case 2 :
                    System.out.print("Enter Account Number : ");
                    int removeName = sc.nextInt();
                    bank.removeAccounts(removeName);
                    break;

                case 3 :
                    System.out.print("Enter Account Number : ");
                    int accNo = sc.nextInt();
                    bank.accountDetails(accNo);

                    System.out.print("Enter Amount : ");
                    int balances = sc.nextInt();

                    bank.deposit(accNo, balances);

                    break;

                case 4 :
                    System.out.print("Enter Account Number : ");
                    int accN = sc.nextInt();
                    bank.accountDetails(accN);

                    System.out.print("Enter Amount : ");
                    int balancc = sc.nextInt();

                    bank.withdraw(accN, balancc);

                    break;

                case 5 :
                    bank.allUser();
                    break;

                default :
                    System.out.println("Enter Right input...");
            }
        }
    }
}