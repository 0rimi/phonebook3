package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhoneController {
	
	//필드
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	@RequestMapping(value="/phone/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhoneController > writeForm");
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	//파라미터를 직접 갖다 쓸수가 없음 frontController에서 받아오는작업필요
	@RequestMapping(value="/phone/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam("company") String company) {
		System.out.println("PhoneController > write");
		
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		return "";	
	}

}
