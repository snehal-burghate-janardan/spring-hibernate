package spring_employee;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"spring_employee","employee_dao","employee_controller"})
public class EmployeeConfig {
     @Bean
	public EntityManager getEntityManager() {
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
			return entityManagerFactory.createEntityManager();
	}
     @Bean
     public Scanner getScanner() {
			
			return new Scanner(System.in);
	}
     
    
     
}
