package com.capgemini;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
//import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Company {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU"); //EntityManager to perform operations on object
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();  
//		Department dept = new Department();
//		dept.setDept_name("Sales");
//        em.persist(dept);
//        
//        Employee emp1 = new Employee("Mansi","Sawant");
//		Employee emp2 = new Employee("Preshita","Sawant");
//		
//		emp1.setDepartment(dept);
//		emp2.setDepartment(dept);
//		
//		
//		em.persist(emp1);
//		em.persist(emp2);
//		
//		em.getTransaction().commit();
//		em.close();
        EntityTransaction txn = em.getTransaction();

        //Employee employee = new Employee(null, null);
        Employee emp1 = new Employee("yogita","Talekar");
		Employee emp2 = new Employee("Nikita","Talekar");

        txn.begin();
        Department department = em.find(Department.class, 1);//returns the department named vert
        System.out.println(department);
        txn.commit();

        emp1.setDepartment(department);

        txn.begin();
        em.persist(emp1);
        txn.commit();
        emp2.setDepartment(department);

        txn.begin();
        em.persist(emp2);
        txn.commit();
	}

}