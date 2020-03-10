package cn.itcyw.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.itcyw.dto.AccessTokenDTO;
import cn.itcyw.service.LoginService;

/**  
 * @Description: 第三方授权处理
 * @author tcy
 * @date 2020-02-25 
*/
@Controller
public class AuthorizeController {
	@Value("${qq.client.id}")
	private String clientId;
	@Value("${qq.client.secret}")
	private String clientSecret;
	@Value("${qq.redirect.uri}")
	private String redirectURI;
	@Autowired
	private LoginService loginService;
	@GetMapping("/callback")
	public String callback(@RequestParam(name="code") String code,@RequestParam(name="state") String state,HttpServletRequest request) {
		AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
		accessTokenDTO.setClient_id(clientId);
		accessTokenDTO.setClient_secret(clientSecret);
		accessTokenDTO.setCode(code);
		accessTokenDTO.setGrant_type("authorization_code");
		accessTokenDTO.setRedirect_uri(redirectURI);
		String accessToken = loginService.getAccessToken(accessTokenDTO);
		String openId = loginService.getOpenId(accessToken);
		String nickname = loginService.getNickname(accessToken,openId);
		System.out.println(nickname);
		if(nickname!=null) {
			request.getSession().setAttribute("nickname", nickname);
			System.out.println(request.getSession().getAttribute("nickname"));
			return "redirect:/";
		}
		return "redirect:/";
		
	}
}
