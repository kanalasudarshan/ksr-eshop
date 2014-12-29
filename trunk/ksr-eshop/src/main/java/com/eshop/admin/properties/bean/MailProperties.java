package com.eshop.admin.properties.bean;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mailProperties")
public class MailProperties{
	
	@Value("${mail.smtp.host}")
	private String hostAddress;
	@Value("${mail.server}")
	private String serverAddress;
	@Value("${mail.protocol}")
	private String protocal;
	@Value("${mail.port}")
	private String port;
	@Value("${mail.username}")
	public String username;
	@Value("${mail.password}")
	public String password;	
	
	
	public String getUsername() {		
		return username;		
	}
	public void setUsername(String username) {
		this.username = username;
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHostAddress() {
		return hostAddress;
	}
	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}
	public String getServerAddress() {
		return serverAddress;
	}
	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}
	public String getProtocal() {
		return protocal;
	}
	public void setProtocal(String protocal) {
		this.protocal = protocal;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}	
	public static void main(String[] args) {
		try{
			File folder =new File(new File(".").getCanonicalPath());
			System.out.println(folder.list());
			for(String name : folder.list())
			{
			    
			        System.out.println(name);
			   
			}
		}catch(Exception e){
			
		}
	}
}
