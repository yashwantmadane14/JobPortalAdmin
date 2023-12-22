package com.JobCompany;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DelJobCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelJobCompany() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		try {
			JobCompanyDao jed = new JobCompanyDao();
			jed.deleteCompany(id);
			response.sendRedirect("/JobPortal/Admin/AddJobCompany.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
