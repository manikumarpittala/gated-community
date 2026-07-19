package com.gatedcommunity.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.gatedcommunity.model.Complaint;
import com.gatedcommunity.model.Resident;
import com.gatedcommunity.util.HibernateUtil;

public class AdminDAO {
	
	public static boolean validAdmin(String username) {
		Resident byName = AdminDAO.findByName(username);
		if(byName!=null && byName.getRole().equals("Admin")) {
			return true;
		}else {
	return false;
		}
		}

	public static Resident findByName(String username) {
		  SessionFactory factory = HibernateUtil.getSessionFactory();
		  Session os = factory.openSession();
		   Query<Resident> query = os.createQuery( "FROM Resident WHERE username = ?1", Resident.class);
		   query.setParameter(1,username);
		   return query.uniqueResult();
	  }
	public static List<Complaint> viewAllComplaints(){
		  SessionFactory factory = HibernateUtil.getSessionFactory();
		  Session os = factory.openSession();
		 Query<Complaint> query = os.createQuery("From Complaint",Complaint.class);
		  List<Complaint> list = query.list();
		  return list;
	}
	
	public static Complaint findComplaintById(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session os = sessionFactory.openSession();
		Complaint complaint = os.find(Complaint.class, id);
		return complaint;
	}
	
	public static void updateStatus(Complaint comp) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session os = sessionFactory.openSession();
		os.beginTransaction();
		Complaint complaint = os.find(Complaint.class, comp.getComplaintId());
		complaint.setStatus(comp.getStatus());
		os.merge(complaint);
		os.getTransaction().commit();
	}
	
}
