package com.eshop.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshop.admin.dto.MessageDTO;
import com.eshop.admin.properties.bean.MailProperties;
import com.eshop.admin.service.BaseServiceImpl;
import com.eshop.util.MailSendingUtil;
import com.eshop.util.PackagesFindUtil;

@Controller
@RequestMapping(value="/hello")
public class BaseAction {
	@Autowired
	BaseServiceImpl baseService;
	@Autowired
	MailProperties mailProperties;	
	@Autowired
	MailSendingUtil mailSendingUtil;
	@Autowired
	PackagesFindUtil packagesFindUtil;
	
	private static final Logger logger = Logger.getLogger(BaseAction.class);
	
	@RequestMapping(value="/test",method = RequestMethod.GET)
	public String printHello(ModelMap model,HttpServletRequest request) {
		/*MessageDTO messageDTO=new MessageDTO();		
		messageDTO.setSendTo("kanalasudarshan@gmail.com");
		messageDTO.setSubject("First mail");
		messageDTO.setMessage("Hi i am sending fisrt message");
		mailSendingUtil.sendMail(messageDTO);*/	
		System.out.println(packagesFindUtil.getPackages(request.getSession().getServletContext().getRealPath("/")));
		model.addAttribute("message", "hi  "+mailProperties.getUsername());
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
