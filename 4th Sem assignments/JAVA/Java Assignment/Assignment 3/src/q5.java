import java.io.*;
import java.util.*;

class Student implements Serializable{
	String roll;
	String name;
	int score;
	
	public Student() {}	
	public Student(String roll, String name, int score) {
		this.roll = roll;
		this.name = name;
		this.score = score;
	}
	
	public void print() {
		System.out.println("Name : "+this.name);
		System.out.println("Roll : "+this.roll);
		System.out.println("Score : "+this.score);
	}
}

public class q5 {
	public static void main(String[] args) {
		String filename = "names.txt";
		String choice, name , roll;
		int score;
		Student s;
		
		Scanner sc = new Scanner(System.in);

		
		try {
			FileOutputStream file_out = new FileOutputStream(new File(filename));
			ObjectOutputStream object_out = new ObjectOutputStream(file_out);

			while(true) {
				System.out.print("Do you want to add student [y/n]:");
				choice = sc.nextLine();
				if(choice.equals("n") || choice.equals("N")) {
					break;
				}
				System.out.print("Enter roll no : ");
				roll = sc.nextLine();
				System.out.print("Enter name : ");
				name = sc.nextLine();
				System.out.print("Enter score : ");
				score = sc.nextInt();
				sc.nextLine();
				
				s = new Student(roll, name, score);
				object_out.writeObject(s);
			}
			
			object_out.close();
			file_out.close();
				
			System.out.println("All the students has been writen in file!");
			

			FileInputStream file_in = new FileInputStream(new File(filename));
			ObjectInputStream object_in = new ObjectInputStream(file_in);
			
			s = null;
			
			
			while(true) {
				try {
					s=(Student)object_in.readObject();
					s.print();
				}catch(EOFException e) {
					break;
				}
			}
			
			object_in.close();
			file_in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
