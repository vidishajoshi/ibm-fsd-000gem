package com.ibm.fsd.spring_demo_04_sep;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.BasketballCoach;
import beans.Coach;
import beans.CricketCoach;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     try {
    	 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	 Coach myCoach=context.getBean("theCoach",CricketCoach.class);
    	 System.out.println(myCoach.getDailyWorlkout());
    	 Coach mycoach1=context.getBean("bCoach",BasketballCoach.class);
    	 System.out.println(mycoach1.getDailyWorlkout());
    	 
     }catch(Exception e) {
    	 
     }
    }
}
