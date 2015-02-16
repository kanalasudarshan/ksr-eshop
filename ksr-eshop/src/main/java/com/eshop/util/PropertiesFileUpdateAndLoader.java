package com.eshop.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component("propertiesFileUpdateAndLoader")
public class PropertiesFileUpdateAndLoader {

	public void updateProperties(HttpServletRequest request) {
		
		Properties prop = new Properties();
		OutputStream output = null;
	 
		try {
	 
			output = new FileOutputStream(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/log4j.properties"));
			
			// set the properties value
			prop.setProperty("database", "localhost");
			prop.setProperty("dbuser", "mkyong");
			prop.setProperty("dbpassword", "password");
	 
			// save properties to project root folder
			
	 
		} catch (IOException io) {			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	 
		}
	}
	
}
