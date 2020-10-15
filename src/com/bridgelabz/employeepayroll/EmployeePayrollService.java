package com.bridgelabz.employeepayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {

	private List<EmployeePayrollData> employeePayrollList;
	private Object writeEmployeePayrollData;

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
		employeePayrollService.writeEmployeePayrollData();

	}

	// To read employee data
	private void readEmployeePayrollData(Scanner consoleInputReader) {

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
	private void writeEmployeePayrollData() {
		System.out.println("Employee Payroll List: "+employeePayrollList);
	}

}
