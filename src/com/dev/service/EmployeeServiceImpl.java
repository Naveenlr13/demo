package service;
import java.sql.SQLException;
import java.util.List;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	
	public void insertEmp(Employee employee) throws SQLException {
		EmployeeDao dao=new EmployeeDaoImpl();
		dao.insertNewEmployee(employee);
		System.out.println("Employee added");
	}

	public void updateEmp(int id, String city) throws SQLException {
		EmployeeDao dao=new EmployeeDaoImpl();
		dao.updateExistingEmployee(id, city);
		System.out.println("Employee table has been updated");
		getAllEmp();	
	}

	public void deleteEmp(int id) throws SQLException {
		EmployeeDao dao=new EmployeeDaoImpl();
		dao.deleteEmployeeById(id);
		System.out.println("Employee record deleted");

	}

	public List<Employee> getAllEmp() throws SQLException {
		EmployeeDao dao=new EmployeeDaoImpl();
		return dao.getAllEmployee();
	}

	public void getEmp(int id) throws SQLException {
		EmployeeDao dao=new EmployeeDaoImpl();
		System.out.println(dao.getEmployeeById(id));

	}
	
	
}

