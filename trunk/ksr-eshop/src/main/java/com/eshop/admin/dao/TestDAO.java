package com.eshop.admin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class TestDAO extends BaseDAOImpl {
	
	public List<Object> getData(){
		return selectHQLQuery("From UserEntity");
		
	}

}
