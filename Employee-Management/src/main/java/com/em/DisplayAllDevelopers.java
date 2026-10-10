package com.em;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewDeveloper")
public class DisplayAllDevelopers extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = CreateConnection.createConnection();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employee WHERE role='developer'");
			req.setAttribute("developerList", resultSet);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("displayDeveloper.jsp");
			requestDispatcher.include(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
