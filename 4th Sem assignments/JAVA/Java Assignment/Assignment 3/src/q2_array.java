import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q2_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bank2 Bank;
        Bank = new bank2();
        int choice = 1;

        while(choice !=0) {
            System.out.println("\n0.Exit");
            System.out.println("1.Add Account");
            System.out.println("2.Display All Accounts");
            System.out.println("3.Check Account Exists?");
            System.out.println("4.Check Balance");
            System.out.print("Enter Your Choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    Bank.addAccount(sc);
                    break;
                case 2:
                    Bank.displayAllAccounts();
                    break;
                case 3:
                    System.out.println("Enter account number to check for existence");
                    int tempnum = Integer.parseInt(sc.nextLine());
                    if (Bank.accountexists(tempnum)) {
                        System.out.println("Account exists");
                    } else {
                        System.out.println("Account does not exists");
                    }
                    break;
                case 4:
                    System.out.println("Enter account to check balance of");
                    int tempacb = Integer.parseInt(sc.nextLine());
                    Bank.getBalance(tempacb);
            }
        }
        sc.close();
    }
}

class account2{
    int number;
    String name;
    int balance;

    public account2(int number, String name, int balance) {
        this.number = number;
        this.name = name;
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void showAccount(){
        System.out.println("The account number is"+number+" with name and balance as "+name+"and "+balance);
        System.out.println("A/C No : "+this.number);
        System.out.println("Name : "+this.name);
        System.out.println("Balance : " +this.balance);
    }
}

class bank2{
    account2 accounts[];
    int noOfAccounts;
    int maxAccounts;
    
    public bank2(){
    	accounts = new account2[100];
    	maxAccounts = 100;
    	noOfAccounts = 0;
    }
    
    public void addAccount(Scanner sc){
        System.out.println("Enter account number");
        int tempnumber=Integer.parseInt(sc.nextLine());
        if(accountexists(tempnumber)){
            System.out.println("Account already exists!");
        }
        else if(noOfAccounts > maxAccounts) {
        	System.out.println("Array is full !");
        }
        else{
            System.out.println("Enter account name");
            String tempname=sc.nextLine();
            System.out.println("Enter account balance");
            int tempbalance=Integer.parseInt(sc.nextLine());
            account2 newaccount=new account2(tempnumber,tempname,tempbalance);
            accounts[noOfAccounts++] = newaccount;
        }

    }
    public boolean accountexists(int acn){
    	account2 Account;
        for(int i = 0; i < noOfAccounts; i++){
        	Account = accounts[i];
            if(Account.getNumber()==acn){
                return true;
            }
        }
        return false;
    }
    public void getBalance(int acn){
        if(accountexists(acn)){
        	account2 Account;
            for(int i = 0; i < noOfAccounts; i++){
            	Account = accounts[i];
                if(Account.getNumber()==acn){
                    System.out.println("The account balance is "+ Account.getBalance());
                }
            }
        }
        else{
            System.out.println("Account does not exists!");
        }
    }
    public void displayAllAccounts(){
    	account2 Account;
        for(int i = 0; i < noOfAccounts; i++){
        	Account = accounts[i];
            Account.showAccount();
        }
    }
}