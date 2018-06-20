package main.java.DAO;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import main.java.model.Sach;

public class SachDAO {
	@SuppressWarnings("unchecked")
	public  List<Sach> getAllSach(){
		 List<Sach> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from Sach where trangThai =1";
		        Query que = session.createQuery(hql);
		        list = que.list();
		        transaction.commit();
		       // session.close();
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	@SuppressWarnings("unchecked")
	public  List<Sach> getLikeString(String str) throws Exception{
		 List<Sach> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from Sach where  trangThai =1 and NAME like '%" + str.toLowerCase().trim()+" %' ";
		        Query que = session.createQuery(hql);
		        
		        list = que.list();
		        
		        transaction.commit();
		        if(list!=null)
		        {
		        	for(int i=0; i<list.size();i++)
		        	{
		        		Sach bk = list.get(i);
		        		if(!bk.getTheLoai().getStatus())
		        		{
		        			list.remove(i);
		        		}
		        	}
		        }
	        }
	        catch  (HibernateException e) {
	        	 e.printStackTrace();
	        }
	        return list;
	}
	 public Sach getSachByID(int id) {
		 Sach cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from Sach where ID="+id;
		        Query que = session.createQuery(hql);
		        cl = (Sach) que.uniqueResult();
		        transaction.commit();
		        session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 
	 public void insertSach(Sach sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        session.close();
	    }
	
	 public void updateSach(Sach sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(sp);
	        transaction.commit();
	        session.close();
	    }
	 
	 public static void main(String[] args) throws Exception {
		 List<Sach> lstt = new SachDAO().getLikeString("co");
		 System.out.println(lstt.size());
		 //System.out.println();
		 if(lstt!= null)
		 {
			 for(Sach bk :lstt)
			 {
				 System.out.println(bk.getTheLoai().getName());
			 }
		 }
		 else
		 {
			 System.out.println("csdcsc");
		 }
//		 Sach bk = new SachDAO().getSachByID(1);
//		 System.out.println(bk);
	}
}
