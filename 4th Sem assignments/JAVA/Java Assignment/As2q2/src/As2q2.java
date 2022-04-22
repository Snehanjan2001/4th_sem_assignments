

import java.util.Scanner;


class Address{
	private String premisesNumber;
	private String street;
	private String city;
	private String state;
	private int pincode;
	
	Address(String premisesNumber, String street, String city, String state, int pincode) {
		this.premisesNumber = premisesNumber;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}		
	
	public String getPremisesNumber() {return premisesNumber;}
	public void setPremisesNumber(String premisesNumber) {this.premisesNumber = premisesNumber;}
	public String getStreet() {return street;}
	public void setStreet(String street) {this.street = street;}
	public String getCity() {return city;}
	public void setCity(String city) {this.city = city;}
	public String getState() {return state;}
	public void setState(String state) {this.state = state;}
	public int getPincode() {return pincode;}
	public void setPincode(int pincode) {this.pincode = pincode;}
	public String getAddress() {
		return premisesNumber + ", " + street + ", " + city + ", " + state + ", pincode : " + pincode; 
	}
}

class Person{
	private Address address;
	private String name;
	private String phoneNumber;
	private String emailId;
	
	Person(Address address, String name, String phoneNumber, String emailId) {
		super();
		this.address = address;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}
	
	public Address getAddress() {return address;}
	public void setAddress(Address address) {this.address = address;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPhoneNumber() {return phoneNumber;}
	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
	public String getEmailId() {return emailId;}
	public void setEmailId(String emailId) {this.emailId = emailId;}

	public void show() {
		System.out.println("Name : " + name);
		System.out.println("Phone no : " + phoneNumber);
		System.out.println("Email ID : " + emailId);
		System.out.println("Address : " + address.getAddress());
	}
}

class Student extends Person {
	private String rollNo;
	private String courseOfStudy;
	
	Student(Address address, String name, String phoneNumber, String emailId, String rollNo, String courseOfStudy) {
		super(address, name, phoneNumber, emailId);
		this.rollNo = rollNo;
		this.courseOfStudy = courseOfStudy;
	}
	
	public String getRollNo() {return rollNo;}
	public void setRollNo(String rollNo) {this.rollNo = rollNo;}
	public String getCourseOfStudy() {return courseOfStudy;}
	public void setCourseOfStudy(String courseOfStudy) {this.courseOfStudy = courseOfStudy;}
	
	public void show() {
		super.show();
		System.out.println("Roll no : " + rollNo);
		System.out.println("Course of study : " + courseOfStudy);
	}
}

class Faculty extends Person{
	private String id;
	private String department;
	private String specialisation;
	
	Faculty(Address address, String name, String phoneNumber, String emailId, String id, String department, String specilisation) {
		super(address, name, phoneNumber, emailId);
		this.id = id;
		this.department = department;
		this.specialisation = specilisation;
	}
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	public String getDepartment() {return department;}
	public void setDepartment(String department) {this.department = department;}
	public String getSpecialisation() {return specialisation;}
	public void setSpecialisation(String specialisation) {this.specialisation = specialisation;}
	
	public void show() {
		super.show();
		System.out.println("ID : " + id);
		System.out.println("Department : " + department);
		System.out.println("Specialisation : " + specialisation);
	}
}

public class As2q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name, phoneNumber,  email, premisesNumber, city, street, state, rollNo, courseOfStudy, id, department, specialisation;
		int pincode;
		
		System.out.println("Adding new student ->");
		System.out.print("Enter name : ");
		name = sc.nextLine();
		System.out.print("Enter phone no : ");
		phoneNumber = sc.nextLine();
		System.out.print("Enter email id : ");
		email = sc.nextLine();
		System.out.print("Enter premises number : ");
		premisesNumber = sc.nextLine();
		System.out.print("Enter street : ");
		street = sc.nextLine();
		System.out.print("Enter city : ");
		city = sc.nextLine();
		System.out.print("Enter state : ");
		state = sc.nextLine();
		System.out.print("Enter pincode : ");
		pincode = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter roll no : ");
		rollNo = sc.nextLine();
		System.out.print("Enter course of study : ");
		courseOfStudy = sc.nextLine();
		Address address = new Address(premisesNumber, street, city, state, pincode);
		Student student = new Student(address, name, phoneNumber, email, rollNo, courseOfStudy);
		student.show();
		
		System.out.println("\n\nAdding new faculty employee ->");
		System.out.print("Enter name : ");
		name = sc.nextLine();
		System.out.print("Enter phone no : ");
		phoneNumber = sc.nextLine();
		System.out.print("Enter email id : ");
		email = sc.nextLine();
		System.out.print("Enter premises number : ");
		premisesNumber = sc.nextLine();
		System.out.print("Enter street : ");
		street = sc.nextLine();
		System.out.print("Enter city : ");
		city = sc.nextLine();
		System.out.print("Enter state : ");
		state = sc.nextLine();
		System.out.print("Enter pincode : ");
		pincode = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter id : ");
		id = sc.nextLine();
		System.out.print("Enter department : ");
		department = sc.nextLine();
		System.out.print("Enter specialisation : ");
		specialisation = sc.nextLine();
		address = new Address(premisesNumber, street, city, state, pincode);
		Faculty faculty = new Faculty(address, name , phoneNumber, email, id, department, specialisation);
		faculty.show();
		
		sc.close();
	}

}
