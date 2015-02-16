package com.eshop.admin.dto;

import javax.persistence.Entity;

@Entity

public class UserRoleDTO {
	private Integer userRoleId;
	private UserDTO user;
	private String role;

	public UserRoleDTO() {
	}

	public UserRoleDTO(UserDTO user, String role) {
		this.user = user;
		this.role = role;
	}
	
	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public UserDTO getUser() {
		return this.user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
