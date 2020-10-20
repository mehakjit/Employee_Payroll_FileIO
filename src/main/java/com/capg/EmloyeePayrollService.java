package com.capg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmloyeePayrollService {
	public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}
	
	private List<EmployeePayrollData> employeePayrollList;

	public EmloyeePayrollService() {
	}

	public EmloyeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	private void readEmployeePayrollData(Scanner scaanerinputsfromconsole) {
		System.out.print("Enter Employee ID: ");
		int id = scaanerinputsfromconsole.nextInt();
		System.out.print("Enter Employee Name: ");
		String name = scaanerinputsfromconsole.next();
		System.out.print("Enter Employee Salary: ");
		double salary = scaanerinputsfromconsole.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}

	public void writeEmployeePayrollData(com.capg.EmloyeePayrollService.IOService ioService) {
		if (ioService.equals(com.capg.EmloyeePayrollService.IOService.CONSOLE_IO))
			System.out.println("\nWriting Employee Payroll Roaster to Console\n" + employeePayrollList);
		else if(ioService.equals(com.capg.EmloyeePayrollService.IOService.FILE_IO))
			new EmployeePayrollFileIOService().writeData(employeePayrollList);
	}

	public long countEntries(IOService ioService) {
		if (ioService.equals(IOService.FILE_IO))
			return new EmployeePayrollFileIOService().countEntries();
		return 0;
	}

	public void printData(IOService ioService) {
		if(ioService.equals(IOService.FILE_IO))
			new EmployeePayrollFileIOService().printData();
	}

	public long readEmployeePayRollData(IOService fileIo) throws FileNotFoundException {
		long count = 0;
		if(fileIo.equals(IOService.FILE_IO)) {
		//	new EmployeePayrollFileIOService()
			  File file = new File("payroll-file.txt"); 
		    Scanner sc = new Scanner(file); 
		    while (sc.hasNextLine()) {
		      System.out.println(sc.nextLine());
		      count++;
		    }
		}
		return count;
	}
}

