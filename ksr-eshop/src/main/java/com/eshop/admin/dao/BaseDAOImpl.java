package com.eshop.admin.dao;


import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.eshop.util.BaseEshopHibernateUtil;
@SuppressWarnings("unchecked")
public class BaseDAOImpl implements BaseDAO{
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(BaseDAOImpl.class);
	
	
	/**
	 * This method used to get the data by using hibernate HQL query
	 * 
	 * @param query
	 * @return List
	 */
	public List<Object> selectHQLQuery(String query){
		Session session=null;		
		Query sql=null;
		List<Object> list=null;
		try{
			sessionFactory=BaseEshopHibernateUtil.getSessionFactory();
			session=sessionFactory.openSession();
			sql=session.createQuery(query);	
			list=sql.list();
		}catch (HibernateException e) {	       
	         logger.warn(e.getMessage());
	    }finally {
	         session.close(); 
	    }
		return list;
	}
	
	/**
	 * This method used to get data by using hibernate HQL query by passing parameters 
	 * 
	 * @param query
	 * @param params
	 * @return List
	 */
	public List<Object> selectHQLQuery(String query,Map<String,Object> params){		
		Session session=null;		
		Query sql=null;
		List<Object> list=null;
		try{
			sessionFactory=BaseEshopHibernateUtil.getSessionFactory();
			session=sessionFactory.openSession();
			sql=session.createQuery(query);
			if(params.size()>0){
				Iterator<Map.Entry<String,Object>> it=params.entrySet().iterator();
				while(it.hasNext()){
					Map.Entry<String,Object> pairs = (Map.Entry<String,Object>)it.next();
					sql.setString(pairs.getKey().toString(), pairs.getValue().toString());
				}
			}		
			list=sql.list();
		}catch (HibernateException e) {	       
	         logger.warn(e.getMessage());
	    }finally {
	         session.close(); 
	    }
		return list;
	}
	
	/**
	 * This method used to update data with Hibernate HQL query by passing parameters
	 * 
	 * @param query
	 * @param params
	 * @return int
	 */
	public int updateHQLQuery(String query,Map<String,Object> params){
		Transaction tx=null;
		Session session=null;
		int returnId=0;		
		try{
			sessionFactory=BaseEshopHibernateUtil.getSessionFactory();
			session=sessionFactory.openSession();		
			tx=session.beginTransaction();
			Query sql=session.createQuery(query);	
			if(params.size()>0){
				Iterator<Map.Entry<String,Object>> it=params.entrySet().iterator();
				while(it.hasNext()){
					Map.Entry<String,Object> pairs = (Map.Entry<String,Object>)it.next();
					sql.setString(pairs.getKey().toString(), pairs.getValue().toString());
				}
			}
			returnId=sql.executeUpdate();
		}catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         logger.warn(e.getMessage());
	    }finally {
	         session.close(); 
	    }
		return returnId;
	}
	
	/**
	 * This method used to delete data with Hibernate HQL query by passing parameters 
	 * 
	 * @param query
	 * @param params
	 * @return
	 */
	public int deleteHQLQuery(String query,Map<String,Object> params){
		Transaction tx=null;
		Session session=null;
		int returnId=0;		
		try{
			sessionFactory=BaseEshopHibernateUtil.getSessionFactory();
			session=sessionFactory.openSession();	
			tx=session.beginTransaction();
			Query sql=session.createQuery(query);	
			if(params.size()>0){
				Iterator<Map.Entry<String,Object>> it=params.entrySet().iterator();
				while(it.hasNext()){
					Map.Entry<String,Object> pairs = (Map.Entry<String,Object>)it.next();
					sql.setString(pairs.getKey().toString(), pairs.getValue().toString());
				}
			}
			returnId=sql.executeUpdate();
		}catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         logger.warn(e.getMessage());
	    }finally {
	         session.close(); 
	    }
		return returnId;
	}
	
	
	/**
	 * This method used to insert data with Hibernate Criteria by passing Objects
	 * 
	 * @param object
	 * @return
	 */
	public int insertCriteriaQuery(Object object){
		Transaction tx=null;
		Session session=null;
		int returnId=0;		
		try{
			sessionFactory=BaseEshopHibernateUtil.getSessionFactory();
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			returnId=(Integer)session.save(object);
			tx.commit();
		}catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         logger.warn(e.getMessage());
	    }finally {
	         session.close(); 
	    }
		return returnId;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
