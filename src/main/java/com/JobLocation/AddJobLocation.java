package com.JobLocation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddJobLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddJobLocation() {
        super();
        // TODO Auto-generated constructor stub
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jobLocation = request.getParameter("city_name");
		JobLocationBean jlb = new JobLocationBean();
		jlb.setJob_Location(jobLocation);
		
		
		JobLocationDao jld = new JobLocationDao();
		
		String Validate = jld.insertLocation(jlb);
		if(Validate.equals("Added")) {
			response.sendRedirect("/JobPortal/Admin/AddJobLocation.jsp");
		}
	}

}
