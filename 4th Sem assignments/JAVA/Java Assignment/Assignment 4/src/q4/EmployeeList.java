package q4;

import java.util.*;

public class EmployeeList {
	List<Employee> employee_list ;
	
	public EmployeeList(){
		employee_list = new ArrayList<Employee>();
	}
	
	public Employee getEmployeeByIndex(int index) {
		return employee_list.get(index);
	}
	
	public int getIndexByEmpCode(String empcode) {
		int index = -1;
		for(int i = 0 ; i < employee_list.size() ; i++) {
			if(employee_list.get(i).getCode().equals(empcode)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public boolean isExists(String empcode) {
		if(getIndexByEmpCode(empcode) == -1) {
			return false;
		}
		return true;
	}
	
	public boolean addEmployee(Employee employee) {
		if(isExists(employee.code)) {
			return false;
		}
		employee_list.add(new Employee(employee));
		return true;
	}
	
}
