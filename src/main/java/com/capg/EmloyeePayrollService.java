package com.capg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmloyeePayrollService {
	
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

	private void writeEmployeePayrollData(Scanner consoleInputReader) {
		System.out.println("\nWriting Employee Payroll Data to Console\n" + employeePayrollList);
	}

	public static void main(String[] args) {
		List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmloyeePayrollService employeePayrollService = new EmloyeePayrollService(employeePayrollList);
		Scanner readFromConsoleUsingScanner = new Scanner(System.in);
		employeePayrollService.readEmployeePayrollData(readFromConsoleUsingScanner);
		employeePayrollService.writeEmployeePayrollData(readFromConsoleUsingScanner);
	}
}

