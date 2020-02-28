package cn.itcyw.utils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @Description:httpClient工具类
 * @author tcy
 * @date 2020-02-27
 */
public class HttpClientUtil {
	/**
	 * 
	 * @Title: doGet
	 * @Description: 有参数的get请求
	 * @param url
	 * @param param
	 * @return
	 * @author tcy
	 * @date 2020-02-27
	 */
	public static String doGet(String url,Map<String, String> param) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			//创建uri
			URIBuilder uriBuilder = new URIBuilder(url);
			 if (param != null) {
	                for (String key : param.keySet()) {
	                    uriBuilder.addParameter(key, param.get(key));
	                }
	            }
			URI uri =uriBuilder.build();
			HttpGet httpGet = new HttpGet(uri);
			//执行请求
			response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
		return resultString;
	}
	/**
	 * 
	 * @Title: doGet
	 * @Description: 无参数的get请求
	 * @param url
	 * @return
	 * @author tcy
	 * @date 2020-02-27
	 */
	public static String doGet(String url) {
		return doGet(url,null);
	}
	/**
	 * 
	 * @Title: doPost
	 * @Description: 有参数的post请求
	 * @param url
	 * @param param
	 * @return
	 * @author tcy
	 * @date 2020-02-27
	 */
	 public static String doPost(String url, Map<String, String> param) {
	        // 创建Httpclient对象
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        CloseableHttpResponse response = null;
	        String resultString = "";
	        try {
	            // 创建Post请求
	            HttpPost httpPost = new HttpPost(url);
	            // 创建参数列表
	            if (param != null) {
	                List<NameValuePair> paramList = new ArrayList<>();
	                for (String key : param.keySet()) {
	                    paramList.add(new BasicNameValuePair(key, param.get(key)));
	                }
	                // 模拟表单
	                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");
	                httpPost.setEntity(entity);
	            }
	            // 执行请求
	            response = httpClient.execute(httpPost);
	            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                response.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return resultString;
	    }
	 /**
	  * 
	  * @Title: doPost
	  * @Description: 无参的post请求
	  * @param url
	  * @return
	  * @author tcy
	  * @date 2020-02-27
	  */
	 public static String doPost(String url) {
		 return doPost(url,null);
	 }
}
