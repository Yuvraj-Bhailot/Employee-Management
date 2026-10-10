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

@WebServlet("/delete")
public class DeleteDeveloper extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		Connection connection = CreateConnection.createConnection();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM employee WHERE employee_id=?");
			
			preparedStatement.setInt(1, id);
			
			int rows = preparedStatement.executeUpdate();
			
			PrintWriter printWriter = resp.getWriter();
			if (rows>0) {
				printWriter.print("<h1>DEVELOPER REMOVED SUCCESSFULLY.</h1>");
			} else {
				printWriter.print("<h1>NO DEVELOPER FOUND WITH THIS ID.</h1>");				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
