package q4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.*;
import javax.swing.border.EmptyBorder;




class MainFrame extends JFrame implements ActionListener{
	JPanel formPanel;
    JPanel gradeButtonsPanel;
    JPanel actionButtonsPanel;

	JLabel topHeaderLabel;
	JLabel empCodeLabel;
	JLabel empNameLabel;
	JLabel empBasicSalaryLabel;
	JLabel empGradeLabel;
	JLabel empDeptCodeLabel;

	JTextField empCodeTextField;
	JTextField empNameTextField;
	JTextField empBasicSalaryTextField;

	JRadioButton gradeAButton;
	JRadioButton gradeBButton;
	JRadioButton gradeCButton;
	ButtonGroup gradeButtonGrp;

    
    JComboBox<String[]> deptCodeDropdown;
    
    JButton submitButton;
    JButton searchButton;
    
    Employee tmpEmployee;
    EmployeeList employeeList;
    
    HashMap<String, String> deptList;
	
	public MainFrame(EmployeeList employeeList, HashMap<String, String> deptList) {
		tmpEmployee = new Employee();
		
		this.employeeList = employeeList;
		this.deptList = deptList;
		
		this.setTitle("Employee management system");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
//		this.setSize(640, 480);
		
		// Top Label
		topHeaderLabel = new JLabel();
		topHeaderLabel.setText("Add Employee");
		topHeaderLabel.setHorizontalAlignment(JLabel.CENTER);
		topHeaderLabel.setBorder(new EmptyBorder(10, 0, 10 , 0));
		topHeaderLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
		

		
		
		// All labels
		empCodeLabel = new JLabel("Employee code : ");
		empNameLabel = new JLabel("Employee name : ");
		empBasicSalaryLabel = new JLabel("Employee basic salary : ");
		empGradeLabel = new JLabel("Choose grade : ");
		empDeptCodeLabel = new JLabel("Choose department : ");
		
		
		// Empcode Text field
		empCodeTextField = new JTextField();
		empCodeTextField.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		// Empname Text field
		empNameTextField = new JTextField();
		empNameTextField.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		// Emp basic salary Text field
		empBasicSalaryTextField = new JTextField();
		empBasicSalaryTextField.setFont(new Font("Consolas", Font.PLAIN, 15));
		
		
		// Grade
		gradeButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
		gradeButtonGrp = new ButtonGroup();
		gradeAButton = new JRadioButton("Grade A");
		gradeBButton = new JRadioButton("Grade B");
		gradeCButton = new JRadioButton("Grade C");
		gradeButtonGrp.add(gradeAButton);
		gradeButtonGrp.add(gradeBButton);
		
		gradeButtonsPanel.add(gradeAButton);
		gradeButtonsPanel.add(gradeBButton);
		gradeButtonsPanel.add(gradeCButton);
		
		
		// Dept code dropdown
		deptCodeDropdown = new JComboBox(deptList.values().toArray());
		
		
		// Form
		formPanel = new JPanel(new GridLayout(5,2, 10, 10));
		formPanel.setBorder(new EmptyBorder(10, 20, 10,20));
		
		formPanel.add(empCodeLabel); formPanel.add(empCodeTextField); 
		formPanel.add(empNameLabel); formPanel.add(empNameTextField); 
		formPanel.add(empBasicSalaryLabel); formPanel.add(empBasicSalaryTextField); 
		formPanel.add(empGradeLabel); formPanel.add(gradeButtonsPanel); 
		formPanel.add(empDeptCodeLabel); formPanel.add(deptCodeDropdown); 
		
		
		
				
		// Action Buttons Panel
		actionButtonsPanel = new JPanel(new BorderLayout());
		
		// Submit button
		submitButton = new JButton();
		submitButton.setFocusable(false);
		submitButton.setText("SAVE");
		submitButton.addActionListener(this);
		
		// Search Button
		searchButton = new JButton();
		searchButton.setFocusable(false);
		searchButton.setText("SEARCH");
		searchButton.addActionListener(this);
		
		// Add buttons
		actionButtonsPanel.add(submitButton, BorderLayout.EAST);
		actionButtonsPanel.add(searchButton, BorderLayout.WEST);
		actionButtonsPanel.setBorder(new EmptyBorder(40, 20, 30, 20));
		
		
		
		this.add(topHeaderLabel, BorderLayout.NORTH);
		this.add(formPanel, BorderLayout.CENTER);
		this.add(actionButtonsPanel, BorderLayout.SOUTH);
		this.setVisible(true);
		this.setLocation(50, 350);
		this.pack();
	}

