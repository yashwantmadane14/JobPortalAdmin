package com.JobCompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBConnect.DBConnect;

public class JobCompanyDao {
	Connection conn = DBConnect.getConnection();

	public String insertComapny(JobCompanyBean jcb) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into job_companies (company_name) values(?)");
			ps.setString(1, jcb.getComapany_name());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Added";
	}

	public List<JobCompanyBean> listCompany() {
		List<JobCompanyBean> jobcompany = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from job_companies");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("j_id");
				String job_company_name = rs.getString("company_name");
				jobcompany.add(new JobCompanyBean(id, job_company_name));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jobcompany;
	}

	public boolean deleteCompany(int id) throws SQLException {
		boolean rowDeleted = false;

		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement ps = connection.prepareStatement("Delete From job_companies Where j_id=?");
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	public JobCompanyBean selectCompany(int id) {
		JobCompanyBean jcb = null;
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement("select company_name from job_companies where j_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String job_company = rs.getString("company_name");
				jcb = new JobCompanyBean(id, job_company);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return jcb;
	}

	public boolean UpdateCompany(JobCompanyBean jcb) {
		boolean rowUpdataed = false;
		try {
			Connection connection = DBConnect.getConnection();
			int id = jcb.getId();
			PreparedStatement ps = connection.prepareStatement("Update job_companies Set company_name=? where j_id=?");
			ps.setString(1, jcb.getComapany_name());
			ps.setInt(2, id);
			rowUpdataed = ps.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rowUpdataed;
	}
}
