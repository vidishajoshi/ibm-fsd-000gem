package crud_operation;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;

public class DeleteDetails {

	public void delete() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

Session session=factory.getCurrentSession();
Scanner si=new Scanner(System.in);
System.out.println("Enter the id : ");
int id=si.nextInt();
session.getTransaction().begin();
Instructor ind=session.get(Instructor.class, id);
InstructorDetail in=session.get(InstructorDetail.class, id);
if(ind!=null) {
	session.delete(ind);
	System.out.println("instructor delete done");
	session.delete(in);
	System.out.println("instructor details delete done");
}else {
	System.out.println("Give valid id!!");
}
session.getTransaction().commit();
System.out.println("done");
	}

}
