package com.gatedcommunity.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.gatedcommunity.model.Resident;
import com.gatedcommunity.util.HibernateUtil;

public class ResidentDAO {

  public static void saveResident(Resident res) {
	  SessionFactory factory = HibernateUtil.getSessionFactory();
	  Session os = factory.openSession();
	  os.beginTransaction();
	  Resident resi = new Resident();
	  resi.setEmail(res.getEmail());
	  resi.setFullName(res.getFullName());
	  resi.setPassword(res.getPassword());
	  resi.setUsername(res.getUsername());
	  resi.setRole("Resident");
	  os.persist(resi);
	  os.getTransaction().commit();
	  
  }
  
  public static Resident findByName(String username) {
	  SessionFactory factory = HibernateUtil.getSessionFactory();
	  Session os = factory.openSession();
	   Query<Resident> query = os.createQuery( "FROM Resident WHERE username = ?1", Resident.class);
	   query.setParameter(1,username);
	  Resident uniqueResult = query.uniqueResult();
	  if(uniqueResult==null) {
		  return null;
	  }
	  else {
		  return uniqueResult;
	  }
	  
  }
  
  public static boolean validateResident(Resident rs) {
	    Resident byName = findByName(rs.getUsername());
	    if (byName == null || byName.getRole().equals("Admin")) {
	        return false;
	    }
	    return rs.getPassword().equals(byName.getPassword());
	}

//  public static void saveComplaint(Complaint comp) {
//	  SessionFactory factory = HibernateUtil.getSessionFactory();
//	  Session os = factory.openSession();
//	  os.beginTransaction();
//	 Complaint complaint = new Complaint();
//	 complaint.setCategory(comp.getCategory());
//	 complaint.setDescription(comp.getDescription());
//	 complaint.setStatus("Pending");
//	 complaint.setSubject(comp.getSubject());
//	 complaint.setUserId(comp.getUserId());
//	 os.persist(complaint);
//	 os.getTransaction().commit();
//  }
	  
  }
  
	

