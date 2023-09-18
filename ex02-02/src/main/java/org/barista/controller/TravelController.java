package org.barista.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.barista.domain.Criteria;
import org.barista.domain.PageDTO;
import org.barista.domain.TravelVO;
import org.barista.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/travel")
public class TravelController {
	
	@Autowired
	private TravelService service;
	
	@ModelAttribute("searchTypes")
	public Map<String, String> searchTypes(){
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		map.put("R", "권역");
		map.put("T", "제목");
		map.put("D", "내용");
		map.put("RT", "권역 + 제목");
		map.put("TD", "제목 + 내용");
		map.put("RTD", "권역 + 제목 + 내용");
		
		return map;
	}
	
	@GetMapping("/list")
	public void list(@ModelAttribute("cri") Criteria cri,
			Model model) {
		
		// TravelService 인터페이스를 통해 getTotal() 호출
		int total = service.getTotal(cri);
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("no") Long no,
			@ModelAttribute("cri") Criteria cri,
			Model model) {

		model.addAttribute("travel", service.get(no));
	}
	
	// 실제 DB에 업데이트
	@PostMapping("/modify")
	public String modify(
			// 해당 객체의 유효성 검사
			@Valid
			@ModelAttribute("travel") TravelVO travel,
			Errors errors,
			@ModelAttribute("cri") Criteria cri,
			RedirectAttributes rttr) {
		
		if(errors.hasErrors()) {
			
			return "travel/modify";
		}

		service.modify(travel);

		// primary key인 no로 get == javascript식 코드
		return "redirect:" + cri.getLink("/travel/get")
						+ "&no=" + travel.getNo();
	}
	
	@GetMapping("/register")
	public void register(
			@ModelAttribute("travel") TravelVO travel) {

	}
	
	@PostMapping("/register")
	public String Register(
			@Valid
			@ModelAttribute("travel") TravelVO travel,
			Errors errors,
			RedirectAttributes rttr) {
		
		if(errors.hasErrors()) { // 유효성 검사 실패 시
			
			return "travel/register"; // view의 이름을 리턴
		}

		service.register(travel);

		return "redirect:/travel/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("no") Long no,
			@ModelAttribute("cri") Criteria cri,
		RedirectAttributes rttr) {
			
		service.remove(no);
		
		return "redirect:/travel/list" +cri.getLink();
	}

}
