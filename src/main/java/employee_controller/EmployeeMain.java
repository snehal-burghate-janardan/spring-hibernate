package employee_controller;




import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import employee_dao.EmployeeDao;
import spring_employee.BankAccunt;
import spring_employee.Employee;
import spring_employee.EmployeeConfig;

public class EmployeeMain {

	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig.class);
		Employee e=context.getBean("employee",Employee.class);
		//e.setName("snehall");
		//e.setAddress("ckm");
		//e.setPhone(23456655);
		
		
		
		//BankAccunt b=context.getBean("bankAccunt",BankAccunt.class);
		//b.setBname("ICIC");
		//b.setBaddress("mgroad");
		//b.setIfsc("ICIC102");
		//e.setBankaccount(b);
		
		EmployeeDao dao=context.getBean("employeeDao",EmployeeDao.class);
		//dao.savePerson(e);
		//dao.deletePerson(3);
		
		//String name="Snehall";
		//dao.updatePerson(1, name);
		
		//System.out.println(dao.getAllPerson());
		System.out.println(dao.getPerson(1));
		
		
	
		
		
		
		
		
		
		

	}

}
