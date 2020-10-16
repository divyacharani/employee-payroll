package com.bridgelabz.employeepayroll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollIOService {

	public static String path = "C:\\Users\\DELL\\eclipse-workspace\\EmployeePayroll\\src\\com\\bridgelabz\\employeepayroll\\employee-payroll-file.txt";

	// To write data to file
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

	// To print data
	public void printData() {
		try {
			Files.lines(Paths.get(path)).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// To count entries
	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(Paths.get(path)).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}

	// To read data from file
	public List<EmployeePayrollData> readData() {
		List<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
		try {
			Files.lines(Paths.get(path)).map(line -> line.trim()).forEach(line -> {
				String data = line.toString();
				String[] dataArray = data.split(",");
				int index = 0;
				while (index < dataArray.length) {
					int id = Integer.parseInt(dataArray[index].replace("id=", ""));
					index++;
					String name = dataArray[index].replace("name=", "");
					index++;
					double salary = Double.parseDouble(dataArray[index].replace("salary=", ""));
					employeePayrollList.add(new EmployeePayrollData(id, name, salary));
					System.out.println(employeePayrollList);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}
}
