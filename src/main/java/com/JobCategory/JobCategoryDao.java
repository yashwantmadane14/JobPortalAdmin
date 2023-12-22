package com.JobCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DBConnect.DBConnect;

public class JobCategoryDao {

	Connection conn = DBConnect.getConnection();

	public String insertCategory(JobCategoryBean jobcategorybean) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into job_category (category_name) values(?)");
			ps.setString(1, jobcategorybean.getJob_Category());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Added";

	}

	public List<JobCategoryBean> listCategory() {
		List<JobCategoryBean> jobcategory = new ArrayList<>();

		try {
			PreparedStatement ps = conn.prepareStatement("select * from job_category");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("j_id");
				String job_category = rs.getString("category_name");
				jobcategory.add(new JobCategoryBean(id, job_category));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return jobcategory;
	}

	public JobCategoryBean selectCategory(int id) {
		JobCategoryBean jobcategorybean = null;
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement("select category_name from job_category where j_id=?");
			ps.setInt(1, id);
						
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String job_category = rs.getString("category_name");
				jobcategorybean = new JobCategoryBean(id,job_category);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jobcategorybean;

	}

	public boolean updateRow(JobCategoryBean jcb) {
		boolean rowUpdated = false;
		try {
			Connection conn = DBConnect.getConnection();
			int id = jcb.getId();
			String category_name = jcb.getJob_Category();
			PreparedStatement ps = conn.prepareStatement("update job_category set category_name=? where j_id =?");
			ps.setString(1, category_name);
			ps.setInt(2, id);
			rowUpdated = ps.executeUpdate() > 0;
			}catch(Exception e) {
				e.printStackTrace();
			}
		return rowUpdated;
	}
	
	public boolean deleteCategory(int id) {
		boolean rowDeleted = false;
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement("Delete From job_category where j_id = ?");
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate()>0;
			
			

		}catch(Exception e) {
			e.printStackTrace();
		}
				return rowDeleted;
		
	}
	
}
