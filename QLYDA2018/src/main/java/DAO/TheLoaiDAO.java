package main.java.DAO;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


import main.java.model.TheLoai;
public class TheLoaiDAO {
	@SuppressWarnings("unchecked")
	public  List<TheLoai> getAllTheLoai(){
		 List<TheLoai> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from TheLoai where status=1";
		        Query que = session.createQuery(hql);
		        list = que.list();
		        transaction.commit();
		        session.close();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        
	       
	        return list;
	}
	 
	 public TheLoai getTheLoaiByID(int id) {
		 TheLoai cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from TheLoai where ID="+id;
		        Query que = session.createQuery(hql);
		        cl = (TheLoai) que.uniqueResult();
		        transaction.commit();
		        session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 
	 public void insertTheLoai(TheLoai sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        session.close();
	    }
	
	 public void updateTheLoai(TheLoai sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(sp);
	        transaction.commit();
	        session.close();
	    }
	 
	 public static void main(String[] args) {
     TheLoai tl = new TheLoaiDAO().getTheLoaiByID(1);
     tl.setName("Truyện aaa");
     new TheLoaiDAO().updateTheLoai(tl);
     TheLoai tll = new TheLoaiDAO().getTheLoaiByID(1);
     System.out.println(tll.getName());
	}
}
