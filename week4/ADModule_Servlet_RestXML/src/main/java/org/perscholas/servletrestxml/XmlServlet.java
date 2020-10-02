package org.perscholas.servletrestxml;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/XmlServlet")
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		
		response.getWriter().append("<?xml version = \"1.0\"?>\n" + 
				"<Company>\n" + 
				"    <Employee category = \"Technical\">\n" + 
				"        <FirstName>Rick</FirstName>\n" + 
				"        <LastName>Sanchez</LastName>\n" + 
				"        <ContactNo>4262742553</ContactNo>\n" + 
				"        <Email>wubalubadubdub@pickle.com</Email>\n" + 
				"    </Employee>\n" + 
				"    <Employee category = \"Non-Technical\">\n" + 
				"        <FirstName>Morty</FirstName>\n" + 
				"        <LastName>Smith</LastName>\n" + 
				"        <ContactNo>1234667898</ContactNo>\n" + 
				"        <Email>OhJeez@pickle.com</Email>\n" + 
				"    </Employee>\n" + 
				"    <Employee category = \"Management\">\n" + 
				"        <FirstName>Summer</FirstName>\n" + 
				"        <LastName>Smith</LastName>\n" + 
				"        <ContactNo>1234562350</ContactNo>\n" + 
				"        <Email>whatever@pickle.com</Email>\n" + 
				"    </Employee>\n" + 
				"</Company>");
	}

}
