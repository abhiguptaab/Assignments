package com.montran.util;

import java.util.ArrayList;
import java.util.List;

import com.montran.pojo.Employee;

public class EmployeeCollectionUtil {
	private List<Employee> employeeList = new ArrayList<Employee>();
	
	public boolean addNewEmployee(Employee employee) {
		employeeList.add(employee);
		return false;
	}
	
	public boolean addNewEmployees(Employee[] employees) {
	if(employees.length > 0) {
		for(int i=0; i<employees.length; i++) {
			employeeList.add(employees[i]);
		}
		return true;
	}
		return false;
	}
	
	public boolean updateEmployee(int empId, String name, double salary){
		if(employeeList.size() > 0) {
			/*for(int i=0; i<employeeList.size(); i++) {
				Employee employee = employeeList.get(i);
				if( employee.getEmployeeId() == empId) {
					employee.setEmployeeId(empId);
					employee.setName(name);
					employee.setSalary(salary);
					//Employee employee1 = new Employee(empId, name, salary);
					employeeList.set(i, employee);
					return true;
				}
			}
			//return true;*/
			for (Employee employee : employeeList) {
				if( employee.getEmployeeId() == empId) {
					//employee.setEmployeeId(empId);
					//employee.setName(name);
					employee.setSalary(salary);
					//Employee employee1 = new Employee(empId, name, salary);
					//employeeList.set(i, employee);
					
					return true;
				}
		}
	}	
		return false;
	}
	
	public boolean deleteEmployee(int empId){
		if(employeeList.size() > 0) {
			for(int i=0; i<employeeList.size(); i++) {
				Employee employee = employeeList.get(i);
				if(employee.getEmployeeId() == empId) {
					//employee.setEmployeeId(empId);
					//employee.setEmployeeId(empId);
					//employee.setSalary(salary);
					employeeList.remove(i);
					return true;
				}
			}
			
		}
		return false;
	}
	
	public Employee showSingleEmployee(int empId){
		if(employeeList.size() > 0) {
			for(int i=0; i<employeeList.size(); i++) {
				Employee employee = employeeList.get(i);
				if(employee.getEmployeeId() == empId) {
					//employee.setEmployeeId(empId);
					//employee.setEmployeeId(empId);
					//employee.setSalary(salary);
					Employee emp =employeeList.get(i);
					return emp;
					//return true;
				}
			}
			
		}
		return null;
	}

	
	public List<Employee> getAllEmployees() {
		return employeeList;
	}

}