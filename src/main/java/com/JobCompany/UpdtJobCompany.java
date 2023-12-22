package com.JobCompany;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



public class UpdtJobCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdtJobCompany() {
        super();
    
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String company_name = request.getParameter("company_name");
		JobCompanyBean jeb = new JobCompanyBean(id, company_name);

		JobCompanyDao jcd = new JobCompanyDao();

		boolean rowUpdated = jcd.UpdateCompany(jeb);

		if (rowUpdated == true) {
			response.sendRedirect("/JobPortal/Admin/AddJobCompany.jsp");
		} else {
			response.sendRedirect("/JobPortal/Admin/index");

		}
	}

}
