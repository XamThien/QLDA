package main.java.DAO;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import main.java.model.MuonTra;

public class MuonTraDAO {
	@SuppressWarnings("unchecked")
	public  List<MuonTra> getAllMuonTra(){
		 List<MuonTra> list=null;
	        try
	        {
	        	Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from MuonTra where status=1";
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
	 
	 public MuonTra getMuonTraByID(int id) {
		 MuonTra cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from MuonTra where ID="+id;
		        Query que = session.createQuery(hql);
		        cl = (MuonTra) que.uniqueResult();
		        transaction.commit();
		        session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public MuonTra getMuonTraByMSSV(String mssv) {
		 MuonTra cl = null;
	       try
	       {
	    	    Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from MuonTra where mssv='"+mssv+"' and status=1";
		        Query que = session.createQuery(hql);
		        cl = (MuonTra) que.uniqueResult();
		        transaction.commit();
		        session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public void insertMuonTra(MuonTra sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        session.close();
	    }
	
	 public void updateMuonTra(MuonTra sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(sp);
	        transaction.commit();
	        session.close();
	    }
	 public MuonTra getLast() {
		 MuonTra cl = null;
		 List<MuonTra> list=null;
	       try
	       {
	    	   Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from MuonTra order by id DESC";
		        Query que = session.createQuery(hql);
		        list = que.list();
		        cl = list.get(0);
		        transaction.commit();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return cl;
	    }
	 public static void main(String[] args) {
//		 List<NhanVien> lst = new NhanVienDAO().getAllNhanVien();
//		 for(NhanVien nv : lst)
//		 {
//			 System.out.println(nv.getName());
//		 }
		 //NhanVien nv = new NhanVienDAO().getNhanVienByName("huy");
		 //System.out.println(nv.getName());
		 MuonTra mt = new MuonTraDAO().getMuonTraByMSSV("HUy");
		 System.out.println(mt.getNameSv());
	}
}
