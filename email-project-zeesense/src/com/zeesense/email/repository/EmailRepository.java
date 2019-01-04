package com.zeesense.email.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zeesense.email.dto.EmailDTO;

@Repository
public class EmailRepository {
		
	@Autowired
	public SessionFactory sessionFactory;
	
	
	public Integer saveEmail(EmailDTO emailDTO) {
		
		Session session=null;
		Integer identifier=null;
		Transaction transaction=null;
		try {
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			identifier = (Integer) session.save(emailDTO);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			if(session!=null)
			session.close();
		}
		

		return identifier;
		
	}
	

}
