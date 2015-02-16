package com.eshop.admin.dao;

import org.springframework.stereotype.Component;

import com.eshop.admin.dto.UserDTO;


@Component("userDAO")
public class UserDAOImpl implements UserDAO{
	
	@Override
	public UserDTO getUserDataBaseOnUserName(String userName){
		return selectHQLQuery("From UserEntity");
	}

}
