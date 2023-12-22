package com.JobEducation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBConnect.DBConnect;



public class JobEducationDao {
	Connection conn = DBConnect.getConnection();

	public String insertEducation(JobEducationBean jeb) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into job_education (major_name) values(?)");
			ps.setString(1, jeb.getMajor_name());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Added";
	}

	public List<JobEducationBean> listEducation() {
		List<JobEducationBean> jobeducation = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from job_education");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("j_id");
				String job_major_name = rs.getString("major_name");
				jobeducation.add(new JobEducationBean(id, job_major_name));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jobeducation;
	}

	public boolean deleteEducation(int id) throws SQLException {
		boolean rowDeleted = false;

		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement ps = connection.prepareStatement("Delete From job_education Where j_id=?");
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	public JobEducationBean selectEducation(int id) {
		JobEducationBean jeb = null;
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement("select major_name from job_education where j_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String job_education = rs.getString("major_name");
				jeb = new JobEducationBean(id, job_education);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return jeb;
	}

	public boolean UpdateEducation(JobEducationBean jeb) {
		boolean rowUpdataed = false;
		try {
			Connection connection = DBConnect.getConnection();
			int id = jeb.getId();
			PreparedStatement ps = connection.prepareStatement("Update job_education Set major_name=? where j_id=?");
			ps.setString(1, jeb.getMajor_name());
			ps.setInt(2, id);
			rowUpdataed = ps.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rowUpdataed;
	}
}
