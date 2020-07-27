package com.montran.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.montran.pojo.Employee;
import com.montran.util.DatabaseUtil;

public class EmployeeMainV1 {

	public static void main(String[] args) {
		int employeeId;
		String name;
		double salary;
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee(0, "", 00.00);
		DatabaseUtil util = new DatabaseUtil(employee);
		boolean checkConnection;
		try {
			util.loadJDBCdriver();
			checkConnection = util.connectToDatabase();
			if(checkConnection == true) {
				System.out.println("Database connected Successfully");
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		
		while(true){
			System.out.println("-------Menu------");
			System.out.println("1. Add Single Employee");
			System.out.println("2. Add Multiple Employee");
			System.out.println("3. Update existing Employee");
			System.out.println("4. Delete existing Employee");
			System.out.println("5. Print Single  Employee");
			System.out.println("6. Exit");
			
			System.out.println("Enter Your Choice");
			int userchoice = sc.nextInt();
			
			switch (userchoice) {
			case 1:

				System.out.println("Accept Employeeid");
				employeeId = sc.nextInt();
				System.out.println("Accept Name");
				name = sc.nextLine();
				name = sc.nextLine();
				System.out.println("Accept salary");
				salary = sc.nextDouble();
				employee = new Employee(employeeId, name, salary);
				try {
					util.addNewEmployee(employee);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				System.out.println("How Many Employees Do You Want to add?");
				int numberAddBook = sc.nextInt();
				for(int i=0; i<numberAddBook; i++) {

					System.out.println("Accept Employeeid");
					employeeId = sc.nextInt();
					System.out.println("Accept Name");
					name =sc.nextLine();
					sc.nextLine();
					System.out.println("Accept  salary");
					salary = sc.nextDouble();
					//Employee[] employees = new Employee[numberAddBook];
					employee = new Employee(employeeId, name, salary);
					try {
						util.addNewEmployee(employee);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			
			case 3:
				System.out.println("Accept Employeeid to be updated from user");
				int empId = sc.nextInt();
				System.out.println("Accept new name");
				String newName = sc.nextLine();
				sc.nextLine();
				System.out.println("Accept new  salary");
				double newsalary = sc.nextDouble();
		
				try {
					util.updateEmployee(empId, newName, newsalary);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
				
			case 4:
				System.out.println("Accept employeeid from user");
				int empID = sc.nextInt();
				try {
					util.Delete(empID);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;				
				
			case 5:
				System.out.println("Accept employeeid from user");
				int employeeidshow = sc.nextInt();
			    try {
					util.getSingleEmployee(employeeidshow);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
				break;
				//break;
				
			case 6:
				break;
				
			default:
				System.out.println("Invalid Choice");
			}
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("Employee Details");
			System.out.println("");
			try {
				util.getAllEmployees();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println("Do you want to continue yes/ no?");
			String choice = sc.nextLine();
			if(choice == "no") {
				try {
					util.closeConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
				
		}// End of while

	}

}
