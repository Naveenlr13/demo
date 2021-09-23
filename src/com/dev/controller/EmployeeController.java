package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet(urlPatterns = { "/EmployeeController"})
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService service = new EmployeeServiceImpl();

    /**
     * Default constructor. 
     */
    public EmployeeController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		String salary=request.getParameter("salary");
		
		EmployeeService empser = new EmployeeServiceImpl();
		Employee emp=new Employee();
		emp.setId(id);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setCity(city);
		emp.setCountry(country);
		emp.setSalary(salary);
		try {
		empser.insertEmp(emp);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("Action: " + action);
		if (action.equals("displayAll")) {
			displayAllEmployees(request, response);
		} else if (action.equals("addEmployee")) {
			addEmployee(request, response);
			System.out.println("inaddemp");
		} else {

		}
	}
	private void addEmployee(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("add_emp.jsp");
		rd.forward(request, response);
	
	}

	private void displayAllEmployees(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		try {
			List<Employee> employees = service.getAllEmp();
			// System.out.println("Employees: " + employees);
			// Render The response and data to the employees.jsp page
			rd = request.getRequestDispatcher("display_emp.jsp");
			request.setAttribute("employees", employees);
			rd.forward(request, response);
		} catch (SQLException e) {
			// Log
			e.printStackTrace();
		}

	}

}
