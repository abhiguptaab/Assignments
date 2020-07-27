package com.montran.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.montran.pojo.Employee;

//import jdk.nashorn.internal.objects.SetIterator;

public class DatabaseUtil {
	private String driver;
	private String url;
	private String user;
	private String password;
	private String sql = "";
	private Employee employee;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Connection connection;
	
	public DatabaseUtil(Employee employee){
		driver = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		user = "montran";
		password = "montran";
		sql = "";
		this.employee = employee;
	}
	
	public void closeConnection() throws SQLException {
		connection.close();
	}
	
	public void loadJDBCdriver() throws ClassNotFoundException {
		Class.forName(driver);
		System.out.println("Driver Loades SuccessFully");
	}
	
	public boolean connectToDatabase() throws SQLException {
		connection = DriverManager.getConnection(url, user, password);
		if (connection != null) {
			return true;
		}
		return false;
	}
	
	public boolean addNewEmployee(Employee employee) throws SQLException {
		sql = "insert into employee_master values(?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, employee.getEmployeeId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setDouble(3, employee.getSalary());
		int count = preparedStatement.executeUpdate();
		if(count>0)
			return true;
		return false;
	}
	
	public boolean addNewEmployees(Employee[] employee) throws SQLException {
		int count =0;
		for(int i=0; i<employee.length; i++) {
			sql = "insert into employee_master values(?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
	    	preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, employee[i].getName());
			preparedStatement.setDouble(3, employee[i].getSalary());
			preparedStatement.executeUpdate();
			count++;
		}
		if(count>0)
			return true;
		return false;
		
	}
	
	public boolean updateEmployee(int employeeid, String newName, double newSalary) throws SQLException {
		sql = "update employee_master set name=? , salary=? where employee_id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, newName);
		preparedStatement.setDouble(2, newSalary);
		preparedStatement.setInt(3, employeeid);
		int count = preparedStatement.executeUpdate();
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	public boolean Delete(int employeeid) throws SQLException {
		sql = "delete from employee_master where employee_id = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, employeeid);
		int count = preparedStatement.executeUpdate();
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	public void getAllEmployees() throws SQLException {
		sql = "select * from employee_master order by employee_id";
		preparedStatement = connection.prepareStatement(sql);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println("Employee Id :: " + resultSet.getInt("employee_id"));
			System.out.println("Name :: " + resultSet.getString("name"));
			System.out.println("Salary :: " + resultSet.getDouble("salary"));
			System.out.println("----------------------------------------");
		}
	}
	
	public void getSingleEmployee(int employeeid) throws SQLException {
		sql = "select * from employee_master where employee_id = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, employeeid);
		resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println("Employee Id :: " + resultSet.getInt("employee_id"));
			System.out.println("Name :: " + resultSet.getString("name"));
			System.out.println("Salary :: " + resultSet.getDouble("salary"));
			System.out.println("----------------------------------------");
		}
	}
	
}
