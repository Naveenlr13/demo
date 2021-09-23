package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	private static final String INSERT_SQL="insert into Employee(id, firstName,lastName,city,country,salary)  values(?,?,?,?,?,?)";
	private static final String QUERY="select * from Employee ";

	
	public void insertNewEmployee(Employee employee) throws SQLException{
		Connection connection=DBUtil.getConnection();
		PreparedStatement ps=connection.prepareStatement(INSERT_SQL);
		ps.setInt(1, employee.getId());
		ps.setString(2, employee.getFirstName());
		ps.setString(3, employee.getLastName());
		ps.setString(4, employee.getCity());
		ps.setString(5, employee.getCountry());
		ps.setString(6, employee.getSalary());
		ps.executeUpdate();
	}

	public void updateExistingEmployee(int id, String city) throws SQLException{
		Connection connection=DBUtil.getConnection();
		PreparedStatement ps=connection.prepareStatement("update Employee set city = ? where id = ?");
		ps.setString(1,city);
		ps.setInt(2, id);
		ps.executeUpdate();

	}


	public void deleteEmployeeById(int id) throws SQLException{
		Connection connection=DBUtil.getConnection();
		PreparedStatement ps=connection.prepareStatement("delete from Employee where id =?");
		ps.setInt(1, id);
		ps.executeUpdate();
	}


	public List<Employee> getAllEmployee()throws SQLException {
		Connection connection=DBUtil.getConnection();
		PreparedStatement ps=connection.prepareStatement(QUERY);
		ResultSet rs = ps.executeQuery(QUERY);
		List<Employee> emp=new ArrayList<Employee>();
		while(rs.next()) {
			Employee empl = new Employee();
			empl.setId(rs.getInt("id"));
			empl.setFirstName(rs.getString("firstName"));
			empl.setLastName(rs.getString("lastName"));
			empl.setCity(rs.getString("city"));
			empl.setCountry(rs.getString("country"));
			empl.setSalary(rs.getString("salary"));
			emp.add(empl);
		}
		return emp;
	}


	public Employee getEmployeeById(int id)throws SQLException {
		
		Connection connection=DBUtil.getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from Employee where id= ?");
		ps.setInt(1, id);
		ResultSet rset = ps.executeQuery();
		Employee emp1 = null;
		if(rset.next()){
		emp1=new Employee();
		emp1.setId(rset.getInt("id"));
		emp1.setFirstName(rset.getString("firstName"));
		emp1.setLastName(rset.getString("lastName"));
		emp1.setCity(rset.getString("city"));
		emp1.setCountry(rset.getString("country"));
		emp1.setSalary(rset.getString("salary"));
		}
		return emp1;
	}

}