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

@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");

		Connection connection = CreateConnection.createConnection();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE employee SET password=? WHERE employee_id=?");

			preparedStatement.setString(1, password);
			preparedStatement.setInt(2, id);
			
			int rows = preparedStatement.executeUpdate();
			
			if (rows>0) {
				PrintWriter printWriter = resp.getWriter();
				printWriter.print("<h1>PASSWORD CHANGED SUCCESSFULLY.</h1>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
