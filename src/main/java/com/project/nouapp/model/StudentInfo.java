package com.project.nouapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="studentinfos")
public class StudentInfo {

	@Id
	private long rollno;
	@Column(nullable=false, length=50)
	private String name;
	@Column(nullable=false, length=50)
	private String fname;
	@Column(nullable=false, length=50)
	private String mname;
	@Column(nullable=false, length=6)
	private String gender;
	@Column(nullable=false, length=500)
	private String address;
	@Column(nullable=false, length=100)
	private String program;
	@Column(nullable=false, length=100)
	private String branch;
	@Column(nullable=false, length=100)
	private String year;
	@Column(nullable=false, length=15)
	private String contact;
	@Column(nullable=false, length=50)
	private String emailaddress;
	@Column(nullable=false, length=30)
	private String password;
	@Column(nullable=false, length=30)
	private String regdate;
	@Column(nullable=false, length=10)
	private String status;
	@Column(nullable=true, length=500)
	private String profilepic;
	
	
	
	
	public long getRollno() {
		return rollno;
	}
	public void setRollno(long rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProfilepic() {
		return profilepic;
	}
	public void setProfilepic(String profilepic) {
		this.profilepic = profilepic;
	}
	
}
