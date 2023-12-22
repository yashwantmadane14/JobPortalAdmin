package com.JobEducation;

public class JobEducationBean {
	int id;
	String major_name;

	public JobEducationBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobEducationBean(int id, String major_name) {
		super();
		this.id = id;
		this.major_name = major_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMajor_name() {
		return major_name;
	}

	public void setMajor_name(String major_name) {
		this.major_name = major_name;
	}

}
