package com.JobSkill;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddJobSkill extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddJobSkill() {
        super();
    }

	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jobSkill = request.getParameter("job_skill");
        JobSkillBean jsb = new JobSkillBean();
        jsb.setSkill(jobSkill);
        
        
        JobSkillDao jsd = new JobSkillDao();
        
        String userValidation = jsd.insertSkill(jsb);
        
        if (userValidation.equals("Added")) {
            // Specify the correct destination, e.g., "/success.jsp"
//        	request.getRequestDispatcher("/JobPortal/Admin/list.jsp").forward(request, response);
        	response.sendRedirect("/JobPortal/Admin/AddJobSkill.jsp");


        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
	}

}
