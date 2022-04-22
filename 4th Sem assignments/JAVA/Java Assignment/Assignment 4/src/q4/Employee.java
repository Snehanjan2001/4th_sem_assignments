package q4;

public class Employee {
	String code;
	String name;
	int basicSalary;
	String grade;
	String deptCode;
	
	public Employee() {
		code = "";
		name = "";
		basicSalary = 0;
		grade = "";
		deptCode = "";
	}
	
	public Employee(Employee e) {
		this.code = e.code;
		this.name = e.name;
		this.basicSalary = e.basicSalary;
		this.grade = e.grade;
		this.deptCode = e.deptCode;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	
	public void display() {
		System.out.println("Employee code : "+this.code);
		System.out.println("Employee name : "+this.name);
		System.out.println("Basic salary : "+this.basicSalary);
		System.out.println("Grade : "+this.grade);
		System.out.println("Dept : "+this.deptCode);
	}
	
}
