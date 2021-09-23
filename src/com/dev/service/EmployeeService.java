package service;
import java.sql.SQLException;
import java.util.List;

import model.Employee;


public interface EmployeeService {
	public void insertEmp(Employee employee) throws SQLException;
	public void updateEmp(int id , String city) throws SQLException;
	public void deleteEmp(int id) throws SQLException;
	public List<Employee>getAllEmp() throws SQLException;
	public void getEmp(int id) throws SQLException;
	
}