	public void refreshDataFromInput() {
		tmpEmployee.setCode(empCodeTextField.getText());
		tmpEmployee.setName(empNameTextField.getText());
		String basicSalary = empBasicSalaryTextField.getText();
		
		try {
			if(basicSalary.isEmpty()) tmpEmployee.setBasicSalary(0);
			else tmpEmployee.setBasicSalary(Integer.parseInt(empBasicSalaryTextField.getText()));
		}catch(Exception e) {
			tmpEmployee.setBasicSalary(0);
			empBasicSalaryTextField.setText("0");
			JOptionPane.showMessageDialog(null,"Basic salary can be only numbers [0~9]", "Warning !", JOptionPane.WARNING_MESSAGE);
		}
		
		// Resolve dept code from dropdown
		String deptName = (String)deptCodeDropdown.getSelectedItem();
	    for(Entry<String, String> entry: deptList.entrySet()) {
	    	if(entry.getValue() == deptName) {
	    		tmpEmployee.setDeptCode(entry.getKey());
	    		break;
	    	}else {
	    		tmpEmployee.setDeptCode("");
	    	}
	    }
	    
	    // Resolve grade from radio button group
	    if(gradeAButton.isSelected()) {
	    	tmpEmployee.setGrade("a");
	    }else if(gradeBButton.isSelected()) {
	    	tmpEmployee.setGrade("b");
	    }else if(gradeCButton.isSelected()) {
	    	tmpEmployee.setGrade("c");
	    }else {
	    	tmpEmployee.setGrade("");
	    }
		
		tmpEmployee.display();
	}
	
	public boolean validateForm() {
		boolean isValid = true;
		
		if(tmpEmployee.code.isEmpty()) {
			isValid = false;
			JOptionPane.showMessageDialog(null,"Employee code can't be empty", "Check & Retry !", JOptionPane.ERROR_MESSAGE);
		}else if(tmpEmployee.name.isEmpty()) {
			isValid = false;
			JOptionPane.showMessageDialog(null,"Employee name can't be empty", "Check & Retry !", JOptionPane.ERROR_MESSAGE);
		}else if(tmpEmployee.basicSalary == 0) {
			isValid = false;
			JOptionPane.showMessageDialog(null,"Employee basic pay/salary can't be zero", "Check & Retry !", JOptionPane.ERROR_MESSAGE);
		}else if(tmpEmployee.grade.isEmpty()) {
			isValid = false;
			JOptionPane.showMessageDialog(null,"Choose employee grade before proceed", "Check & Retry !", JOptionPane.ERROR_MESSAGE);
		}else if(tmpEmployee.deptCode.isEmpty()) {
			isValid = false;
			JOptionPane.showMessageDialog(null,"Choose employee department", "Check & Retry !", JOptionPane.ERROR_MESSAGE);
		}
		
		
		return isValid;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == submitButton) {
			
			int response = JOptionPane.showOptionDialog(null, "Do you want to save the employee details ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
			if(response == 0) {
				// Proceed
				refreshDataFromInput();
				if(validateForm()) {
					if(employeeList.addEmployee(tmpEmployee)) {
						JOptionPane.showMessageDialog(null, "Employee, "+tmpEmployee.getName()+" has been added successfull y!", "Successful", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Sorry, An employee with code "+tmpEmployee.getCode()+" already exists", "Aborted", JOptionPane.ERROR_MESSAGE);
					}
				};
			}else {
				JOptionPane.showMessageDialog(null, "As per request, employee addition has been cancelled ", "Cancelled", JOptionPane.WARNING_MESSAGE);
			}

		}else if(e.getSource() == searchButton) {
			new SearchEmployeFrame(employeeList, deptList);
		}
		
	}
}

class SearchEmployeFrame extends JFrame implements ActionListener{
	JLabel actionLabel;
	
	JLabel empCodeLabel;
	JLabel empNameLabel;
	JLabel empBasicSalaryLabel;
	JLabel empGradeLabel;
	JLabel empDeptCodeLabel;
	
	JLabel empCodeValueLabel;
	JLabel empNameValueLabel;
	JLabel empBasicSalaryValueLabel;
	JLabel empGradeValueLabel;
	JLabel empDeptCodeValueLabel;
	
	JPanel resultPanel;
	JPanel detailsPanel;
	JPanel searchPanel;
	
	JTextField empCodeToSearchField;
	JButton searchBbutton;
	
	
	
	Employee tmpEmployee;
    EmployeeList employeeList;
    
