package cn.itcyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
  
	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name") String username,Model model) {
		model.addAttribute("name",username);
		return "hello";
	}
}
