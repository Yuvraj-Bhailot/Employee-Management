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

@WebServlet("/loginEmployee")
public class LoginEmployee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Connection connection = CreateConnection.createConnection();

		try {
			PreparedStatement loginPreparedStatement = connection
					.prepareStatement("SELECT * FROM employee WHERE email=? AND password=?");

			loginPreparedStatement.setString(1, email);
			loginPreparedStatement.setString(2, password);

			loginPreparedStatement.execute();
			ResultSet loginResultSet = loginPreparedStatement.getResultSet();

			PrintWriter printWriter = resp.getWriter();
			if (loginResultSet.next()) {
				printWriter.print("<h1>LOGIN SUCCESSFUL.</h1>");
				String role = loginResultSet.getString("role");
				if (role.equals("manager")) {
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("manager.html");
					requestDispatcher.include(req, resp);
				} else if (role.equals("developer")) {
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("developer.html");
					requestDispatcher.include(req, resp);
				}
			} else {
				printWriter.print("<h1>LOGIN FAILED.</h1>");
				printWriter.print("<h1>ENTER PROPER DETAILS.</h1>");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("loginEmployee.html");
				requestDispatcher.include(req, resp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
