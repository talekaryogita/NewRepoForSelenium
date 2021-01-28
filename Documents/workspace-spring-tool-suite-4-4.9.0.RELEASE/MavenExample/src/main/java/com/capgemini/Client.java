package com.capgemini;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Client {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		 CriteriaBuilder criteriaBuilder =em.getCriteriaBuilder();
		    CriteriaQuery<Message> criteriaQuery = criteriaBuilder.createQuery(Message.class);
		    Root<Message> userRoot = criteriaQuery.from(Message.class);
		    Message queryResult = em.createQuery(criteriaQuery.select(userRoot)
		      .where(criteriaBuilder.equal(userRoot.get("id"),  Long.valueOf(1))))
		      .getSingleResult();
		   // String message = (String) queryResult.getSingleResult();
        	System.out.println("-message from criteria query--"+queryResult);
		    
		   // return queryResult;
		
		
		//Native query
//		Query queryString= em.createNativeQuery("SELECT * FROM message WHERE id=:id", Message.class);
//		    queryString.setParameter("id", Long.valueOf(1));
//		    String message = (String) queryString.getSingleResult();
//        	System.out.println("-message from native query--"+message);
		    //return(Message)nativeQuery.getSingleResult();
		    
		
		
//		String qlQuery = "Select m from Message m";//Typed query
//		TypedQuery<Message> typeQuery = em.createQuery(qlQuery, Message.class);
//	    List<Message> messageTypeList = typeQuery.getResultList();
//	    for(Message messageType : messageTypeList) {
//		System.out.println(messageType.getText()+"--"+messageType.getId());
//		}
		
		//Named Query
//		Query queryString = em.createNamedQuery("Message.getText");
//		queryString.setParameter("id", Long.valueOf(1));
//		String message = (String) queryString.getSingleResult();
//		System.out.println("-message from named query--"+message);
//		
//		
//		String qlQuery = "Select m from Message m"; //From Message 
//		Query query = em.createQuery(qlQuery);
//		List<Message> messageList = query.getResultList();
//		for(Message message: messageList) {
//		System.out.println(message.getId()+"---"+"\t"+message.getText());
//		}
//		Message updatevalue =em.find(Message.class, Long.valueOf(1)); //crud operation update
//		updatevalue.setText("hie");
//		em.persist(updatevalue);
		
		//Message message = new Message();
		//message.setText("Hello");
		//em.persist(message);
		
		em.getTransaction().commit();
		//em.getTransaction().begin();
		
		//Message message1 = new Message();
		//message1.setText("world");
		//em.persist(message1);
		
		//em.getTransaction().commit();
		em.close();
		factory.close();
		
		//Last Line
		

	}

}
