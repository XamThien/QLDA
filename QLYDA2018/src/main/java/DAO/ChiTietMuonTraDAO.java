package main.java.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import main.java.model.ChiTietMuonTra;
import main.java.model.NhanVien;


public class ChiTietMuonTraDAO {
	@SuppressWarnings("unchecked")
	public List<ChiTietMuonTra> getTheLoaiByID(int id) {
		List<ChiTietMuonTra> list = null;
	       try
	       {
	    	   Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from ChiTietMuonTra where MA_PHIEU_MUON_TRA="+id+" and XAC_NHAN_TRA = 1";
		        Query que = session.createQuery(hql);
		        list = que.list();
		        transaction.commit();
		        //session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return list;
	    }
	public ChiTietMuonTra getByID(int pid,int sid) {
		ChiTietMuonTra ctmt = null;
	       try
	       {
	    	   Configuration configuration =  new Configuration().configure();
	        	SessionFactory sessionFactory = configuration.buildSessionFactory();
	        	Session session = sessionFactory.openSession();
	        	
	        	//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        Transaction transaction = session.beginTransaction();
		        String hql ="from ChiTietMuonTra where MA_PHIEU_MUON_TRA="+pid+" and MA_SACH = "+sid;
		        Query que = session.createQuery(hql);
		        ctmt = (ChiTietMuonTra) que.uniqueResult();
		        transaction.commit();
		        session.close();
	       }
	       catch  (HibernateException e) {
	    	   e.printStackTrace();
	        }
	        return ctmt;
	    }
	 public void insertTheLoai(ChiTietMuonTra sp){
		 	Configuration configuration =  new Configuration().configure();
		 	SessionFactory sessionFactory = configuration.buildSessionFactory();
		 	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.save(sp);
	        transaction.commit();
	        session.close();
	    }
	
	 public void updateTheLoai(ChiTietMuonTra sp){
		 	Configuration configuration =  new Configuration().configure();
	     	SessionFactory sessionFactory = configuration.buildSessionFactory();
	     	Session session = sessionFactory.openSession();
	        Transaction transaction = session.beginTransaction();
	        session.update(sp);
	        transaction.commit();
	        session.close();
	    }
	 
	 public static void main(String[] args) {
		 ChiTietMuonTra list =new ChiTietMuonTraDAO().getByID(13,1);
		 
			 System.out.println(list.getSach().getName());
		
	}
	
	 
}
