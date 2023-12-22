package com.JobRole;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UpdtJobRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		String role_name = request.getParameter("role_name");
		
		JobRoleBean jobrolebean  = new JobRoleBean(id,role_name);
		
		
		
		JobRoleDao jobroledao = new JobRoleDao();
		boolean rowUpdated = jobroledao.UpdateRole(jobrolebean);
		if(rowUpdated==true) {
			response.sendRedirect("/JobPortal/Admin/AddJobTitle.jsp");
		}else {
			response.sendRedirect("/");

		}
		
	}

}
