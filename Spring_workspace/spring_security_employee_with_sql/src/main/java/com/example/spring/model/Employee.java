package com.example.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="fname")
	private String fName;
	@Column(name="lname")
	private String lName;
	@Column(name="email")
	private String email;
	@Column(name="job")
	private String jobType;
	@Column(name="paid")
	private int hourlyPaid;
	@Column(name="period")
	private int timePeriod;
	@Column(name="sal")
	private double salary;
	@Column(name="comm")
	private double commission;
	public Employee() {
		super();
	}
	public Employee(String fName, String lName, String email, String jobType, int hourlyPaid, int timePeriod,
			double salary, double commission) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.jobType = jobType;
		this.hourlyPaid = hourlyPaid;
		this.timePeriod = timePeriod;
		this.salary = salary;
		this.commission = commission;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public int getHourlyPaid() {
		return hourlyPaid;
	}
	public void setHourlyPaid(int hourlyPaid) {
		this.hourlyPaid = hourlyPaid;
	}
	public int getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(int timePeriod) {
		this.timePeriod = timePeriod;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", jobType="
				+ jobType + ", hourlyPaid=" + hourlyPaid + ", timePeriod=" + timePeriod + ", salary=" + salary
				+ ", commission=" + commission + "]";
	}


	
}

