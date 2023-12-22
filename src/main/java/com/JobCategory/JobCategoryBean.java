package com.JobCategory;

public class JobCategoryBean {
	private int id;
	private String Job_Category;

	public JobCategoryBean(int id, String job_Category) {
		super();
		this.id = id;
		Job_Category = job_Category;
	}

	public JobCategoryBean(String job_category) {
		super();
		// TODO Auto-generated constructor stub
		this.Job_Category = job_category;
	}

	public int getId() {
		return id;
	}
	
	public JobCategoryBean() {}

	public void setId(int id) {
		this.id = id;
	}

	public String getJob_Category() {
		return Job_Category;
	}

	public void setJob_Category(String job_Category) {
		Job_Category = job_Category;
	}

}
