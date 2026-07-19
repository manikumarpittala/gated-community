package com.gatedcommunity.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.SelectionQuery;

import com.gatedcommunity.model.Complaint;
import com.gatedcommunity.model.Resident;
import com.gatedcommunity.util.HibernateUtil;

public class ComplaintDAO {

	public static Resident findByName(String username) {
		  SessionFactory factory = HibernateUtil.getSessionFactory();
		  Session os = factory.openSession();
		   Query<Resident> query = os.createQuery( "FROM Resident WHERE username = ?1", Resident.class);
		   query.setParameter(1,username);
		   return query.uniqueResult();
	  }
	
	public static List<Complaint> getComplaintsById(int userId){
		 SessionFactory factory = HibernateUtil.getSessionFactory();
		  Session os = factory.openSession();
//		 return List<Complaint> complaint = os.find(Complaint.class, userId);
		 SelectionQuery<Complaint> selectionQuery = os.createSelectionQuery("From Complaint where userId = ?1",Complaint.class);
		 selectionQuery.setParameter(1, userId);
		 List<Complaint> list = selectionQuery.list();
		 return list;
		 
	}

	public static void deleteComplaint(int id) {
		 SessionFactory factory = HibernateUtil.getSessionFactory();
		  Session os = factory.openSession();
		  os.beginTransaction();
		  Complaint comp = new Complaint(id);
		  os.remove(comp);
		  os.getTransaction().commit();
		  
	}
	public static Complaint findComplaintById(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session os = sessionFactory.openSession();
		Complaint complaint = os.find(Complaint.class, id);
		return complaint;
	}
	
	public static void updateComplaint(Complaint comp) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session os = sessionFactory.openSession();
		os.beginTransaction();
		Complaint complaint = os.find(Complaint.class, comp.getComplaintId());
		complaint.setCategory(comp.getCategory());
		complaint.setSubject(comp.getSubject());
		complaint.setDescription(comp.getDescription());
		os.merge(complaint);
		os.getTransaction().commit();
	}
	
	
	
//	public static Resident getDetails() {
//		Resident resident = ComplaintDAO.getDetails();
//		Resident resi = new Resident();
//		resi.setFullName(resident.getFullName());;
//		resi.setEmail(resident.getEmail());
//		resi.setUsername(resident.getUsername());
//		resi.setId(resident.getId());
//		
//		return resi;
//	}
	
//	public static Resident findByEmail(String email) {
//		  SessionFactory factory = HibernateUtil.getSessionFactory();
//		  Session os = factory.openSession();
//		   Query<Resident> query = os.createQuery( "FROM Resident WHERE email = ?1", Resident.class);
//		   query.setParameter(1,email);
//		   return query.uniqueResult();
//	  }
	  public static void saveComplaint(Complaint comp) {
		  SessionFactory factory = HibernateUtil.getSessionFactory();
		  Session os = factory.openSession();
		  os.beginTransaction();
		 Complaint complaint = new Complaint();
		 complaint.setCategory(comp.getCategory());
		 complaint.setDescription(comp.getDescription());
		 complaint.setStatus(comp.getStatus());
		 complaint.setSubject(comp.getSubject());
		 complaint.setUserId(comp.getUserId());
		 os.persist(complaint);
		 os.getTransaction().commit();
	  }
	
}
