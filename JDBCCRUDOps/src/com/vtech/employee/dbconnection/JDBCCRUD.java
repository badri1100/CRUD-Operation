package com.vtech.employee.dbconnection;

import java.util.List;
import java.util.Scanner;

import com.vtech.employee.models.Employee;
import com.vtech.employee.service.EmployeeService;

public class JDBCCRUD {

	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n  Employee Management System ");
			System.out.println("1. Add Employee");
			System.out.println("2. View All Employees");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter ID: ");
				int id = sc.nextInt();
				System.out.print("Enter Name: ");
				String name = sc.next();
				System.out.print("Enter Department: ");
				String dept = sc.next();
				System.out.print("Enter Salary: ");
				double salary = sc.nextDouble();
				service.addEmployee(new Employee(id, name, dept, salary));
				break;

			case 2:
				List<Employee> employees = service.getEmployees();
				if (employees.isEmpty()) {
					System.out.println("No employees found.");
				} else {
					employees.forEach(System.out::println);
				}
				break;

			case 3:
				System.out.print("Enter ID of the employee to update: ");
				int uid = sc.nextInt();
				System.out.print("Enter New Name: ");
				String newName = sc.next();
				System.out.print("Enter New Department: ");
				String newDept = sc.next();
				System.out.print("Enter New Salary: ");
				double newSalary = sc.nextDouble();
				service.updateEmployee(new Employee(uid, newName, newDept, newSalary));
				break;

			case 4:
				System.out.print("Enter ID of the employee to delete: ");
				int delId = sc.nextInt();
				service.deleteEmployee(delId);
				break;

			case 5:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice. Try again.");
			}
		} while (choice != 5);

		sc.close();
	}
}