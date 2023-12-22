package com.JobLocation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DBConnect.DBConnect;

public class JobLocationDao {
	Connection conn = DBConnect.getConnection();

	public String insertLocation(JobLocationBean jlb) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into job_location (city_name) values(?)");
			ps.setString(1, jlb.getJob_Location());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Added";

	}

	public List<JobLocationBean> listLocation() {
		List<JobLocationBean> jobLocation = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from job_location");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("j_id");
				String job_location = rs.getString("city_name");
				jobLocation.add(new JobLocationBean(id, job_location));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return jobLocation;
	}

	public JobLocationBean selectLocation(int id) {
		JobLocationBean jlb = null;
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement("select city_name from job_location where j_id=?");
			ps.setInt(1, id);
						
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String job_location = rs.getString("city_name");
				jlb = new JobLocationBean(id,job_location);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jlb;

	}

	public boolean updateRow(JobLocationBean jlb) {
		boolean rowUpdated = false;
		try {
			Connection conn = DBConnect.getConnection();
			int id = jlb.getId();
			String city_name = jlb.getJob_Location();
			PreparedStatement ps = conn.prepareStatement("update job_location set city_name=? where j_id =?");
			ps.setString(1, city_name);
			ps.setInt(2, id);
			rowUpdated = ps.executeUpdate() > 0;
			}catch(Exception e) {
				e.printStackTrace();
			}
		return rowUpdated;
	}
	
	public boolean deleteLocation(int id) {
		boolean rowDeleted = false;
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement("Delete From job_location where j_id = ?");
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate()>0;
			
			

		}catch(Exception e) {
			e.printStackTrace();
		}
				return rowDeleted;
		
	}
	
}
