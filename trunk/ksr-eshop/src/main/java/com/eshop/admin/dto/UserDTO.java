package com.eshop.admin.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.type.NullableType;

@Entity
@Table(name="b_user")
public class UserDTO{
	
	private String username;	
	private String password;	
	private boolean enabled;	
	private Set<UserRoleDTO> userRole = new HashSet<UserRoleDTO>(0);

	public UserDTO() {
	}

	public UserDTO(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public UserDTO(String username, String password, boolean enabled, Set<UserRoleDTO> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}
	
	@Column(name = "user_name", unique = true,nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}
	@Column(name = "password", unique = false,nullable = false, length = 45)
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}
	@Column(name="isenabled",nullable = false)
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}	
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@JoinTable(name = "user_role", 
		joinColumns = {@JoinColumn(name="user_id",nullable=false,updatable = false)},
		inverseJoinColumns={@JoinColumn(name="role_id",nullable=false,updatable = false)})
	public Set<UserRoleDTO> getUserRole() {
		return this.userRole;
	}
	public void setUserRole(Set<UserRoleDTO> userRole) {
		this.userRole = userRole;
	}

}
