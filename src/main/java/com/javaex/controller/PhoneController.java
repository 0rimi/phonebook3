package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PhoneController {
	
	//필드
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	@RequestMapping(value="/phone/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		System.out.println("PhoneController > writeForm");
		
		return "";
	}

}
