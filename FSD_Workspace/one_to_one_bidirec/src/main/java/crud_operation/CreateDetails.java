package crud_operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;

public class CreateDetails {
public void create(){
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
			                  .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
	
	Session session=factory.getCurrentSession();
			Instructor in=new Instructor("Smith","johnson","smith@g.com");
	InstructorDetail inD=new InstructorDetail("https://www.youtube.com/artr","Painiting");
	in.setInstructor_detail(inD);
	session.beginTransaction();
	session.persist(in);
	session.getTransaction().commit();
	System.out.println("Instructor added ");
}
}
