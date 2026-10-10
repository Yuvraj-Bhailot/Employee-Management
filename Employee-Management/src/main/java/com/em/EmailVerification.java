package com.em;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/verifyEmail")
public class EmailVerification extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");

		Connection connection = CreateConnection.createConnection();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * from employee WHERE email=?");
			
			preparedStatement.setString(1, email);
			
			preparedStatement.execute();
			
			ResultSet resultSet = preparedStatement.getResultSet();
			
			if (resultSet.next()) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("takeNewPassword.html");
				requestDispatcher.forward(req, resp);
			} else {
				PrintWriter printWriter = resp.getWriter();
				printWriter.print("<h1>NO USER FOUND.</h1>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
