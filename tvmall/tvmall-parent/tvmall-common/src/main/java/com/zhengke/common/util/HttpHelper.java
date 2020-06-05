package com.zhengke.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.http.params.CoreConnectionPNames;
 

public class HttpHelper {
	 public static final String DEF_CHATSET = "UTF-8";
	    public static final int DEF_CONN_TIMEOUT = 30000;
	    public static final int DEF_READ_TIMEOUT = 30000;
	    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
	 	     
	    /**
	     * 发送请求
	     * @param strUrl 请求地址
	     * @param params 请求参数
	     * @param method 请求方法
	     * @return  网络请求字符串
	     * @throws Exception
	     */
	    public static String net(String strUrl, Map<String, Object> params,String method) throws Exception {
	        HttpURLConnection conn = null;
	        BufferedReader reader = null;
	        String rs = null;
	        try {
	            StringBuffer sb = new StringBuffer();
	            if(method==null || method.equals("GET")){
	                strUrl = strUrl+"?"+urlencode(params);
	            }
	            URL url = new URL(strUrl);
	            conn = (HttpURLConnection) url.openConnection();
	            if(method==null || method.equals("GET")){
	                conn.setRequestMethod("GET");
	            }else{
	                conn.setRequestMethod("POST");
	                conn.setDoOutput(true);
	            }
	            conn.setRequestProperty("User-agent", userAgent);
	            conn.setUseCaches(false);
	            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
	            conn.setReadTimeout(DEF_READ_TIMEOUT);
	            conn.setInstanceFollowRedirects(false);
	            conn.connect();
	           /* if (params!= null && method.equals("POST")) {
	                try (DataOutputStream out = new DataOutputStream(conn.getOutputStream())) {
	                    out.writeBytes(urlencode(params));
	                }
	            }*/
	            InputStream is = conn.getInputStream();
	            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
	            String strRead = null;
	            while ((strRead = reader.readLine()) != null) {
	                sb.append(strRead);
	            }
	            rs = sb.toString();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                reader.close();
	            }
	            if (conn != null) {
	                conn.disconnect();
	            }
	        }
	        return rs;
	    }
	 
	    //将map型转为请求参数型
	    public static String urlencode(Map<String, ?> data) {
	        StringBuilder sb = new StringBuilder();
	        for (Map.Entry<String, ?> i : data.entrySet()) {
	            try {
	                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
	            } catch (UnsupportedEncodingException e) {
	                e.printStackTrace();
	            }
	        }
	        return sb.toString();
	    }
	    
	    
	    /**
	     * 提交xml请求
	     * @return
	     */
		public static String postHttpRequestXml(String strUrl, String xmlStr){
	    	HttpClient client = new HttpClient();    
	        //创建post请求方法   
	        PostMethod myPost = new PostMethod(strUrl);    
	        //设置请求超时时间   	        
	        client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,DEF_CONN_TIMEOUT);
	        String responseString = null;
	        try{    
	            //设置请求头部类型   
	            myPost.setRequestHeader("Content-Type","text/xml");  
	            myPost.setRequestHeader("charset","utf-8");  
	            //RequestEntity reqEn = myPost.getRequestEntity();  
	            //设置请求体，即xml文本内容，注：这里写了两种方式，一种是直接获取xml内容字符串，一种是读取xml文件以流的形式   
	            //myPost.setRequestBody(xmlStr);   
	              
	            //InputStream body=this.getClass().getResourceAsStream("/"+xmlFileName);  
	            //myPost.setRequestBody(body);  
	            myPost.setRequestEntity(new StringRequestEntity(xmlStr,"text/xml","utf-8"));     
	            int statusCode = client.executeMethod(myPost);    
	            if(statusCode == HttpStatus.SC_OK){    
	                BufferedInputStream bis = new BufferedInputStream(myPost.getResponseBodyAsStream());    
	                byte[] bytes = new byte[1024];    
	                ByteArrayOutputStream bos = new ByteArrayOutputStream();    
	                int count = 0;    
	                while((count = bis.read(bytes))!= -1){    
	                    bos.write(bytes, 0, count);    
	                }    
	                byte[] strByte = bos.toByteArray();    
	                responseString = new String(strByte,0,strByte.length,"utf-8");    
	                bos.close();    
	                bis.close();    
	            }    
	        }catch (Exception e) {    
	            e.printStackTrace();    
	        }    
	        myPost.releaseConnection();    
	        return responseString;    
	    }
}
