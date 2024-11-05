package com.project.nouapp.dto;

import org.springframework.web.multipart.MultipartFile;

public class MaterialDto {
	private String program;	
	private String branch;	
	private String year;	
	private String subject;	
	private String topic;
	private String materialtype;	
	private MultipartFile matfile;
	private String posteddate;
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMaterialtype() {
		return materialtype;
	}
	public void setMaterialtype(String materialtype) {
		this.materialtype = materialtype;
	}
	public MultipartFile getMatfile() {
		return matfile;
	}
	public void setMatfile(MultipartFile matfile) {
		this.matfile = matfile;
	}
	public String getPosteddate() {
		return posteddate;
	}
	public void setPosteddate(String posteddate) {
		this.posteddate = posteddate;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	

}
