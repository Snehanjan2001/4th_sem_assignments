

import java.util.Scanner;

class Customer{
	int id;
	String name;
	String phoneno;
	int loanAmount;
	
	public static int lastId;
	public static int creditLimit;

	boolean isPriviliged = false;
	int priviligedCreditLimit = 0;
	
	Customer(String name, String phoneNo){
		lastId++;
		this.id = lastId;
		this.name = name;
		this.phoneno = phoneNo;
		this.loanAmount = 0;
	}
	
	String getName() {
		return this.name;
	}
	
	String getPhoneNo() {
		return this.phoneno;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	void setPhoneNo(String phoneNo) {
		this.phoneno = phoneNo;
	}
	
	boolean askAmount(int amount) {
		if((loanAmount + amount) > getCreditLimit()) {
			return false;
		}
		
		loanAmount = loanAmount + amount;
		return true;
		
	}
	
	boolean upgradeToPriviliged(int amount) {
		if(isPriviliged) return false;
		isPriviliged = true;
		priviligedCreditLimit = amount;
		return true;
	}
	
	int getCreditLimit() {
		if(isPriviliged) {
			return priviligedCreditLimit;
		}
		return creditLimit;
	}
	
	int getLoanAmount() {
		return loanAmount;
	}
	
	int getAvailableLoanAmount() {
		return getCreditLimit() - loanAmount;
	}
	
	void showDetails() {
		System.out.println("==================================");
		System.out.println("Id : "+id);
		System.out.println("Type : " + (!isPriviliged ? "Normal" : "Priviliged"));
		System.out.println("Name : "+name);
		System.out.println("Phone No : "+ phoneno);
		System.out.println("Credit limit : "+getCreditLimit());
		System.out.println("Loan amount : "+getLoanAmount());
		System.out.println("Available for loan : "+getAvailableLoanAmount());
		System.out.println("==================================");
	}
	
}


public class as2q1 {

	public static void convertToPriviliged(Customer c) {
		char choice ;
		int amount;
		Scanner sc = new Scanner(System.in);
		System.out.print("Do you want to convert customer1 to priviliged customer(y/n) : ");
		choice = sc.nextLine().charAt(0);
		if(choice == 'y' || choice == 'Y' ) {
			System.out.println("Enter the priviliged credit limit : ");
			amount = sc.nextInt();
			sc.nextLine();
			c.upgradeToPriviliged(amount); // Upgrade to privileged with mentioned amount
			System.out.println("Customer "+c.id+" upgraded to priviliged ");
		}
	}
	
	public static void takeLoan(Customer c) {
		int amount;
		System.out.print("Enter amount of loan required : ");
		Scanner sc = new Scanner(System.in);
		amount = sc.nextInt();
		sc.nextLine();
		if(c.askAmount(amount)) { // askAmount() will return a boolean value
			System.out.println("Loan credited !");
		}else{
			System.out.println("Loan credit failed !");
		};	
	}

	public static void main(String[] args) {
		Customer.creditLimit = 1000;
		
		System.out.println("\nDefault credit limit : " + Customer.creditLimit + "\n");
		
		
		Customer c1 ,c2 ;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first customer details => ");
		System.out.print("Enter name : ");
		String first_customer_name = sc.nextLine();
		System.out.print("Enter phone no : ");
		String first_customer_phone_no = sc.nextLine();
		System.out.print("Enter name : ");
		String second_customer_name = sc.nextLine();
		System.out.print("Enter phone no : ");
		String second_customer_phone_no = sc.nextLine();
		
		c1 = new Customer(first_customer_name, first_customer_phone_no);
		c2 = new Customer(second_customer_name, second_customer_phone_no);
		

		convertToPriviliged(c1);	// User input to convert account to priviliged	
		convertToPriviliged(c2);		
		
		takeLoan(c1); // User input to take loan
		takeLoan(c2);
		
		c1.showDetails();
		c2.showDetails();
		
		sc.close();
	}

}



