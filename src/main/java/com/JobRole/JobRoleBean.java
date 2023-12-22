package com.JobRole;

public class JobRoleBean {
	private int id;
	private String job_role;

	public JobRoleBean(String job_role) {
		super();

		this.job_role = job_role;
	}

	public JobRoleBean(int id, String job_role) {
		super();
		this.id = id;
		this.job_role = job_role;
	}

	public JobRoleBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJob_role() {
		return job_role;
	}

	public void setJob_role(String job_role) {
		this.job_role = job_role;
	}
}
