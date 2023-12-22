package com.JobSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.DBConnect.DBConnect;


public class JobSkillDao {

	public JobSkillDao() {
		// TODO Auto-generated constructor stub
	}
	
	Connection conn = DBConnect.getConnection();

	
	public String insertSkill(JobSkillBean jsb) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into job_skills (skill) values(?)");
			ps.setString(1, jsb.getSkill());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Added";
	}

	
	public List<JobSkillBean> listSkills() {
		List<JobSkillBean> jobskill = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from job_skills");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("j_id");
				String job_skill_name = rs.getString("skill");
				jobskill.add(new JobSkillBean(id, job_skill_name));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jobskill;
	}

	
	public boolean deleteskill(int id) throws SQLException {
		boolean rowDeleted = false;

		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement ps = connection.prepareStatement("Delete From job_skills Where j_id=?");
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	
	public JobSkillBean selectSkill(int id) {
		JobSkillBean jsb = null;
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement("select skill from job_skills where j_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String job_skill = rs.getString("skill");
				jsb = new JobSkillBean(id, job_skill);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return jsb;
	}

	
	public boolean UpdateSkill(JobSkillBean jsb) {
		boolean rowUpdataed = false;
		try {
			Connection connection = DBConnect.getConnection();
			int id = jsb.getId();
			PreparedStatement ps = connection.prepareStatement("Update job_skills Set skill=? where j_id=?");
			ps.setString(1, jsb.getSkill());
			ps.setInt(2, id);
			rowUpdataed = ps.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rowUpdataed;
	}
}
