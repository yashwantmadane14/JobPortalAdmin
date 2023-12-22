package com.JobLocation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



public class UpdtJobLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdtJobLocation() {
        super();
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String city_name  = request.getParameter("city_name");
		JobLocationBean jlb = new JobLocationBean(id,city_name);
		
		JobLocationDao jld = new JobLocationDao();
		
		boolean rowUpdated = jld.updateRow(jlb);
		
		if(rowUpdated==true) {
			response.sendRedirect("/JobPortal/Admin/AddJobLocation.jsp");
		}
		else {
			response.sendRedirect("/JobPortal/Admin/index");

		}
		
	}

}
