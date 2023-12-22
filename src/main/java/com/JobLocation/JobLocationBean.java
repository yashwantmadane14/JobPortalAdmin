package com.JobLocation;

public class JobLocationBean {
	int id;
	String Job_Location;
	public JobLocationBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JobLocationBean(int id, String job_Location) {
		super();
		this.id = id;
		Job_Location = job_Location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJob_Location() {
		return Job_Location;
	}
	public void setJob_Location(String job_Location) {
		Job_Location = job_Location;
	}
	
}
