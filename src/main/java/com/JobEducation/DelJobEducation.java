package com.JobEducation;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelJobEducation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelJobEducation() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		try {
			JobEducationDao jed = new JobEducationDao();
			jed.deleteEducation(id);
			response.sendRedirect("/JobPortal/Admin/AddJobEducation.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


}
