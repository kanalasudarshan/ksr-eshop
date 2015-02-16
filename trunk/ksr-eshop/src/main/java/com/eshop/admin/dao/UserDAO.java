package com.eshop.admin.dao;

import com.eshop.admin.dto.UserDTO;

public interface  UserDAO {

	public UserDTO getUserDataBaseOnUserName(String userName);	
}
