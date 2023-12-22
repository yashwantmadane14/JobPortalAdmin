package com.JobRole;

import java.io.IOException;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/JobRoleServlet")
public class JobRoleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jobRole = request.getParameter("job_title");
        JobRoleBean jobrolebean = new JobRoleBean();
        jobrolebean.setJob_role(jobRole);
        
        
        JobRoleDao jobroledao = new JobRoleDao();
        
        String userValidation = jobroledao.insertRole(jobrolebean);
        
        if (userValidation.equals("Added")) {
            // Specify the correct destination, e.g., "/success.jsp"
//        	request.getRequestDispatcher("/JobPortal/Admin/list.jsp").forward(request, response);
        	response.sendRedirect("/JobPortal/Admin/AddJobTitle.jsp");


        } else {
            request.getRequestDispatcher("/indx.jsp").forward(request, response);
        }
    }
}
