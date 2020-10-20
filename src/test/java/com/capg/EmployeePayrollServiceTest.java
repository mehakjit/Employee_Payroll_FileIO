package com.capg;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.capg.EmloyeePayrollService.IOService;

public class EmployeePayrollServiceTest {
	@Test
	public void given3employeewhenWrittenShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfemp = {
				new EmployeePayrollData(1, "Jeff Bezos", 10000.0),
				new EmployeePayrollData(2, "Bill Gates", 20000.0),
				new EmployeePayrollData(3, "Mark Zukerberg", 10000.0),
		};
		EmloyeePayrollService employeePayrollService;
		employeePayrollService = new EmloyeePayrollService(Arrays.asList(arrayOfemp));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		employeePayrollService.printData(IOService.FILE_IO);
		Assert.assertEquals(3, employeePayrollService.countEntries(IOService.FILE_IO));
	}
}
