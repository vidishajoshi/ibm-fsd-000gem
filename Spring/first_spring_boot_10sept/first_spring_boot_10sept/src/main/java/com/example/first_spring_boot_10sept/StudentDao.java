package com.example.first_spring_boot_10sept;

import java.util.List;

public interface StudentDao {

	public List<Applicant> getApplicants();
	public void createApplicant(Applicant applicant);
	public Applicant getApplicantById(int id);
	public void deleteApplicant(int id);
	public List<Applicant> updateApplicants(int id,Applicant applicant);
}
