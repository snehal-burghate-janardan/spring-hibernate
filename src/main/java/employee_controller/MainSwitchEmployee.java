package employee_controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import employee_dao.BankDao;
import employee_dao.EmployeeDao;
import spring_employee.BankAccunt;
import spring_employee.Employee;
import spring_employee.EmployeeConfig;
@Component
public class MainSwitchEmployee {
	@Autowired
	Scanner sc;
	public static void main(String[] args) {
		
		ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig.class);
		MainSwitchEmployee main=context.getBean("mainSwitchEmployee",MainSwitchEmployee.class);
		Scanner sc=main.sc;
		Employee e=context.getBean("employee",Employee.class);
		EmployeeDao dao=context.getBean("employeeDao",EmployeeDao.class);
		
		BankAccunt b=context.getBean("bankAccunt",BankAccunt.class);
		
		
		boolean repeat = true;
		
	    do {
	    	System.out.println("1.Save Employee");

	    	System.out.println("2.Update Employee");

	    	System.out.println("3.delete Employee");

	    	System.out.println("4.get Employee by Id");

	    	System.out.println("5.Get all employee");

	    	System.out.println("6.Exit");

	    	int choice = sc.nextInt();
	    	
	    	switch (choice) {
			case 1:{
				System.out.println("Enter the employee name");
				String name=sc.next();
				System.out.println("Enter the address");
				String address=sc.next();
				System.out.println("Enter the phone");
				long phone=sc.nextLong();
				
				System.out.println("Enter the bank name");
				String bname=sc.next();
				System.out.println("Enter the bank address");
				String baddress=sc.next();
				System.out.println("Enter the bank ifsc");
				String ifsc=sc.next();
				
				e.setName(name);
				e.setAddress(address);
				e.setPhone(phone);
				
				b.setBname(bname);
				b.setBaddress(baddress);
				b.setIfsc(ifsc);
				
				dao.savePerson(e);
				e.setBankaccount(b);
		        System.out.println("Saved"); 
				
				
			
			}break;
			
			case 2:{
				System.out.println("Enter employee id ");
                int id = sc.nextInt();
				System.out.println("Enter employee new name");
				String name = sc.next();
				dao.updatePerson(id, name);
               System.out.println("updated");

				
				
			}break;
			
            case 3:{
            	System.out.println("Enter employee id to delete");
            	int id = sc.nextInt();
            	dao.deletePerson(id);
            	System.out.println("deleted");
				
			}break;
			
           case 4:{
        	   System.out.println("Enter employee id to get details");

        	   int id = sc.nextInt();

        	   System.out.println(dao.getPerson(id));
           
		}break;
		
           case 5:{
        	   System.out.println(dao.getAllPerson());
		}break;
		
           case 6:{
        	   repeat = false;
           
		}break;
			
			
		default:System.out.println("Invalid Password");
				break;
			}
	    
	}
	    while(repeat);

}
}
