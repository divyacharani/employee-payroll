package com.bridgelabz.employeepayroll;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.bridgelabz.employeepayroll.EmployeePayrollService.IO_SERVICE;

public class EmployeePayrollTest {

	@Test
	public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEnteries() {

		EmployeePayrollData[] arrayOfEmps = { new EmployeePayrollData(1, "abc", 1000.0),
				new EmployeePayrollData(2, "def", 2000.0), new EmployeePayrollData(3, "xyz", 3000.0) };
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(IO_SERVICE.FILE_IO);

	}

}
