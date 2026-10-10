package com.em;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addDeveloper")
public class AddDeveloper extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phoneNumber = Long.parseLong(req.getParameter("phoneNumber"));
		double salary = Double.parseDouble(req.getParameter("salary"));

		Connection connection = CreateConnection.createConnection();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?,?,?)");
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			preparedStatement.setLong(5, phoneNumber);
			preparedStatement.setDouble(6, salary);
			preparedStatement.setString(7, "developer");
			
			int rows = preparedStatement.executeUpdate();
			
			if (rows>0) {
				PrintWriter printWriter = resp.getWriter();
				printWriter.print("<h1>DEVELOPER ADDED SUCCESSFULLY.</h1>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
