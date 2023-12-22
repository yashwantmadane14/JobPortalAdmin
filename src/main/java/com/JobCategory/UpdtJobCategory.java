package com.JobCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdtJobCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdtJobCategory() {
        super();
    
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String category_name  = request.getParameter("category_name");
		JobCategoryBean jcb = new JobCategoryBean(id,category_name);
		
		JobCategoryDao jcd = new JobCategoryDao();
		
		boolean rowUpdated = jcd.updateRow(jcb);
		
		if(rowUpdated==true) {
			response.sendRedirect("/JobPortal/Admin/AddJobCategory.jsp");
		}
		else {
			response.sendRedirect("/JobPortal/Admin/index");

		}
	
	}

}
