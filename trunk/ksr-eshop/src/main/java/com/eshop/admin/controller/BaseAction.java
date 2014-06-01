package com.eshop.admin.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshop.admin.service.BaseServiceImpl;

@Controller
@RequestMapping(value="/hello")
public class BaseAction {
	@Autowired
	BaseServiceImpl baseService;
	private static final Logger logger = Logger.getLogger(BaseAction.class);
	
	@RequestMapping(value="/test",method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		 model.addAttribute("message", "hi sudarshan reddy");
		 logger.debug("hi sudarshan reddy");
		return "hello";
	}
	
	@RequestMapping(value="/woring",method = RequestMethod.GET)
	public String printWorking(ModelMap model) {
		 model.addAttribute("message", baseService.getData());
		 logger.debug(baseService.getData());
		return "working";
	}
	
	@RequestMapping(value="/json",method = RequestMethod.GET)
	public @ResponseBody List<Object> getJson() {
		
		logger.debug(baseService.getData());
		return baseService.getData();
	}

}
