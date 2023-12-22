package com.JobCompany;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddJobCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddJobCompany() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jobCompany = request.getParameter("company_name");
		JobCompanyBean jeb = new JobCompanyBean();
		jeb.setComapany_name(jobCompany);

		JobCompanyDao jed = new JobCompanyDao();

		String Validate = jed.insertComapny(jeb);
		if (Validate.equals("Added")) {
			response.sendRedirect("/JobPortal/Admin/AddJobCompany.jsp");

		}
	}

}
