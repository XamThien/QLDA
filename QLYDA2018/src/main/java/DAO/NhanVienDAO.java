package main.java.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import main.java.model.NhanVien;

public class NhanVienDAO {
	@SuppressWarnings("unchecked")
	public  List<NhanVien> getAllNhanVien(){
		 List<NhanVien> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from NhanVien where status=1";
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
	 public NhanVien getNhanVienByName(String name) {
		 NhanVien cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from NhanVien where userName='"+name+"'";
		        Query que = session.createQuery(hql);
		        cl = (NhanVien) que.uniqueResult();
		        transaction.commit();
		        session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public NhanVien getNhanVienByID(int id) {
		 NhanVien cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from NhanVien where ID="+id;
		        Query que = session.createQuery(hql);
		        cl = (NhanVien) que.uniqueResult();
		        transaction.commit();
		        session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 
	 public void insertNhanVien(NhanVien sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        session.close();
	    }
	
	 public void updateNhanVien(NhanVien sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(sp);
	        transaction.commit();
	        session.close();
	    }
	 
	 public static void main(String[] args) {
//		 List<NhanVien> lst = new NhanVienDAO().getAllNhanVien();
//		 for(NhanVien nv : lst)
//		 {
//			 System.out.println(nv.getName());
//		 }
		 NhanVien nv = new NhanVienDAO().getNhanVienByName("huy");
		 System.out.println(nv.getName());
	}
}
