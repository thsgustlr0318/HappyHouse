package com.ssafy.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.service.HouseService;

@Controller
public class MainController {

	@Autowired
	private HouseService houseService;
	
	@GetMapping({ "/", "/index" })
	public String showRoot() {
		return "index";
	}

	
	@GetMapping(value = "/searchByName")
	public String searchByName(String name, Model model) throws Exception {
		System.out.println("search "+name);
		List<HouseInfoDto> res = houseService.getAptInAptName(name);
		model.addAttribute("apt", res);
		return "/apartment/searchByName";
	}
}