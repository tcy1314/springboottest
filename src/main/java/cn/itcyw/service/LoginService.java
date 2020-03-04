package cn.itcyw.service;

import cn.itcyw.model.dto.AccessTokenDTO;

/**  
 * @Description: 
 * @author tcy
 * @date 2020-03-02 
*/

public interface LoginService {
	
	/*
	 * 获取accesstoken
	 */
	String getAccessToken(AccessTokenDTO accessTokenDTO);
	/*
	 * 获取用户openid
	 */
	String getOpenId(String accessToken);
	/*
	 * 获取用户昵称
	 */
	String getNickname(String accessToken, String openId);
}
