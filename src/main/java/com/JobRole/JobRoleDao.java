package com.JobRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBConnect.DBConnect;

public class JobRoleDao {

	public JobRoleDao() {
	}

	Connection conn = DBConnect.getConnection();

	
	public String insertRole(JobRoleBean jobrolebean) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into job_roles (role_name) values(?)");
			ps.setString(1, jobrolebean.getJob_role());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Added";
	}

	
	public List<JobRoleBean> listRoles() {
		List<JobRoleBean> jobrole = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from job_roles");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("j_id");
				String job_role_name = rs.getString("role_name");
				jobrole.add(new JobRoleBean(id, job_role_name));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jobrole;
	}

	
	public boolean deleteRole(int id) throws SQLException {
		boolean rowDeleted = false;

		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement ps = connection.prepareStatement("Delete From job_roles Where j_id=?");
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	
	public JobRoleBean selectRole(int id) {
		JobRoleBean jobrolebean = null;
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement("select role_name from job_roles where j_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String job_role = rs.getString("role_name");
				jobrolebean = new JobRoleBean(id, job_role);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return jobrolebean;
	}

	
	public boolean UpdateRole(JobRoleBean jobrolebean) {
		boolean rowUpdataed = false;
		try {
			Connection connection = DBConnect.getConnection();
			int id = jobrolebean.getId();
			PreparedStatement ps = connection.prepareStatement("Update job_roles Set role_name=? where j_id=?");
			ps.setString(1, jobrolebean.getJob_role());
			ps.setInt(2, id);
			rowUpdataed = ps.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rowUpdataed;
	}

}
