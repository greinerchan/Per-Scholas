package org.perscholas.servletrestxml;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String json = "[{\"FirstName\" : \"Rick\", "
				+ "\"LastName\" : \"Sanchez\", "
				+ "\"Email\" : \"wubalubadubdub@pickle.com\", "
				+ "\"Contact\" : \"4262742553\"}, "
				
				+ "{\"FirstName\" : \"Morty\", "
				+ "\"LastName\" : \"Smith\", "
				+ "\"Email\" : \"OhJeez@pickle.com\", "
				+ "\"Contact\" : \"1234667898\"}, "
				
				+ "{\"FirstName\" : \"Summer\", "
				+ "\"LastName\" : \"Smith\", "
				+ "\"Email\" : \"whatever@pickle.com\", "
				+ "\"Contact\" : \"1234562350\"}]";
		response.getWriter().write(json);
	}
}
