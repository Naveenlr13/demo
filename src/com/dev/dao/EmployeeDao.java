package dao;


import java.sql.SQLException;
import java.util.List;

import model.Employee;

public interface EmployeeDao {

	public void insertNewEmployee(Employee employee) throws SQLException;
	public void updateExistingEmployee(int id , String city) throws SQLException;
	public void deleteEmployeeById(int id) throws SQLException;
	public List<Employee> getAllEmployee() throws SQLException;
	public Employee getEmployeeById(int id) throws SQLException;
}

