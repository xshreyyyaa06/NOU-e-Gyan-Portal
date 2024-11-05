package com.project.nouapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="responses")
public class Response {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false,length=50)
	private String name;
	
	@Column(nullable=false,length=15)
	private String contact;
	
	@Column(nullable=false,length=50)
	private String emailaddress;
	
	@Column(nullable=false,length=100)
	private String program;
	
	@Column(nullable=false,length=100)
	private String branch;
	
	@Column(nullable=false,length=100)
	private String year;
	
	@Column(nullable=false,length=100)
	private String responsetype;
	
	@Column(nullable=false,length=5000)
	private String responsetext;
	
	@Column(nullable=false,length=30)
	private String responsedate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

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

	public String getResponsetype() {
		return responsetype;
	}

	public void setResponsetype(String responsetype) {
		this.responsetype = responsetype;
	}

	public String getResponsetext() {
		return responsetext;
	}

	public void setResponsetext(String responsetext) {
		this.responsetext = responsetext;
	}

	public String getResponsedate() {
		return responsedate;
	}

	public void setResponsedate(String responsedate) {
		this.responsedate = responsedate;
	}
}
