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
import javax.servlet.http.HttpSession;

@WebServlet("/updateDeveloper")
public class UpdateDeveloper extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String option = (String) session.getAttribute("option");

		int id = Integer.parseInt(req.getParameter("id"));

		Connection connection = CreateConnection.createConnection();
		PrintWriter printWriter = resp.getWriter();

		try {
			if (option.equals("updateName")) {
				PreparedStatement updateNamePreparedStatement = connection
						.prepareStatement("UPDATE employee SET employee_name=? WHERE employee_id=?");
				updateNamePreparedStatement.setString(1, req.getParameter("name"));
				updateNamePreparedStatement.setInt(2, id);

				int rows = updateNamePreparedStatement.executeUpdate();

				if (rows > 0) {
					printWriter.print("<h1>EMPLOYEE NAME UPDATED SUCCESSFULLY.</h1>");
				}
			} else if (option.equals("updateEmail")) {
				PreparedStatement updateEmailPreparedStatement = connection
						.prepareStatement("UPDATE employee SET email=? WHERE employee_id=?");
				updateEmailPreparedStatement.setString(1, req.getParameter("email"));
				updateEmailPreparedStatement.setInt(2, id);

				int rows = updateEmailPreparedStatement.executeUpdate();

				if (rows > 0) {
					printWriter.print("<h1>EMPLOYEE EMAIL UPDATED SUCCESSFULLY.</h1>");
				}
			} else if (option.equals("updatePhone")) {
				PreparedStatement updatePhonePreparedStatement = connection
						.prepareStatement("UPDATE employee SET phone_number=? WHERE employee_id=?");
				updatePhonePreparedStatement.setLong(1,Long.parseLong(req.getParameter("phone")));
				updatePhonePreparedStatement.setInt(2, id);

				int rows = updatePhonePreparedStatement.executeUpdate();

				if (rows > 0) {
					printWriter.print("<h1>EMPLOYEE PHONE NUMBER UPDATED SUCCESSFULLY.</h1>");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
