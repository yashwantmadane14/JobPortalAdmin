package com.JobSkill;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UpdtJobSkill extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdtJobSkill() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String skill_name = request.getParameter("skill");
		
		JobSkillBean jsb  = new JobSkillBean(id,skill_name);
		
		
		
		JobSkillDao jsd = new JobSkillDao();
		boolean rowUpdated = jsd.UpdateSkill(jsb);
		if(rowUpdated==true) {
			response.sendRedirect("/JobPortal/Admin/AddJobSkill.jsp");
		}else {
			response.sendRedirect("/");

		}
	}

}
