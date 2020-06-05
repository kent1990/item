package com.zhengke.common.util.tools;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class StringUtil {
	
	/*********************************************************
	* 函数名：CheckReplace
	* 作  用：转化SQL特殊字符串
	* 参  数：s: 字符串型，待转化的字符
	* 返回值：转化以后的字符串
	* 调　用：String s2 = CheckReplace(s1);
	***********************************************************/	
	public static String CheckReplace(String s) {
		try {
			if (s == null || s.equals(""))
				return "";
			else {
				StringBuffer stringbuffer = new StringBuffer();
				for (int i = 0; i < s.length(); i++) {
					char c = s.charAt(i);
					switch (c) {

					case 34: // '"'
						stringbuffer.append("&quot;");
						break;

					case 39: // '\''
						stringbuffer.append("&#039;");
						break;

					case 124: // '|'
						stringbuffer.append("");
						break;

					case '&':
						stringbuffer.append("&amp;");
						break;

					case '<':
						stringbuffer.append("&lt;");
						break;

					case '>':
						stringbuffer.append("&gt;");
						break;

					default:
						stringbuffer.append(c);
						break;
					}
				}
				return stringbuffer.toString().trim(); // 返回转化以后的字符串
			}
		} catch (Exception e) {
			return "";
		}
	}
	
	/**
	 * 手机号码判断
	 * @param carMobile
	 * @return
	 */
	public static boolean isMobileNumber(String carMobile) {
		if(carMobile==null){
			return false;
		}
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[^4,\\D])|(17[6-8]))\\d{8}$");
		Matcher m = p.matcher(carMobile);
		return m.matches();
	}

	/**
	 * String数组转String
	 * @param arr
	 * @param split
	 * @return
	 */
	public static String stringArrayToString(String[] arr,String split) {
		StringBuffer rtn = new StringBuffer();
		for(String s : arr) {
			rtn.append(s);
			rtn.append(split);
		}
		return rtn.substring(0, rtn.length() - 1);
	}
	
	/**
	 * 取字母加1
	 * @param letter
	 * @return
	 */
	public static String getNextLetter(String letter) {
		char[] temp = letter.toCharArray();
		char[] prefix = Arrays.copyOfRange(temp, 0, temp.length - 1);
		char last = temp[temp.length - 1];
		String suffix = null;
		if (last == 'Z') {
			suffix = "AA";
		} else {
			char nextChar = (char) ((int)last + 1);
			suffix = nextChar+"";
		}
		return String.valueOf(prefix) + suffix;
	}
	
	/**
	 * 4位字符串数字加1，不够4位前面补"0"
	 * @param arg
	 * @return
	 */
	public static String getNextNum(String arg) {
		int i = Integer.parseInt(arg);
		String tempId = "0000"+(i+1);		
		return tempId.substring(tempId.length() - 4);
	}
	
	/**
	 * 获取IP方式
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
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
	 * 生成随机验6位数
	 * @return
	 */
	public static String getRandomMa() {
		String randomNum = "";
		int num = 0;
		for (int i = 0; i < 6; i++) {
			num = (int) (Math.random() * 9) + 1;
			randomNum += num;
		}
		return randomNum;
	}
	
	/**
	 * 生成随机两位数
	 * @return
	 */
	public static String getRandomMa2(){
		String randomNum = "";
		int num = 0;
		for (int i = 0; i < 2; i++) {
			num =  (int)(Math.random()*9)+1;
			randomNum+=num;
		}
		return randomNum;
	}
	
	/**
	 * 生成随机8位数
	 * @return
	 */
	public static String getRandomMa8(){
		String randomNum = "";
		int num = 0;
		for (int i = 0; i < 8; i++) {
			num =  (int)(Math.random()*9)+1;
			randomNum+=num;
		}
		return randomNum;
	}	
	
	
	 /**
	  * MD5加码 生成32位md5码 
	  * @param inStr
	  * @return
	  */
    public static String str2MD5(String inStr){  
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5");  
        }catch (Exception e){  
            System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();  
    } 
    
   /**
    * main 方法测试
    * @param args
    */
    public static void main(String [] args){
    	
    }
}
