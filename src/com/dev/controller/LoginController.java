package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.LoginService;
import service.LoginServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "Used for Login Activity", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Read the request parameters
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println("userName " + userName);
		System.out.println("password " + password);
		// Create the model
		User user = new User(userName, password);

		// Invoke the Model
		LoginService service = new LoginServiceImpl();
		boolean res = service.isValid(user);
		//Render The response
		
		RequestDispatcher rd=null;
		
		if(res) {
			rd = request.getRequestDispatcher("home.jsp");
			request.setAttribute("user", user);
		}else {
			rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "User Name or Password Incorrect");
		}
		rd.forward(request, response);
		
	}

}
