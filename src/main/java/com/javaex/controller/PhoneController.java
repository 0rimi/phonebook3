package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value="/phone")
public class PhoneController {
	
	//필드
	
	//생성자
	
	//메소드gs
	
	//메소드일반
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhoneController > writeForm");
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	//파라미터를 직접 갖다 쓸수가 없음 frontController에서 받아오는작업필요
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController > write");
		
		System.out.println(personVo);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		//리다이렉트
		return "redirect:/phone/list";	
	}
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) { //컨트롤러에서 모델을 통해 프론트컨트롤러로 보내!
		System.out.println("PhoneController > list");
		
		//다오에서 리스트를 가져온다
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> pList = phoneDao.getPersonList();
		System.out.println(pList.toString());
		
		//mvc패턴 : 모델, 컨트롤러, 뷰
		//컨트롤러 > DS데이터를 보낸다(model)
		model.addAttribute("pList", pList);
		
		//jsp정보를 리턴한다.(view)
		return "/WEB-INF/views/list.jsp";
	}
	
	@RequestMapping(value="/updateForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateForm(@RequestParam("no") String no, Model model) { //컨트롤러에서 모델을 통해 프론트컨트롤러로 보내!
		System.out.println("PhoneController > updateForm");
		
		//원래 코드값으로부터 정보 불러와서 미리 넣어주는 getPerson이용
		int id = Integer.parseInt(no);
		PhoneDao phoneDao = new PhoneDao();
		PersonVo pinfo = phoneDao.getPerson(id);
				
		//mvc패턴 : 모델, 컨트롤러, 뷰
		//컨트롤러 > DS데이터를 보낸다(model)
		model.addAttribute("pinfo", pinfo);
		
		return "/WEB-INF/views/updateForm.jsp";
	}
	
	@RequestMapping(value="/update", method= {RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController > update");
		
		//수정할 값불러와서 personUpdate 해주기
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personUpdate(personVo);
		
		//리다이렉트
		return "redirect:/phone/list";	
	}
	
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController > delete");
		
		System.out.println(personVo);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		//리다이렉트
		return "redirect:/phone/list";	
	}
	
	/*
	//파라미터를 직접 갖다 쓸수가 없음 frontController에서 받아오는작업필요
	@RequestMapping(value="/phone/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam("company") String company) {
		System.out.println("PhoneController > write");
		
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		PersonVo personVo = new PersonVo(name, hp, company);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		
		return "";	
	}
	*/
}
