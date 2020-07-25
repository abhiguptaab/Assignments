package com.montran.Main;
import java.util.*;

import com.montran.pojo.Employee;
import com.montran.util.EmployeeCollectionUtil;
public class EmployeeCollectioMain {

	public static void main(String[] args) {
		
		
		int employeeId;
		String name;
		double salary;
		
		Scanner sc = new Scanner(System.in);
		
		EmployeeCollectionUtil util = new EmployeeCollectionUtil();
		
		System.out.println("No Books Present right Now");
		int userchoice;
		
		while(true){
			System.out.println("-------Menu------");
			System.out.println("1. Add Single Employee");
			System.out.println("2. Add Multiple Employee");
			System.out.println("3. Update existing Employee");
			System.out.println("4. Delete existing Employee");
			System.out.println("5. Print Single Book Employee");
			System.out.println("6. Exit");
			
			System.out.println("Enter Your Choice");
			userchoice = sc.nextInt();
			
			switch (userchoice) {
			case 1:
				System.out.println("Accept Employeeid");
				employeeId = sc.nextInt();
				System.out.println("Accept Name");
				name = sc.nextLine();
				name = sc.nextLine();
				System.out.println("Accept salary");
				salary = sc.nextDouble();
				Employee employee = new Employee(employeeId, name, salary);
				util.addNewEmployee(employee);
				break;
			case 2:
				System.out.println("How Many Books Do You Want to add?");
				int numberAddBook = sc.nextInt();
				for(int i=0; i<numberAddBook; i++) {
					System.out.println("Accept  id");
					employeeId = sc.nextInt();
					System.out.println("Accept Name");
					name = sc.nextLine();
					name =sc.nextLine();
					System.out.println("Accept  price");
					salary = sc.nextDouble();
					Employee[] employees = new Employee[numberAddBook];
					employees[i] = new Employee(employeeId, name, salary);
					util.addNewEmployees(employees);
				}
				break;
			
			case 3:
				System.out.println("Accept Employeeid from user");
				int empId = sc.nextInt();
				Employee checkemployee = util.showSingleEmployee(empId);
				if(checkemployee == null) {
					System.out.println("Employee is not present");
				}
				System.out.println("Accept new employeeid");
				int newemployeeId = sc.nextInt();
				System.out.println("Accept new name");
				String newName = sc.nextLine();
				sc.nextLine();
				System.out.println("Accept new  salary");
				double newsalary = sc.nextDouble();
		
				util.updateEmployee(empId, newName, newsalary);
				break;
				
				
			case 4:
				System.out.println("Accept employeeid from user");
				int empID = sc.nextInt();
				Employee checkemployees = util.showSingleEmployee(empID);
				if(checkemployees == null) {
					System.out.println("Employee is not present");
				}
				
				
		
				util.deleteEmployee(empID);
				break;				
				
			case 5:
				System.out.println("Accept employeeid from user");
				int employeeidshow = sc.nextInt();
				Employee employeeidcheck = util.showSingleEmployee(employeeidshow);
				
				if(employeeidcheck == null) {
					System.out.println("Book is not resent");
				}
				System.out.println(employeeidcheck);
		
				break;
				//break;
				
			case 6:
				break;
				
			default:
				System.out.println("Invalid Choice");
			}
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" Employee Table ");
			System.out.println("   Employee ID    +   Employee name    +    Salary");
			System.out.println("------------------------------------------------");
			
			List<Employee> showemployee = util.getAllEmployees();
			for(int i=0; i<showemployee.size(); i++) {
				if(showemployee.get(i) != null)
				{
					System.out.println(showemployee.get(i));
				}
					
			}
			
			
			System.out.println("Do you want to continue yes/ no?");
			String choice = sc.next();
			if(choice == "no")
				break;
		}// End of while
		
		System.out.println();

	}

}
