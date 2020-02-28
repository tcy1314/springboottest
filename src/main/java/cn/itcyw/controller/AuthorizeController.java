package cn.itcyw.controller;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**  
 * @Description: 第三方授权处理
 * @author tcy
 * @date 2020-02-25 
*/
@Controller
public class AuthorizeController {
	
	@GetMapping("/callback")
	public String callback(@RequestParam(name="code") String code,@RequestParam(name="state") String state) {
        //1.打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.声明get请求
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        //https://graph.qq.com/oauth2.0/token?grant_type=authorization_code&client_id=101855214&client_secret=e7646834af004735477e48a7e20f6a18&code=
        //3.发送请求
        CloseableHttpResponse response;
		try {
			response = httpClient.execute(httpGet);
	        //4.判断状态码
	        if(response.getStatusLine().getStatusCode()==200){
	            HttpEntity entity = response.getEntity();
	           //使用工具类EntityUtils，从响应中取出实体表示的内容并转换成字符串
	            String string = EntityUtils.toString(entity, "utf-8");
	            System.out.println(string);
	        }
	        //5.关闭资源
	        response.close();
	        httpClient.close();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	//	System.out.println("state:"+state);
		return "index";
		
	}
}
