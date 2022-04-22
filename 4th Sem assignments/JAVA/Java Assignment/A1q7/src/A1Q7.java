import java.util.*;
class Student{
	int roll ;
	double score;
	String name;
	
	public Student(int r, String n,double d) {
		roll=r;
		name= n;
		score= d;
		// TODO Auto-generated constructor stub
	}
	
	void display(){
		System.out.println("Roll no is"+ roll);
		System.out.println("Name is "+ name);
		System.out.println("Score is "+ score);
	}
	
	void setattributes(int r, String n, double m){
        roll = r;
        name = n;
        score = m;
    }
    void copy(Student s){
        roll = s.roll;
        name = s.name;
        score = s.score;
    }
}
public class A1Q7 {
	public static void main(String args[]){
        Student s1 = new Student(1,"ABC",90.5);
        Student s2 = new Student(2,"XYZ",80.5);
        s1.display();
        s2.display();
        s1.copy(s2);
        s1.display();
        s2.display();
   }
	

}
