package cn.itcyw.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	@GetMapping("/loginByQQ")
	public void loginByQQ(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.sendRedirect("https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=101855214&redirect_uri=http://localhost/callback&scope=get_user_info&state=1");
	}
}