    HashMap<String, String> deptList;
    
    
	SearchEmployeFrame(EmployeeList employeeList, HashMap<String, String> deptList){
		tmpEmployee = new Employee();
		
		this.employeeList = employeeList;
		this.deptList = deptList;
		
		this.setTitle("Search employee");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		this.setSize(640,  480);
		
		
		// All labels
		actionLabel = new JLabel("Search employee by employee code : ");
		empCodeLabel = new JLabel("Employee code : ");
		empNameLabel = new JLabel("Employee name : ");
		empBasicSalaryLabel = new JLabel("Employee basic salary : ");
		empGradeLabel = new JLabel("Choose grade : ");
		empDeptCodeLabel = new JLabel("Choose department : ");
		
		empCodeValueLabel = new JLabel();
		empNameValueLabel = new JLabel();
		empBasicSalaryValueLabel = new JLabel();
		empGradeValueLabel = new JLabel();
		empDeptCodeValueLabel = new JLabel();

		

		
		// Empcode Search Text field
		empCodeToSearchField = new JTextField();
		empCodeToSearchField.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		// Search button
		searchBbutton = new JButton();
		searchBbutton.setFocusable(false);
		searchBbutton.setText("Search");
		searchBbutton.addActionListener(this);
		
		
		// Search panel
		searchPanel = new JPanel(new BorderLayout());
		searchPanel.setBorder(new EmptyBorder(30, 20, 40, 20));
		searchPanel.add(actionLabel, BorderLayout.WEST);
		searchPanel.add(empCodeToSearchField, BorderLayout.CENTER);
		searchPanel.add(searchBbutton, BorderLayout.EAST);
		
	
		
		// Details Panel
		detailsPanel = new JPanel(new GridLayout(5,2, 10, -120));
		detailsPanel.setBorder(new EmptyBorder(-45, 20, 10,20));
		
		detailsPanel.add(empCodeLabel); detailsPanel.add(empCodeValueLabel); 
		detailsPanel.add(empNameLabel); detailsPanel.add(empNameValueLabel); 
		detailsPanel.add(empBasicSalaryLabel); detailsPanel.add(empBasicSalaryValueLabel); 
		detailsPanel.add(empGradeLabel); detailsPanel.add(empGradeValueLabel); 
		detailsPanel.add(empDeptCodeLabel); detailsPanel.add(empDeptCodeValueLabel); 
		
		
		// Result panel
		resultPanel = new JPanel(new BorderLayout());
		JLabel resultLabel = new JLabel("--- Result ---");
		resultLabel.setHorizontalAlignment(JLabel.CENTER);
		resultLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
		
		
		resultPanel.add(resultLabel, BorderLayout.NORTH);
		resultPanel.add(detailsPanel, BorderLayout.CENTER);
		
		resultPanel.setVisible(false);
		
		
		this.add(searchPanel, BorderLayout.NORTH);
		this.add(resultPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setLocation(500, 350);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == searchBbutton) {
			String employeeCode = empCodeToSearchField.getText();
			if(employeeCode.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter an employee code to begin search ", "Aborted", JOptionPane.WARNING_MESSAGE);
				resultPanel.setVisible(false);
				return;
			}
			
			int employeeIndex = employeeList.getIndexByEmpCode(employeeCode);
			if(employeeIndex == -1) {
				JOptionPane.showMessageDialog(null, "No employee found with employee code "+employeeCode, "Not found !", JOptionPane.ERROR_MESSAGE);
				resultPanel.setVisible(false);
				return;
			}
			
			Employee emlpoyee = employeeList.getEmployeeByIndex(employeeIndex);
			empCodeValueLabel.setText(emlpoyee.code);
			empNameValueLabel.setText(emlpoyee.name);
			empBasicSalaryValueLabel.setText(String.valueOf(emlpoyee.getBasicSalary()));
			empGradeValueLabel.setText(emlpoyee.getGrade().toUpperCase()+" Grade");
			empDeptCodeValueLabel.setText(deptList.get(emlpoyee.getDeptCode()));
			resultPanel.setVisible(true);
		}
	}	
	
}

public class q4 {
	static EmployeeList employeeList;
	static HashMap<String, String> deptList;
	
	public static void main(String[] args) {
		
		employeeList = new EmployeeList();
		deptList = new HashMap<>();
        deptList.put("cse", "Computer Science" );
        deptList.put("etce", "ETCE");
        deptList.put("ieee", "IEEE");
        deptList.put("math", "Mathematics");
        deptList.put("physics", "Physics");
        
		new MainFrame(employeeList, deptList);
	}
		
}
