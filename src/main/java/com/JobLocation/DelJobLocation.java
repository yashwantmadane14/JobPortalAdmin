package com.JobLocation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelJobLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelJobLocation() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		try {
			JobLocationDao jld = new JobLocationDao();
			jld.deleteLocation(id);
			response.sendRedirect("/JobPortal/Admin/AddJobLocation.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
