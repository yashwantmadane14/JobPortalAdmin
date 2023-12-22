package com.JobSkill;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DelJobSkill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
    public DelJobSkill() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			JobSkillDao jsd = new JobSkillDao();
			jsd.deleteskill(id);
        	response.sendRedirect("/JobPortal/Admin/AddJobSkill.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	

}
