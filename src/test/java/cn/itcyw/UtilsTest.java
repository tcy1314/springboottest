package cn.itcyw;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import cn.itcyw.utils.HttpClientUtil;

/**  
 * @Description: 
 * @author tcy
 * @date 2020-02-27 
*/

public class UtilsTest {
	public static void main(String args[]) {
		System.out.println(HttpClientUtil.doGet("http://www.itcyw.cn"));
	}
}
