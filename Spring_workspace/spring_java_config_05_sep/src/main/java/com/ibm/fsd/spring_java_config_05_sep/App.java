package com.ibm.fsd.spring_java_config_05_sep;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bean.Employee;
import bean.EmployeeConfig;
import bean.EmployeeDao;

public class App 
{
    public static void main( String[] args )
    {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
      EmployeeDao dao= context.getBean("employeeDao",EmployeeDao.class);
      Employee emp=context.getBean("employee",Employee.class);
      dao.createEmployee(emp);
      
    }
}
