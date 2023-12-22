package com.JobCategory;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddJobCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddJobCategory() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jobCategory = request.getParameter("job_category");
		JobCategoryBean jcb = new JobCategoryBean();
		jcb.setJob_Category(jobCategory);
		
		
		JobCategoryDao jcd = new JobCategoryDao();
		
		String Validate = jcd.insertCategory(jcb);
		if(Validate.equals("Added")) {
			response.sendRedirect("/JobPortal/Admin/AddJobCategory.jsp");
		}
	}

}
