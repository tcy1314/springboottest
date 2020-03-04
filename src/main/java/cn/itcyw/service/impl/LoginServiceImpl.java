package cn.itcyw.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.itcyw.model.dto.AccessTokenDTO;
import cn.itcyw.service.LoginService;
import cn.itcyw.utils.HttpClientUtil;

/**
 * @Description:
 * @author tcy
 * @date 2020-03-02
 */
@Service
public class LoginServiceImpl implements LoginService {
	@Value("${qq.client.id}")
	private String clientId;

	/**
	 * @Title: getAccessToken
	 * @Description: 获取accesstoken
	 * @param accessTokenDTO
	 * @return
	 * @see cn.itcyw.service.LoginService#getAccessToken(cn.itcyw.model.dto.AccessTokenDTO)
	 * @author tcy
	 * @date 2020-03-02
	 */
	@Override
	public String getAccessToken(AccessTokenDTO accessTokenDTO) {
		String accessToken = null;
		Map<String, String> map = new HashMap();
		map.put("client_id", accessTokenDTO.getClient_id());
		map.put("client_secret", accessTokenDTO.getClient_secret());
		map.put("code", accessTokenDTO.getCode());
		map.put("grant_type", accessTokenDTO.getGrant_type());
		map.put("redirect_uri", accessTokenDTO.getRedirect_uri());
		String callbackInfo = HttpClientUtil.doGet("https://graph.qq.com/oauth2.0/token", map);
		// access_token=64AB77EB87E89EE12AA3A3B986DF8DCB&expires_in=7776000&refresh_token=183890E959216CD47E7ACE17424EAC4E
		String[] strings = callbackInfo.split("&");
		for (String string : strings) {
			if (string.contains("access_token")) {
				String[] array = string.split("=");
				accessToken = array[1];
				break;
			}
		}
		return accessToken;
	}

	/**
	 * @Title: getOpenId
	 * @Description: 通过accesstoken获取openid
	 * @param accessToken
	 * @return
	 * @see cn.itcyw.service.LoginService#getOpenId(java.lang.String)
	 * @author tcy
	 * @date 2020-03-02
	 */
	@Override
	public String getOpenId(String accessToken) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("access_token", accessToken);
		// callback(
		// {"client_id":"101855214","openid":"10BEEEA4CBD9EE0976BFCE9176FA1A28"} );
		String access_token = HttpClientUtil.doGet("https://graph.qq.com/oauth2.0/me", map);
		String regex = "\\{.*\\}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(access_token);
		if (!matcher.find()) {
			throw new RuntimeException("异常的回调值: " + access_token);
		}
		JSONObject parseObject = JSONObject.parseObject(matcher.group(0));
		String openId = (String) parseObject.get("openid");

		return openId;
	}

	/**
	 * @Title: getNickname
	 * @Description:
	 * @param accessToken
	 * @param openId
	 * @return
	 * @see cn.itcyw.service.LoginService#getNickname(java.lang.String,
	 *      java.lang.String)
	 * @author tcy
	 * @date 2020-03-03
	 */
	@Override
	public String getNickname(String accessToken, String openId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("access_token", accessToken);
		map.put("openid", openId);
		map.put("oauth_consumer_key", clientId);
		JSONObject parseObject = JSONObject
				.parseObject(HttpClientUtil.doGet("https://graph.qq.com/user/get_user_info", map));
		String nickname = (String) parseObject.get("nickname");
		return nickname;
	}

}
