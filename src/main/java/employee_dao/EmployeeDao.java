package employee_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring_employee.Employee;
@Component
public class EmployeeDao {
	@Autowired
	 EntityManager entityManager;
	 public void savePerson(Employee employee) {
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 entityTransaction.begin();
		 entityManager.persist(employee);
		 entityTransaction.commit();
		 
	 }
	 public void deletePerson(int eid) {
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 Employee employee=entityManager.find(Employee.class, eid);
		 entityTransaction.begin();
		 entityManager.remove(employee);
		 entityTransaction.commit();
		 
		 
	 }
	 public void updatePerson(int eid,String name) {
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 Employee employee=entityManager.find(Employee.class, eid);
		 employee.setName(name);
		 entityTransaction.begin();
		 entityManager.merge(employee);
		 
		 
		 entityTransaction.commit();
		 
		 
	 }
	 public List<Employee> getAllPerson(){ 
			
			Query query=entityManager.createQuery("Select e from Employee e");
			List<Employee>list=query.getResultList();
			return list;

}
	 public Employee getPerson(int eid) {
			
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Employee employee=entityManager.find(Employee.class,eid);
			return employee;
		}
}
