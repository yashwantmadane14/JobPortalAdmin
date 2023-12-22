package com.JobEducation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddJobEducation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddJobEducation() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jobEducation = request.getParameter("major_name");
		JobEducationBean jeb = new JobEducationBean();
		jeb.setMajor_name(jobEducation);

		JobEducationDao jed = new JobEducationDao();

		String Validate = jed.insertEducation(jeb);
		if (Validate.equals("Added")) {
			response.sendRedirect("/JobPortal/Admin/AddJobEducation.jsp");
		}
	}

}
