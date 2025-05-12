package com.sg.ai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	 
	@GetMapping("/sbb")
	@ResponseBody
	public String index() {
		return "안녕 sbb 나는";
	}
	@GetMapping("/")
	public String root() {
		return "redirect:/question/list";
	}
}
