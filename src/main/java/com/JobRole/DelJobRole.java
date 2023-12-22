package com.JobRole;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DelJobRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobRoleDao jobroledao;

	public void init() throws ServletException {
		jobroledao = new JobRoleDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			jobroledao.deleteRole(id);
        	response.sendRedirect("/JobPortal/Admin/AddJobTitle.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
