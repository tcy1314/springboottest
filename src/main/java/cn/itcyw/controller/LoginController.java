package cn.itcyw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**  
 * @Description:登录功能控制层 
 * @author tcy
 * @date 2020-02-06 
*/
@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
		
	}
}
