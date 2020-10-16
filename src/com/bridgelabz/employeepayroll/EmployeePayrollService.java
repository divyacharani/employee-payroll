package com.bridgelabz.employeepayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

	private List<EmployeePayrollData> employeePayrollList;

	public enum IO_SERVICE {
		CONSOLE_IO, FILE_IO
	};

	// Constructor
	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		super();
		this.employeePayrollList = employeePayrollList;
	}

	public static void main(String[] args) {

		// Welcome Message
		System.out.println("Welcome to Employee Payroll Program!!");
		Scanner consoleInputReader = new Scanner(System.in);

		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);

		employeePayrollService.readEmployeePayrollData(consoleInputReader);
		employeePayrollService.writeEmployeePayrollData(IO_SERVICE.FILE_IO);

	}

	// To read employee data
	public void readEmployeePayrollData(Scanner consoleInputReader) {

		System.out.println("Enter Employee ID ");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter Employee Name ");
		consoleInputReader.nextLine();
		String name = consoleInputReader.nextLine();
		System.out.println("Enter Employee Salary ");
		double salary = consoleInputReader.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	// To write employee data
	public void writeEmployeePayrollData(IO_SERVICE ioService) {
		if (ioService.equals(IO_SERVICE.CONSOLE_IO))
			System.out.println("Employee Payroll List: " + employeePayrollList);
		else if (ioService.equals(IO_SERVICE.FILE_IO))
			new EmployeePayrollIOService().writeData(employeePayrollList);
	}

	// To print employee data
	public void printData(IO_SERVICE ioService) {
		if (ioService.equals(IO_SERVICE.FILE_IO)) {
			new EmployeePayrollIOService().printData();
		}
	}

	// To count entries
	public long countEntries(IO_SERVICE ioService) {
		if (ioService.equals(IO_SERVICE.FILE_IO)) {
			return new EmployeePayrollIOService().countEntries();
		}
		return 0;
	}
}
