package org.perscholas.simpleform.app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.perscholas.simpleform.models.User;
import org.perscholas.simpleform.services.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/login_form.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		System.out.println(email);
		String password=request.getParameter("password");
		System.out.println(password);
		UserService us=new UserService();
		
		User u2=us.findUserByEmail(email);
		System.out.println(u2.getFirstName());
		
		if (password.equals(u2.getPassword())) {
			System.out.println("Login succeeded.");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login_success.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("Invalid login");
			request.setAttribute("errorMessage", "Invalid Login");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login_form.jsp");
			rd.forward(request, response);
		}
	}

}
