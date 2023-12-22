package com.JobCompany;

public class JobCompanyBean {
	int id;
	String Comapany_name;

	public JobCompanyBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobCompanyBean(int id, String comapany_name) {
		super();
		this.id = id;
		Comapany_name = comapany_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComapany_name() {
		return Comapany_name;
	}

	public void setComapany_name(String comapany_name) {
		Comapany_name = comapany_name;
	}

}
