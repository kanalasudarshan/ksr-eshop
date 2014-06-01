package com.eshop.admin.dao;

import java.util.List;
import java.util.Map;

public interface BaseDAO {

	/**
	 * This method used to get the data by using hibernate HQL query
	 * 
	 * @param query
	 * @return List
	 */
	public List<Object> selectHQLQuery(String query);
	
	/**
	 * This method used to get data by using hibernate HQL query by passing parameters 
	 * 
	 * @param query
	 * @param params
	 * @return List
	 */
	public List<Object> selectHQLQuery(String query,Map<String,Object> params);
	
	/**
	 * This method used to update data with Hibernate HQL query by passing parameters
	 * 
	 * @param query
	 * @param params
	 * @return int
	 */
	public int updateHQLQuery(String query,Map<String,Object> params);
	
	/**
	 * This method used to delete data with Hibernate HQL query by passing parameters 
	 * 
	 * @param query
	 * @param params
	 * @return
	 */
	public int deleteHQLQuery(String query,Map<String,Object> params);
	
	/**
	 * This method used to insert data with Hibernate Criteria by passing Objects
	 * 
	 * @param object
	 * @return
	 */
	public int insertCriteriaQuery(Object object);

}
