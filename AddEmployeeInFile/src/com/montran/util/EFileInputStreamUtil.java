package com.montran.util;
import java.io.InputStream; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

public class EFileInputStreamUtil {
	private InputStream inputstream;

	int fileLength;
	public byte[] data;
	
	public byte[] readFileData(File file) {
		fileLength =(int) file.length();
		data = new byte[fileLength];
		
		try {
			inputstream = new FileInputStream(file);
			inputstream.read(data);
		} catch (FileNotFoundException e) {
			System.out.println("Eile Not Found");
			e.getMessage();
		} catch (IOException e) {
			System.out.println("IoException");
			e.getMessage();
		}
		finally {
			try {
				inputstream.close();
			} catch (IOException e) {
				System.out.println("IOException");
				e.getMessage();
			}
		}
		return data;
	}
	
}
