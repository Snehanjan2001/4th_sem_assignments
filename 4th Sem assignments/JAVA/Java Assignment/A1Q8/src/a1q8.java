import java.util.Scanner;

class Student {
	int rollno = 0;
	double marks = 0;
	String name = " ";

	Student(int r, String n, double m) {
		rollno = r;
		name = n;
		marks = m;
	}

	Student(int r) {
		rollno = r;

	}

	Student(int r, String n) {
		rollno = r;
		name = n;
	}

	Student() {

	}

	// Copy Constructor
	Student(Student s) {
		rollno = s.rollno;
		name = s.name;
		marks = s.marks;
	}

	void display() {
		System.out.println("ROLL NO : " + rollno);
		System.out.println("NAME : " + name);
		System.out.println("MARKS : " + marks);
	}

	void setattributes(int r, String n, double m) {
		rollno = r;
		name = n;
		marks = m;
	}

	void copy(Student s) {
		rollno = s.rollno;
		name = s.name;
		marks = s.marks;
	}
}

class a1q8 {
	public static void main(String args[]) {
		Student s1 = new Student(1);
		Student s2 = new Student(2, "XYZ");
		Student s3 = new Student(3, "ABC", 90.5);
		Student s4 = new Student();
		Student me = new Student(1, "XYZ", 80);
		Student hi = me;
		hi.display();// SHALOW COPY
		me.name = "ABC";
		hi.display();// SHALLOW COPY RESULT
		Student hi1 = new Student(me);
		hi1.display();// DEEP COPY
		me.name = "XYZ";
		hi1.display();// DEEP COPY RESULT
		s1.display();
		s2.display();
		s3.display();
		s4.display();

	}
}
