package com.dept.web.general.util;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;


public class HttpClientUtil {
	
	public static String execute(String url, Map<String, String> map)  {
		HttpClient httpClient = null;
		PostMethod postMethod = null;
		
		try {
			httpClient = new HttpClient();
			postMethod = new PostMethod(url);
			
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
			
			for(Entry<String, String> e: map.entrySet()) {
				String key = "";
				String value = "";
				if(EncodeSwitch.getCurrentCode().equalsIgnoreCase("GBK")) {
					 key = new String(e.getKey().getBytes("GBK"));
					 value = new String(e.getValue().getBytes("GBK"));
				}else if(EncodeSwitch.getCurrentCode().equalsIgnoreCase("UTF-8")) {
					 key = new String(e.getKey().getBytes("UTF-8"));
					 value = new String(e.getValue().getBytes("UTF-8"));
				}else if(EncodeSwitch.getCurrentCode().equalsIgnoreCase("GB18030")) {
					key = new String(e.getKey().getBytes("GB18030"));
					 value = new String(e.getValue().getBytes("GB18030"));
				}
				postMethod.setParameter(key, value);
			}	
				
//			postMethod.setParameter("xml",map.get("xml"));
			
			// 执行postMethod
			int statusCode = 0;

			statusCode = httpClient.executeMethod(postMethod);
			
			

			// HttpClient对于要求接受后继服务的请求，象POST和PUT等不能自动处理转发 301或者302
			String resultStr = "";
			if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY || statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
			} else {
				resultStr = postMethod.getResponseBodyAsString();
			}
			return resultStr;

		} catch (HttpException httpException) {
			httpException.printStackTrace();
             
		} catch (IOException ioeException) {
			ioeException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				postMethod.releaseConnection(); // 关闭连接
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return null;
	}
	
	
}
