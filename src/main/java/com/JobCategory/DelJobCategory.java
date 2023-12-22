package com.JobCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DelJobCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DelJobCategory() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	int id= Integer.parseInt(request.getParameter("id"));
	try {
		JobCategoryDao jcd = new JobCategoryDao();
		jcd.deleteCategory(id);
		response.sendRedirect("/JobPortal/Admin/AddJobCategory.jsp");
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

}
