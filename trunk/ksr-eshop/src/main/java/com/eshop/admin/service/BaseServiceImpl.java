package com.eshop.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.admin.dao.TestDAO;

@Service
public class BaseServiceImpl {
	@Autowired
	TestDAO testDAO;
	
	public List<Object> getData(){
		return testDAO.getData();
	}
}
