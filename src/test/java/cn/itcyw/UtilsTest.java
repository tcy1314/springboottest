package cn.itcyw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;

/**  
 * @Description: 
 * @author tcy
 * @date 2020-02-27 
*/

public class UtilsTest {
	public static void main(String args[]) {
		//System.out.println(HttpClientUtil.doGet("http://www.itcyw.cn"));
		String info = "access_token=64AB77EB87E89EE12AA3A3B986DF8DCB&expires_in=7776000&refresh_token=183890E959216CD47E7ACE17424EAC4E";
		String[] strings = info.split("&");
		for (String string : strings) {
			if(string.contains("access_token")) {
				String[] splitStrings = string.split("=");
				String string2 = splitStrings[1];
			}
			
		}
		String access_token = "callback( {\"client_id\":\"101855214\",\"openid\":\"10BEEEA4CBD9EE0976BFCE9176FA1A28\"} );";
		long startTime = System.currentTimeMillis(); 
		//程序运行时间：291ms
		System.out.println(JSONObject.parseObject(access_token.replace(";", "").replace("callback", "").replace("(", "").replace(")", "")));
		long endTime = System.currentTimeMillis(); 
		System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
		
		    	
	    long startTime1 = System.currentTimeMillis(); 
	    //程序运行时间：1ms
	    String regex = "\\{.*\\}";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(access_token);
	    if(!matcher.find()){
	        throw new RuntimeException("异常的回调值: "+access_token);
	    }
	    String group = matcher.group(0);
	    System.out.println(group);
		long endTime1 = System.currentTimeMillis(); 
		System.out.println("程序运行时间：" + (endTime1 - startTime1) + "ms");

		
		
	}
}
