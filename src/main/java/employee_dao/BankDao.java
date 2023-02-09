package employee_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import spring_employee.BankAccunt;
import spring_employee.Employee;

public class BankDao {
	
	@Autowired
	 EntityManager entityManager;
	 public void saveBank(BankAccunt  bankAccunt) {
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 entityTransaction.begin();
		 entityManager.persist(bankAccunt);
		 entityTransaction.commit();
		 
	 }
	 public void deleteBankAccount(int bid) {
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 BankAccunt  bankAccunt=entityManager.find(BankAccunt.class, bid);
		 entityTransaction.begin();
		 entityManager.remove(bankAccunt);
		 entityTransaction.commit();
		 
		 
	 }
	 public void updateBankAccount(int bid,String bname) {
		 EntityTransaction entityTransaction=entityManager.getTransaction();
		 BankAccunt  bankAccunt=entityManager.find(BankAccunt.class, bid);
		 bankAccunt.setBname(bname);
		 entityTransaction.begin();
		 entityManager.merge(bankAccunt);
		 entityTransaction.commit();
		 
		 
	 }
	 public List<BankAccunt> getBankAccount(){ 
			
			Query query=entityManager.createQuery("Select b from BankAccunt b");
			List<BankAccunt>list=query.getResultList();
			return list;

}
	 public BankAccunt getBankAccount(int bid) {
			
			EntityTransaction entityTransaction=entityManager.getTransaction();
			BankAccunt  bankAccunt=entityManager.find(BankAccunt.class,bid);
			return bankAccunt;
		}
}



