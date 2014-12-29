package com.eshop.util;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component("packagesFindUtil")
public class PackagesFindUtil {

	public Set<String> getPackages(String searchPath) {
		Set<String> packageNames=null;	
		File folder=null;
		try{			
			
			packageNames=new HashSet<String>();
			folder =new File(searchPath);
			
			File[] listOfFiles = folder.listFiles();
		    for (int i = 0; i < listOfFiles.length; i++) {
		    	if (listOfFiles[i].isFile()) {	    		
		    		if (listOfFiles[i].getName().endsWith(".class")) {		    			
		    			packageNames.add(listOfFiles[i].getAbsoluteFile().toString().substring(
		    					listOfFiles[i].getAbsoluteFile().toString().lastIndexOf("com"), 
		    					listOfFiles[i].getAbsoluteFile().toString().lastIndexOf("\\")
		    			).replaceAll("\\\\", "."));
		    		}
		    	} else if (listOfFiles[i].isDirectory()) {		    	
		    		packageNames.addAll(getPackages(listOfFiles[i].getAbsolutePath()));
		    	}
		    }
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return packageNames;			
	}	
}
