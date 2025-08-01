package com.vtech.employee.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vtech.employee.dbconnection.DBConnection;
import com.vtech.employee.models.Employee;

public class EmployeeService {

	public void addEmployee(Employee employee) {
		String sql = "INSERT INTO employee(id, name, department, salary) VALUES (?, ?, ?, ?)";

		try (Connection conn = DBConnection.getConnnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, employee.getId());
			stmt.setString(2, employee.getName());
			stmt.setString(3, employee.getDepartment());
			stmt.setDouble(4, employee.getSalary());

			stmt.executeUpdate();
			System.out.println("Employee added successfully with id: " + employee.getId());

		} catch (SQLException e) {
			System.out.println("Database error while adding employee - " + e.getMessage());
		}
	}

	public List<Employee> getEmployees() {
		String sql = "SELECT * FROM employee";
		List<Employee> list = new ArrayList<>();

		try (Connection conn = DBConnection.getConnnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet result = stmt.executeQuery()) {

			while (result.next()) {
				list.add(new Employee(result.getInt("id"), result.getString("name"),
						result.getString("department"), result.getDouble("salary")));
			}

		} catch (SQLException e) {
			System.err.println("Database error while reading employees - " + e.getMessage());
		}
		return list;
	}

	public void updateEmployee(Employee employee) {
		String sql = "UPDATE employee SET name = ?, department = ?, salary = ? WHERE id = ?";
		try (Connection conn = DBConnection.getConnnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getDepartment());
			stmt.setDouble(3, employee.getSalary());
			stmt.setInt(4, employee.getId());

			int rowsUpdated = stmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Employee updated successfully.");
			} else {
				System.out.println("No employee found with ID: " + employee.getId());
			}

		} catch (SQLException e) {
			System.out.println("Error updating employee - " + e.getMessage());
		}
	}

	public void deleteEmployee(int id) {
		String sql = "DELETE FROM employee WHERE id = ?";
		try (Connection conn = DBConnection.getConnnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, id);
			int rowsDeleted = stmt.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Employee deleted successfully.");
			} else {
				System.out.println("No employee found with ID: " + id);
			}

		} catch (SQLException e) {
			System.out.println("Error deleting employee - " + e.getMessage());
		}
	}
}

