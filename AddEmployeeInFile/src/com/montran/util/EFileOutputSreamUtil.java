package com.montran.util;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.File;
import java.io.FileNotFoundException;

public class EFileOutputSreamUtil {
	private OutputStream outputstream;
	
	public void writeDataToFile(File file,  byte [] employeeId, byte[] employeeName, byte[] employeeSalary ) {
		
		try {
			outputstream = new FileOutputStream(file);
			outputstream.write(employeeId);
			outputstream.write(employeeName);
			outputstream.write(employeeSalary);
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.getMessage();
		} catch(IOException E) {
			System.out.println("IOException found");
			E.getMessage();
		}
		finally {
			try {
				outputstream.close();
			} catch (IOException e) {
				System.out.println("IOException");
				e.getMessage();
			}
		}
	}
}
