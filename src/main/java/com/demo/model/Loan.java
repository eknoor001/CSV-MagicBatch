package com.demo.model;


public class Loan {

	private String Loan_id;
	private String status;
	private int principal;
	private int terms;
	private String effective_date;
	private String due_date;
	private String paid_off_time;
	private int past_due_days;
	private int age;
	private String education;
	private String gender;
	public Loan() {
		super();
		
	}
	public Loan(String loan_id, String status, int principal, int terms, String effective_date, String due_date,
			String paid_off_time, int past_due_days, int age, String education, String gender) {
		super();
		this.Loan_id = loan_id;
		this.status = status;
		this.principal = principal;
		this.terms = terms;
		this.effective_date = effective_date;
		this.due_date = due_date;
		this.paid_off_time = paid_off_time;
		this.past_due_days = past_due_days;
		this.age = age;
		this.education = education;
		this.gender = gender;
	}
	public String getLoan_id() {
		return Loan_id;
	}
	public void setLoan_id(String loan_id) {
		this.Loan_id = loan_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPrincipal() {
		return principal;
	}
	public void setPrincipal(int principal) {
		this.principal = principal;
	}
	public int getTerms() {
		return terms;
	}
	public void setTerms(int terms) {
		this.terms = terms;
	}
	public String getEffective_date() {
		return effective_date;
	}
	public void setEffective_date(String effective_date) {
		this.effective_date = effective_date;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getPaid_off_time() {
		return paid_off_time;
	}
	public void setPaid_off_time(String paid_off_time) {
		this.paid_off_time = paid_off_time;
	}
	public int getPast_due_days() {
		return past_due_days;
	}
	public void setPast_due_days(int past_due_days) {
		this.past_due_days = past_due_days;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
