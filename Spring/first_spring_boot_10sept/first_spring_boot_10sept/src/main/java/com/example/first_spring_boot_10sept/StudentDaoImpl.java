package com.example.first_spring_boot_10sept;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private EntityManager em;
	private Session session;
	
	@Transactional
	public void createApplicant(Applicant applicant) {
		session=em.unwrap(Session.class);
		System.out.println(applicant.toString());
		session.save(applicant);		
		
	}
	@Transactional
	public List<Applicant> getApplicants() {
		session=em.unwrap(Session.class);
		    List<Applicant> app=new ArrayList<Applicant>();
		    Query query=session.createQuery("From Applicant",Applicant.class);
		    app=query.getResultList();
		    
		return app;
	}
	@Transactional
	public Applicant getApplicantById(int id) {
	    session=em.unwrap(Session.class);
	    Applicant applicant=session.get(Applicant.class, id);
		return applicant;
	}
	@Transactional
	public void deleteApplicant(int id) {
		session=em.unwrap(Session.class);
		Applicant app=session.get(Applicant.class, id);
		session.remove(app);
		System.out.println("deleted");
		
	}
	@Transactional
	public List<Applicant> updateApplicants(int id, Applicant applicant) {
		// TODO Auto-generated method stub
		return null;
	}

}
