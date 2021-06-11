package com.example.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring01.model.dto.PointDTO;

@Controller //현재 클래스를 컨트롤러로 등록시키는 옵션

public class MainController {
	@RequestMapping("/") //method와 url mapping
	public String main(Model model) {
		model.addAttribute("message","환영합니다."); //addAttribute(key,value)모델에 자료 전달
		
		return "main";//main.jsp 포워딩
	}
	@RequestMapping("gugu.do")
	public String gugu() {
		return "test/gugu";
	}
	@RequestMapping("gugu_result.do")
	public String gugu_result(@RequestParam(defaultValue = "3")int dan, Model model) {
		String result ="";
		for(int i = 1; i <=9; i++) {
			result +=dan + "x" + i + "=" +dan * i + "<br>";
			
		}
		model.addAttribute("result",result);
		return "test/gugu_result";
	}
		@RequestMapping("point.do")
		public String point() {
			return "test/point";
		}
		@RequestMapping("point_result.do")
		public String point_result(@ModelAttribute PointDTO dto, Model model) {
			System.out.println(dto);
			dto.setTotal(dto.getKor()+dto.getEng()+dto.getMat());
			String average=String.format("%.2f",dto.getTotal()/3.0);
			dto.setAverage(Double.parseDouble(average));
			model.addAttribute("dto" ,dto);
			return "test/point_result";
			}
		
		
		
		
	

}
