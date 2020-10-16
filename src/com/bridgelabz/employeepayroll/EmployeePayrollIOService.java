package com.bridgelabz.employeepayroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollIOService {

	
	public static String path = "C:\\Users\\DELL\\eclipse-workspace\\EmployeePayroll\\src\\com\\bridgelabz\\employeepayroll\\employee-payroll-file.txt";

	//To write data to file
	public void writeData(List<EmployeePayrollData> employeePayrollList) {
		StringBuffer empBuffer = new StringBuffer();
		employeePayrollList.forEach(employee -> {
			String employeeDataString = employee.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(path), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//To print data 
	public void printData() {
		try {
			Files.lines(Paths.get(path)).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
