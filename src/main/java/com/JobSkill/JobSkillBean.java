package com.JobSkill;

public class JobSkillBean {
	int id;
	String skill;
	
	public JobSkillBean(int id, String skill) {
		super();
		this.id = id;
		this.skill = skill;
	}

	public JobSkillBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
}
