package com.JobEducation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UpdtJobEducation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdtJobEducation() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String major_name = request.getParameter("major_name");
		JobEducationBean jeb = new JobEducationBean(id, major_name);

		JobEducationDao jed = new JobEducationDao();

		boolean rowUpdated = jed.UpdateEducation(jeb);

		if (rowUpdated == true) {
			response.sendRedirect("/JobPortal/Admin/AddJobEducation.jsp");
		} else {
			response.sendRedirect("/JobPortal/Admin/index");

		}
	}

}
