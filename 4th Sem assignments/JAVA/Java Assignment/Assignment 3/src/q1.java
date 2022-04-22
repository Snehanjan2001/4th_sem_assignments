import java.util.*;

public class q1 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        Store store = new Store();
        int choice = 0;

        while(choice == 0){
            System.out.println("\n0.Exit");
            System.out.println("1.Add Employee");
            System.out.println("2.Add Department");
            System.out.println("3.Display Employee Details");
            System.out.println("4.Display All Employees");
            System.out.println("5.Compute Total Basic Pay");
            System.out.println("6.Remove Employee");
            System.out.println("7.Change Basic Pay");
            System.out.println("8.Sort List");
            System.out.print("Enter Choice: ");
            choice = Integer.parseInt(s.nextLine());
            System.out.println();

            switch(choice){
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    Employee employee = new Employee();
                    while(true){
                        System.out.print("Enter Employee Code: ");
                        int code = Integer.parseInt(s.nextLine());
                        if(store.empCodeExists(code) == false){
                            employee.setCode(code);
                            break;
                        }  else {
                            System.out.println("Code Already Exists!! Try Again!");
                        }
                    }
                    System.out.print("Enter Employee Name: ");
                    employee.setName(s.nextLine());
                    while(true){
                        System.out.print("Enter Department Code: ");
                        int code = Integer.parseInt(s.nextLine());
                        if(store.deptCodeExists(code)){
                            employee.setDeptCode(code);
                            break;
                        } else {
                            System.out.println("No Such Department Found!! Try Again!");
                        }
                    }
                    System.out.print("Enter Employee Basic Pay: ");
                    employee.setBasicPay(Integer.parseInt(s.nextLine()));
                    store.addEmployee(employee);
                    System.out.println("Employee Added Successfully!");
                    break;

                case 2:
                    Department department = new Department();
                    while(true){
                        System.out.print("Enter Department Code: ");
                        int code = Integer.parseInt(s.nextLine());
                        if(!store.deptCodeExists(code)){
                            department.setCode(code);
                            break;
                        }  else {
                            System.out.println("Code Already Exists!! Try Again!");
                        }
                    }
                    System.out.print("Enter Department Name: ");
                    department.setName(s.nextLine());
                    System.out.print("Enter Department Location: ");
                    department.setLocation(s.nextLine());
                    store.addDepartment(department);
                    System.out.println("Department Added Successfully!");
                    break;

                case 3:
                    while(true){
                        System.out.print("Enter Employee Code: ");
                        int code = Integer.parseInt(s.nextLine());
                        if(store.empCodeExists(code)){
                            System.out.println("\nThe details are: \n");
                            System.out.println(store.displayEmployee(code));
                            break;
                        } else {
                            System.out.println("Enter Valid Code!!");
                        }
                    }
                    break;

                case 4:
                    store.displayAllEmployees();
                    break;

                case 5:{
                    System.out.print("Enter Department Code: ");
                    int code = Integer.parseInt(s.nextLine());
                    if(store.deptCodeExists(code)){
                        System.out.println("Total Basic Pay is " + store.getTotalBasicPay(code));
                    } else {
                        System.out.println("Department Does Not Exist!!");
                    }
                }
                break;


                case 6:{
                    System.out.print("Enter Employee Code: ");
                    int code = Integer.parseInt(s.nextLine());
                    if(store.empCodeExists(code)){
                        store.deleteEmployee(code);
                        System.out.println("Employee Deleted Successfully!!");
                    } else {
                        System.out.println("Employee Does Not Exist!!");
                    }
                }
                break;

                case 7:{
                    System.out.print("Enter Employee Code: ");
                    int code = Integer.parseInt(s.nextLine());
                    if(store.empCodeExists(code)){
                        System.out.print("Enter New Basic Pay: ");
                        store.changeBasicPay(code, Integer.parseInt(s.nextLine()));
                    } else {
                        System.out.println("Employee Does Not Exist!!");
                    }
                    System.out.println("Basic Pay Changed!");
                }
                break;

                case 8:{
                    System.out.println("\nSort By: ");
                    System.out.println("1.Basic Pay");
                    System.out.println("2.Employee Code");
                    System.out.println("3.Department Code");
                    System.out.print("Enter Choice: ");
                    int ch = Integer.parseInt(s.nextLine());
                    System.out.println();

                    switch(ch){
                        case 1:
                            store.sortByBasicPay();
                            break;
                        case 2:
                            store.sortByEmpCode();
                            break;
                        case 3:
                            store.sortByDeptCode();
                            break;
                        default:
                            System.out.println("Enter Valid Choice!!");
                    }

                    store.displayAllEmployees();
                }
            }
        }
        s.close();
    }
}

