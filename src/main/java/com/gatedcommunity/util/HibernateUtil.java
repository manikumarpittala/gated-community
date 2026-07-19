package com.gatedcommunity.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gatedcommunity.model.Complaint;
import com.gatedcommunity.model.Resident;

public class HibernateUtil {
	
	public static SessionFactory session = null;
	
	public static SessionFactory getSessionFactory() {
		if(session== null) {
			Configuration con = new Configuration();
			con.configure();
			con.addAnnotatedClass(Complaint.class);
			con.addAnnotatedClass(Resident.class);
			return session = con.buildSessionFactory();
		}
		else return session;
	}

}
