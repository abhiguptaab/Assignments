package com.montran.main;
import java.util.Scanner;
import java.io.File;
import com.montran.util.EFileInputStreamUtil;
import com.montran.util.EFileOutputSreamUtil;

public class EInputOutputMain {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		EFileOutputSreamUtil util = new EFileOutputSreamUtil();
		File file;
		String filePath;
		String employeeName;
		String employeeId;
		String employeeSalary;
		
		System.out.println("Enter Path of File..");
		filePath = sc.nextLine();
		file = new File(filePath);
		
		System.out.println("Enter Name Of Employee ID");
		employeeId = sc.nextLine();
		System.out.println("Enter Name Of Employee Name");
		employeeName = sc.nextLine();
		System.out.println("Enter Name Of Employee Salary");
		employeeSalary = sc.nextLine();
		util.writeDataToFile(file, employeeId.getBytes(), employeeName.getBytes(), employeeSalary.getBytes());
		System.out.println("Check your life");
		
		EFileInputStreamUtil util1 = new EFileInputStreamUtil();
		System.out.println("Enter File Path");
		filePath = sc.nextLine();
		file = new File(filePath);
		
		byte [] fileData;
		fileData = util1.readFileData(file);
		for (byte b : fileData) {
			System.out.print((char) b);
		}
		sc.close();
		
	}
}