class Department{
    private int code;
    private String name;
    private String location;

    public void setCode(int code){
        this.code = code;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public int getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    public String getLocation(){
        return location;
    }

    @Override
    public String toString(){
        return "\nDepartment Name: " + name + "\nDepartment Code: " + code + "\nLocation: " + location;
    }
}

class Employee{
    private int code;
    private String name;
    private int basicPay;
    private int deptCode;

    public void setCode(int code){
        this.code = code;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBasicPay(int basicPay){
        this.basicPay = basicPay;
    }

    public void setDeptCode(int deptCode){
        this.deptCode = deptCode;
    }

    public int getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    public int getBasicPay(){
        return basicPay;
    }

    public int getDeptCode(){
        return deptCode;
    }

    public static Comparator<Employee> basicPayComparator = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2){
            return e1.getBasicPay() - e2.getBasicPay();
        }
    };

    public static Comparator<Employee> employeeCodeComparator = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2){
            return e1.getCode() - e2.getCode();
        }
    };

    public static Comparator<Employee> departmentCodeComparator = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2){
            return e1.getDeptCode() - e2.getDeptCode();
        }
    };

    @Override
    public String toString(){
        return "\nName: " + name + "\nEmployee Code: " + code + "\nBasic Pay: " + basicPay + "\nDepartment Code: " + deptCode;
    }
}

class Store{
    private List<Department> departments = new ArrayList<Department>();
    private List<Employee> employees = new ArrayList<Employee>();

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void addDepartment(Department department){
        departments.add(department);
    }

    public boolean deptCodeExists(int code){
        for(Department department: departments){
            if(department.getCode() == code){
                return true;
            }
        }
        return false;
    }

    public boolean empCodeExists(int code){
        for(Employee employee : employees){
            if(employee.getCode() == code){
                return true;
            }
        }
        return false;
    }

    public String displayDepartment(int code){
        for(Department department: departments){
            if(department.getCode() == code){
                return department.toString();
            }
        }
        return "";
    }

    public String displayEmployee(int code){
        for(Employee employee : employees){
            if(employee.getCode() == code){
                return employee.toString() + this.displayDepartment(employee.getDeptCode());
            }
        }
        return "";
    }

    public void displayAllEmployees(){
        if(!employees.isEmpty()){
            System.out.println("Employee Details Are: ");
            int i = 1;
            for(Employee employee : employees){
                System.out.print(i++ + ":");
                System.out.println(this.displayEmployee(employee.getCode()) + "\n");
            }
        } else {
            System.out.println("No Employees Added!!");
        }
    }

    public int getTotalBasicPay(int code){
        int sum = 0;
        for(Employee employee : employees){
            if(employee.getDeptCode() == code) sum += employee.getBasicPay();
        }

        return sum;
    }

    public void deleteEmployee(int code){
        for(Employee employee : employees){
            if(employee.getCode() == code)  employees.remove(employee);
        }

        return;
    }

    public void changeBasicPay(int code, int basicPay){
        for(Employee employee : employees){
            if(employee.getCode() == code){
                employee.setBasicPay(basicPay);
            };
        }
    }

    public void sortByBasicPay(){
        Collections.sort(employees, Employee.basicPayComparator);
    }

    public void sortByEmpCode(){
        Collections.sort(employees, Employee.employeeCodeComparator);
    }

    public void sortByDeptCode(){
        Collections.sort(employees, Employee.departmentCodeComparator);
    }
}