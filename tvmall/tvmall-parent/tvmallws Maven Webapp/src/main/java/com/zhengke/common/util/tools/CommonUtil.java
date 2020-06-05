package com.zhengke.common.util.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

public class CommonUtil {
	
	/**
	 * 生成UUID
	 * @return
	 */
	public static String createUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 生成字母数组随机组合
	 * @param length
	 * @return
	 */
	public static String createCharAndNum(int length)
	{     
	    String val = "";     
	             
	    Random random = new Random();     
	    for(int i = 0; i < length; i++)     
	    {     
	        String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字      
	                 
	        if("char".equalsIgnoreCase(charOrNum)) // 字符串      
	        {     
	            int choice = 97; //取得大写字母还是小写字母      
	            val += (char) (choice + random.nextInt(26));     
	        }     
	        else if("num".equalsIgnoreCase(charOrNum)) // 数字
	        {     
	            val += String.valueOf(random.nextInt(10));     
	        }     
	    }     
	    return val;     
	}
	
	/**
	 * CLOB转换成String	
	 * @param clob
	 * @return
	 */
	public static String clobToString(Clob clob) {
        String reString = "";
        Reader is = null;
        try {
        	if(clob!=null){
        		is = clob.getCharacterStream();
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 得到流
        BufferedReader br = new BufferedReader(is);
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
           
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        while (s != null) {
            //执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
            sb.append(s);
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        reString = sb.toString();
        return reString;
    }
	
	/**
	 * 是否全是数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 获取classes路径 
	 * @return classes路径
	 */
	public static String getClassesPath() {
		try {
			return Thread.currentThread().getContextClassLoader().getResource(
					"").toURI().getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 工具类方法测试
	 * 采用Java主方法运行测试
	 * @param args
	 */
	public static void main(String [] args){
		System.out.println(createUUID());
	}
}
